/**
 * Root package of the JDA-Common channel entities.
 *
 * <br>From here you can navigate to the Discord channel entities. <br>
 *
 * <ul>
 * <li>{@link dev.blocky.library.jda.entities.channel.DirectMessageChannel Direct-message channel}
 * <br>Represents the connection used for direct-messaging. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.channel.GuildMessageChannel Guild message channel}
 * <br>Represents a Discord channel that can have {@link net.dv8tion.jda.api.entities.Message messages} and files sent to it. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.channel.GuildNewsChannel Guild news channel}
 * <br>Represents {@link net.dv8tion.jda.api.entities.StandardGuildMessageChannel standard guild message channel} that are
 * {@link net.dv8tion.jda.api.entities.NewsChannel news channels}. The Discord client may refer to these as announcement channels.
 * Members can subscribe channels in their own {@link net.dv8tion.jda.api.entities.Guild guilds} to receive
 * {@link net.dv8tion.jda.api.entities.Message messages} cross-posted from this channel. This is referred to as following this channel.
 * {@link net.dv8tion.jda.api.entities.Message Messages} sent in this channel can be cross-posted, at which point they will be sent
 * (via {@link net.dv8tion.jda.api.entities.Webhook webhook}) to all subscribed channels. </li>
 *
 * <li> {@link dev.blocky.library.jda.entities.channel.GuildTextChannel Guild text channel}
 * <br>Represents a Discord text {@link net.dv8tion.jda.api.entities.GuildChannel guild channel}. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.channel.GuildThreadChannel  Guild thread channel}
 * <br>Represents private/public/news Discord {@link net.dv8tion.jda.api.entities.ThreadChannel thread channel}. </li>
 * </ul>
 */
package dev.blocky.library.jda.entities.channel;