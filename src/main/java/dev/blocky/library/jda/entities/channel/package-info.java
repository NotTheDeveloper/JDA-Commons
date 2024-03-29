/**
 * Root package of the JDA-Common channel entities.
 * <br>From here you can navigate to the Discord channel entities.
 *
 * <ul>
 * <li>{@link dev.blocky.library.jda.entities.channel.ChannelUtils}
 * <br>This is an interface, which has many utility methods for every channel class in it.</li>
 *
 * <li>{@link dev.blocky.library.jda.entities.channel.DirectMessageChannel}
 * <br>Represents the connection used for direct-messaging.</li>
 *
 * <li>{@link dev.blocky.library.jda.entities.channel.GuildMessageChannel}
 * <br>Represents a Discord channel that can have {@link net.dv8tion.jda.api.entities.Message messages} and files sent to it.</li>
 *
 * <li>{@link dev.blocky.library.jda.entities.channel.GuildNewsChannel}
 * <br>Represents {@link net.dv8tion.jda.api.entities.channel.middleman.StandardGuildMessageChannel StandardGuildMessageChannel} that are
 * {@link net.dv8tion.jda.api.entities.channel.concrete.NewsChannel NewsChannel}.
 * <br>The Discord client may refer to these as announcement channels.
 * <br>Members can subscribe channels in their own {@link net.dv8tion.jda.api.entities.Guild Guild} to receive
 * {@link net.dv8tion.jda.api.entities.Message messages} cross-posted from this channel.
 * <br>This is referred to as following this channel.
 * <br>{@link net.dv8tion.jda.api.entities.Message Messages} sent in this channel can be cross-posted, at which point they will be sent
 * (via {@link net.dv8tion.jda.api.entities.Webhook Webhook}) to all subscribed channels.</li>
 *
 * <li> {@link dev.blocky.library.jda.entities.channel.GuildTextChannel}
 * <br>Represents a Discord text {@link net.dv8tion.jda.api.entities.channel.middleman.GuildChannel GuildChannel}.</li>
 *
 * <li>{@link dev.blocky.library.jda.entities.channel.GuildThreadChannel}
 * <br>Represents private/public/news Discord {@link net.dv8tion.jda.api.entities.channel.concrete.ThreadChannel ThreadChannel}.</li>
 *
 * <li>{@link dev.blocky.library.jda.entities.channel.GuildVoiceChannel}
 * <br>Represents a Discord voice {@link net.dv8tion.jda.api.entities.channel.middleman.GuildChannel GuildChannel}.
 * <br>Adds additional information specific to {@link net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel VoiceChannels} in Discord.</li>
 * </ul>
 */
package dev.blocky.library.jda.entities.channel;
