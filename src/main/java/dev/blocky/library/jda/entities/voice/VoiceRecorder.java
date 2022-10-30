/**
 * Copyright 2022 Dominic R. (aka. BlockyDotJar), Emil (aka. TheDesignCraftYT) and nurkaapii
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.blocky.library.jda.entities.voice;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.audio.AudioReceiveHandler;
import net.dv8tion.jda.api.audio.CombinedAudio;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.internal.audio.AudioConnection;
import net.dv8tion.jda.internal.utils.Checks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <b>PLEASE NOTE: Only use this feature to record conversations with the consent of all users in the channel.
 * <br>Recording a conversation against other users' consent is illegal, and you are violating the Discord Terms of Service.</b>
 *
 * <p>This class is used to record audio from a {@link VoiceChannel}.
 *
 * @author BlockyDotJar
 * @version v1.0.1
 * @since v1.1.6
 */
public class VoiceRecorder implements AudioReceiveHandler
{
    /**
     * The {@link ConcurrentLinkedQueue} to add {@link File} information to.
     */
    public static final ConcurrentLinkedQueue<byte[]> receivedBytes = new ConcurrentLinkedQueue<>();
    private boolean shouldStack = false;
    private AudioManager audioManager;
    private double volume = 1.0;
    private Guild guild;

    private VoiceRecorder()
    {
    }

    /**
     * Represents a <b>new</b> {@link VoiceRecorder} instance.
     *
     * @return A <b>new</b> {@link VoiceRecorder} instance
     */
    @NotNull
    public static VoiceRecorder newRecorder()
    {
        return new VoiceRecorder();
    }

    /**
     * Sets the volume of the recorded audio.
     * <br>If the volume isn't set the volume will be automatically set to 1.0.
     * <br>This method should only be used if the value is greater or smaller than 1.0.
     *
     * @param volume The volume of the audio to be recorded.
     *
     * @return The current instance of the {@link VoiceRecorder} class.
     */
    @NotNull
    public VoiceRecorder setVolume(double volume)
    {
        Checks.check(volume > 0, "volume may not be negative");
        this.volume = volume;
        return this;
    }

    /**
     * Sets the {@link AudioReceiveHandler} that the {@link AudioManager} will use to
     * process audio data received from an {@link AudioConnection}.
     * <br>The handler provided here will persist between {@link AudioConnection} connect and disconnects.
     * <br>Furthermore, you don't need to have an {@link AudioConnection} to set a handler.
     * <br>When {@link JDA} sets up a <b>new</b> {@link AudioConnection} it will use the handler provided here.
     * <br>Setting this to {@code null} will remove the {@link AudioReceiveHandler}.
     *
     * @param guild The {@link Guild} to receive the audio from.
     *
     * @return The current instance of the {@link VoiceRecorder} class.
     */
    @NotNull
    public VoiceRecorder setReceivingHandler(@NotNull Guild guild)
    {
        final AudioManager audioManager = guild.getAudioManager();
        audioManager.setReceivingHandler(this);

        this.audioManager = audioManager;
        this.guild = guild;

        return this;
    }

    /**
     * Sets if the audio should be stacked or not.
     * <br>This means that you set, if the audio will or will not be removed from the {@link ConcurrentLinkedQueue}
     * when the recording is finished.
     * <br>This is useful if you want to record multiple conversations in one audio file.
     * <br>If you want that the audio will be removed from the queue and thus with each join the audio file will be reinitialized, set this to {@code false}.
     * <br>If the boolean isn't set this will be automatically set to {@code false}.
     * <br>This method should only be used if the value is {@code true}.
     *
     * @param shouldStack Whether the audio should be stacked.
     *
     * @return The current instance of the {@link VoiceRecorder} class.
     */
    @NotNull
    public VoiceRecorder shouldStack(boolean shouldStack)
    {
        this.shouldStack = shouldStack;
        return this;
    }

