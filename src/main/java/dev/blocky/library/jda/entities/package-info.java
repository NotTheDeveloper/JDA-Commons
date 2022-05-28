/**
 * Root package of the JDA-Common entities.
 *
 * <br> From here you can navigate to the Discord entities. <br>
 *
 * <ul>
 * <li>{@link dev.blocky.library.jda.entities.DirectMessageChannel Direct message channel}
 * <br> Represents the connection used for direct messaging. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildMember Guild member}
 * <br> Represents a guild-specific {@link net.dv8tion.jda.api.entities.User user}. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildMessageChannel Guild message channel}
 * <br> Represents a Discord channel that can have {@link net.dv8tion.jda.api.entities.Message messages} and files sent to it. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildNewsChannel Guild news channel}
 * <br> Represents {@link net.dv8tion.jda.api.entities.BaseGuildMessageChannel base guild message channel} that are
 * {@link net.dv8tion.jda.api.entities.NewsChannel news channels}. The Discord client may refer to these as announcement channels.
 * Members can subscribe channels in their own {@link net.dv8tion.jda.api.entities.Guild guilds} to receive
 * {@link net.dv8tion.jda.api.entities.Message messages} cross-posted from this channel. This is referred to as following this channel.
 * {@link net.dv8tion.jda.api.entities.Message messages} sent in this channel can be cross-posted, at which point they will be sent
 * (via {@link net.dv8tion.jda.api.entities.Webhook webhook}) to all subscribed channels. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildTargetMember  Guild target member}
 * <br> Represents the {@link net.dv8tion.jda.api.entities.Member member} instance for the target
 * {@link net.dv8tion.jda.api.entities.User user}. </li>
 *
 * <li> {@link dev.blocky.library.jda.entities.GuildTextChannel Guild text channel}
 * <br> Represents a Discord text {@link net.dv8tion.jda.api.entities.GuildChannel guild channel}. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildThreadChannel  Guild thread channel}
 * <br> Represents private/public/news {@link net.dv8tion.jda.api.entities.ThreadChannel thread channels}. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.GuildThreadMember  Guild thread member}
 * <br> Represents a {@link net.dv8tion.jda.api.entities.Member member}, who joined a
 * {@link net.dv8tion.jda.api.entities.ThreadChannel thread channel}. </li>
 *
 * <li>{@link dev.blocky.library.jda.entities.SelfMember  Self member}
 * <br> Represents the self member (aka. the bot itself) of a specific {@link net.dv8tion.jda.api.entities.Guild guild}. </li>
 * </ul>
 */
package dev.blocky.library.jda.entities;
