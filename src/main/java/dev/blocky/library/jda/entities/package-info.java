/**
 * Root package of the JDA-Common Entities.
 *
 * <br>
 * From here you can navigate to the Discord Entities, which are made by this library.
 * <br>
 *
 * <ul>
 * <li>{@link dev.blocky.library.jda.entities.DirectMessageChannel Direct Message Channel} <br>
 * Represents the connection used for direct messaging. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildMember Guild Member} <br>
 * Represents a Guild-specific {@link net.dv8tion.jda.api.entities.User User}. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildMessageChannel Guild Message Channel} <br>
 * Represents a Discord channel that can have {@link net.dv8tion.jda.api.entities.Message Messages}
 * and files sent to it. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildNewsChannel Guild News Channel} <br>
 * Represents {@link net.dv8tion.jda.api.entities.BaseGuildMessageChannel Base Guild Message Channel} that are
 * {@link net.dv8tion.jda.api.entities.NewsChannel News Channels}.  The Discord client may refer to these as Announcement Channels.
 * Members can subscribe channels in their own {@link net.dv8tion.jda.api.entities.Guild guilds} to receive
 * {@link net.dv8tion.jda.api.entities.Message messages} cross-posted from this channel. This is referred to as following this channel.
 * {@link net.dv8tion.jda.api.entities.Message Messages} sent in this channel can be cross-posted, at which point they will be sent
 * (via {@link net.dv8tion.jda.api.entities.Webhook webhook}) to all subscribed channels. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildTargetMember  Guild Target Member} <br>
 * Represents the {@link net.dv8tion.jda.api.entities.Member member} instance for the target
 * {@link net.dv8tion.jda.api.entities.User User}. </li>
 *
 * <li> {@link dev.blocky.library.jda.entities.GuildTextChannel Guild Text Channel} <br>
 * Represents a Discord Text {@link net.dv8tion.jda.api.entities.GuildChannel Guild Channel}. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildThreadChannel  Guild Thread Channel} <br>
 * Represents private/public/news {@link net.dv8tion.jda.api.entities.ThreadChannel Thread Channels}. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildThreadMember  Guild Thread Member} <br>
 * Represents a {@link net.dv8tion.jda.api.entities.Member Member}, who joined a
 * {@link net.dv8tion.jda.api.entities.ThreadChannel Thread Channel}. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.SelfMember  Self Member} <br>
 * Represents the Self Member (aka. the bot itself) of a specific {@link net.dv8tion.jda.api.entities.Guild Guild}. </li>
 * </ul>
 */
package dev.blocky.library.jda.entities;