    /**
     * <b>PLEASE NOTE: Only use this feature to record conversations with the consent of all users in the channel.
     * <br>Recording a conversation against other users' consent is illegal, and you are violating the Discord Terms of Service.</b>
     *
     * <p>This method will start recording audio from the {@link VoiceChannel} that the bot is currently in.
     * <br>This method will return a {@link File} that contains the audio that was recorded.
     *
     * <p>This is recommended to use, when the {@link User} leaves the channel.
     * <br>Note that the {@link AudioConnection} should be closed before this method is called.
     *
     * <p>This method supports any kind of audio file.
     * <br>Following audio file-formats are tested:
     * <br>- {@code .wav}
     * <br>- {@code .mp3}
     * <br>- {@code .ogg}
     * <br>- {@code .opus}
     * <br>- {@code .m4a}
     *
     * @param file The {@link File} to save the audio to.
     * @param sampleRate The number of samples per second.
     *
     * @return The {@link File} that the audio was saved to.
     */
    @NotNull
    @CanIgnoreReturnValue
    public File createRecording(@NotNull File file, float sampleRate)
    {
        try
        {
            int size = 0;

            for (byte[] ba : receivedBytes)
            {
                size += ba.length;
            }

            final byte[] decodedData = new byte[size];

            int i = 0;

            for (byte[] ba : receivedBytes)
            {
                for (byte b : ba)
                {
                    decodedData[i++] = b;
                }
            }

            if (!file.exists())
            {
                file.createNewFile();
                writeWavFile(file, decodedData, sampleRate);
            }
            else
            {
                writeWavFile(file, decodedData, sampleRate);
            }

            if (!stackEnabled())
            {
                receivedBytes.clear();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * <b>PLEASE NOTE: Only use this feature to record conversations with the consent of all users in the channel.
     * <br>Recording a conversation against other users' consent is illegal, and you are violating the Discord Terms of Service.</b>
     *
     * <p>This method will start recording audio from the {@link VoiceChannel} that the bot is currently in.
     * <br>This method will return a {@link File} that contains the audio that was recorded.
     *
     * <p>This is recommended to use, when the {@link User} leaves the channel.
     * <br>Note that the {@link AudioConnection} should be closed before this method is called.
     *
     * <p>The sample rate of this method equals 48000, but if you need a different sample rate use {@link VoiceRecorder#createRecording(File, float)}
     * instead.
     *
     * <p>This method supports any kind of audio file.
     * <br>Following audio file-formats are tested:
     * <br>- {@code .wav}
     * <br>- {@code .mp3}
     * <br>- {@code .ogg}
     * <br>- {@code .opus}
     * <br>- {@code .m4a}
     *
     * @param file The {@link File} to save the audio to.
     *
     * @return The {@link File} that the audio was saved to.
     */
    @NotNull
    @CanIgnoreReturnValue
    public File createRecording(@NotNull File file)
    {
        return createRecording(file, 48000);
    }

    /**
     * Gets the current volume of the audio.
     * <br>This is the volume of the audio that will be recorded.
     * <br>If the volume isn't set the volume will be automatically set to 1.0.
     *
     * @return The current volume of the audio as a double.
     */
    public double getVolume()
    {
        return volume;
    }

    /**
     * The {@link AudioManager} that represents the {@link AudioConnection} for this {@link Guild}.
     * <br>If no {@link AudioManager} exists for this {@link Guild}, this will create a <b>new</b> one.
     * <br>This operation is {@code synchronized} on all {@link AudioManager} for this {@link JDA} instance, this means
     * that calling {@code getAudioManager()} on any other {@link Guild} while a thread is accessing this method may be locked.
     *
     * @return The {@link AudioManager} for this {@link Guild}.
     */
    @Nullable
    @CheckReturnValue
    public AudioManager getAudioManager()
    {
        return audioManager;
    }

    /**
     * The {@link Guild}, the message was received in.
     *
     * @return The {@link Guild}, the message was received in.
     */
    @Nullable
    @CheckReturnValue
    public Guild getGuild()
    {
        return guild;
    }

    /**
     * If the audio should be stacked or not.
     * <br>This means that you set, if the audio will or will not be removed from the {@link ConcurrentLinkedQueue}
     * when the recording is finished.
     *
     * @return <b>true</b> - If the audio should be stacked.
     *         <br><b>false</b> - If the audio should be removed from the queue.
     */
    public boolean stackEnabled()
    {
        return shouldStack;
    }

    private void writeWavFile(@NotNull File outFile, byte[] decodedData, float sampleRate) throws IOException
    {
        Checks.check(sampleRate > 0, "sampleRate may not be negative");

        if (sampleRate > 48000)
        {
            throw new IllegalStateException("sampleRate may not be over 48000");
        }

        final AudioFormat format = new AudioFormat(
                sampleRate,
                16,
                2,
                true,
                true
        );

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decodedData);
        final AudioInputStream audioInputStream = new AudioInputStream(byteArrayInputStream, format, decodedData.length);

        AudioSystem.write(
                audioInputStream,
                AudioFileFormat.Type.WAVE,
                outFile);
    }

    @Override
    public boolean canReceiveCombined()
    {
        return true;
    }

    @Override
    public boolean canReceiveUser()
    {
        return false;
    }

    @Override
    public void handleCombinedAudio(@NotNull CombinedAudio combinedAudio)
    {
        receivedBytes.add(combinedAudio.getAudioData(volume));
    }

    @Override
    public boolean equals(@Nullable Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        final VoiceRecorder that = (VoiceRecorder) o;

        return shouldStack == that.shouldStack && Double.compare(that.volume, volume) == 0 &&
                Objects.equals(audioManager, that.audioManager) && Objects.equals(guild, that.guild);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(shouldStack, audioManager, volume, guild);
    }

    @NotNull
    @Override
    public String toString()
    {
        return "VoiceRecorder{" +
                "shouldStack=" + shouldStack +
                ", audioManager=" + audioManager +
                ", volume=" + volume +
                ", guild=" + guild +
                '}';
    }
}
