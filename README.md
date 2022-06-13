[github-packages]: https://img.shields.io/github/v/release/BlockyDotJar/JDA-Commons

[license-shield]: https://img.shields.io/badge/License-Apache%202.0-white.svg
[license]: https://github.com/BlockyDotJar/JDA-Commons/tree/main/LICENSE

[discord-invite-shield]: https://discord.com/api/guilds/876766868864647188/widget.png
[discord-invite]: https://discord.gg/FnGFbzCw2r

[download]: #download

# JDA-C (Java Discord API-Commons)

[ ![github-packages][] ][download]
[ ![license-shield][] ][license]
[ ![discord-invite-shield][] ][discord-invite]

**What is the Java Discord API (JDA)?**
<br>
JDA strives to provide a clean and full wrapping of the Discord REST API and its websocket-events for Java. This library is a helpful tool that provides the functionality to create a Discord bot in Java.
<br><br>
**OK but what is the Java Discord API-Commons (JDA-C) library now?**
<br>
The JDA-Commons lib is only a little extension to the JDA library, which adds lots of utility methods to the original library.

## Summary

1. [Introduction](#introduction)
2. [Download](#download)
3. [Documentation](#documentation)
4. [Support](#getting-help)
5. [Other extensions and plugins](#third-party-recommendations)
6. [Dependencies](#dependencies)
7. [Other libraries](#jda-related-projects)

## User- and Selfbots

Discord is currently prohibiting creation and usage of automated client accounts. <br>
Because of this, this library will never support this kind of client accounts. <br>
If you need a bot, use a bot account from the [application dashboard](https://discord.com/developers/applications).

[Read more](https://support.discord.com/hc/en-us/articles/115002192352-Automated-user-accounts-self-bots-)

## Introduction

There is not much to write about introducing you to this library, because this is only an extension to the original library, but you should read [the introduction to JDA](https://github.com/DV8FromTheWorld/JDA#creating-the-jda-object).

[Click here](https://github.com/BlockyDotJar/JDA-Commons/wiki/JDA-Commons-Documentation) to get to the wiki, where you can find, all the documentations of JDA-C.

## Download

[ ![github-packages][] ](https://github.com/BlockyDotJar/JDA-Commons/packages/1365003)

Latest release: [GitHub Release](https://github.com/BlockyDotJar/JDA-Commons/releases/latest) <br>

Be sure to replace the **`${VERSION}`** key below with the one of the versions shown above!

**Maven**

First you should create a `settings.xml` and add this to it: <br>
Be sure to replace the **`GITHUB_USERNAME`** key below with your GitHub username and **`TOKEN`** with a [GitHub token](https://docs.github.com/en/enterprise-server@3.4/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)!

```xml
<servers>
  <server>
    <id>github</id>
    <username>GITHUB_USERNAME</username>
    <password>TOKEN</password>
  </server>
</servers>
```

After that you add this repository and dependency to your `pom.xml`:

```xml
<repositories>
  <repository>
    <id>github</id>
    <name>GitHub BlockyDotJar Apache Maven Packages</name>
    <url>https://maven.pkg.github.com/BlockyDotJar/JDA-Commons</url>
  </repository>
</repositories>
```

```xml
<dependencies>
  <dependency>
    <groupId>dev.blocky.library</groupId>
    <artifactId>jda-commons</artifactId>
    <version>${VERSION}</version>
  </dependency>
</dependencies>
```

**Gradle**

Gradle is **not supported yet**, but this will be changed **in the future**.

### Logging framework - SLF4J

The JDA and the JDA-C libraries are using [SLF4J](https://www.slf4j.org/) to log its messages.

That means you should add some SLF4J implementation to your build path in addition to JDA and JDA-C.
If no implementation is found, following message will be printed to the console on startup:

```php
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
```

JDA and JDA-C are currently providing a fallback logger in case that no SLF4J implementation is present.
We strongly recommend to use one though, as that can improve speed and allows you to customize the logger as well as logging to some files.

There is a guide for `logback-classic` available in the JDA wiki: [Logging setup](https://github.com/DV8FromTheWorld/JDA/wiki/Logging-Setup)

## Documentation

Docs can be found on [our GitHub io page](https://BlockyDotJar.github.io/JDA-Commons) or in the [wiki](https://github.com/BlockyDotJar/JDA-Commons/wiki/JDA-Commons-Documentation).
<br>
A simple wiki about JDA can also be found in whose repository's [Wiki section](https://github.com/DV8FromTheWorld/JDA/wiki).

## Getting Help

For general troubleshooting you can visit our wiki [troubleshooting](https://github.com/DV8FromTheWorld/JDA/wiki/19%29-Troubleshooting) and [FAQ](https://github.com/DV8FromTheWorld/JDA/wiki/10%29-FAQ).
<br>
If you need help, or just want to talk with the JDA-C or other devs, you can join the [support server][discord-invite].

For guides and setup help you can also take a look at the [JDA wiki](https://github.com/DV8FromTheWorld/JDA/wiki) or [our wiki](https://github.com/BlockyDotJar/JDA-Commons/wiki)
<br>Especially interesting are the [getting started](https://github.com/DV8FromTheWorld/JDA/wiki/3%29-Getting-Started) and the [JDA setup](https://github.com/DV8FromTheWorld/JDA/wiki/2%29-Setup) pages, but also the [complete documentation](https://github.com/BlockyDotJar/JDA-Commons/wiki/JDA-Commons-Documentation) of JDA-C.

## Third party recommendations

### [LavaPlayer](https://github.com/sedmelluq/lavaplayer)

Created and maintained by [sedmelluq](https://github.com/sedmelluq)
<br>LavaPlayer is the most popular library used by music bots created in Java.
It is highly compatible with JDA and Discord4J and allows to play audio from
YouTube, SoundCloud, Twitch, Bandcamp and [more providers](https://github.com/sedmelluq/lavaplayer#supported-formats).
<br>The library can easily be expanded to more services by implementing your own `AudioSourceManager` and registering it.

It is recommended to read the [usage](https://github.com/sedmelluq/lavaplayer#usage) section of LavaPlayer
to understand a proper implementation.
<br>Sedmelluq provided a demo in his repository which presents an example implementation for JDA:
https://github.com/sedmelluq/lavaplayer/tree/master/demo-jda

### [Lavalink](https://github.com/freyacodes/Lavalink)

Maintained by [Freya Arbjerg](https://github.com/freyacodes).

Lavalink is a popular standalone audio sending node based on Lavaplayer. Lavalink was built with scalability in mind,
and allows streaming music via many servers. It supports most of Lavaplayer's features.

Lavalink is used by many large bots, as well as bot developers who can not use a Java library like Lavaplayer.
If you plan on serving music on a smaller scale with JDA it is often preferable to just use Lavaplayer directly
as it is easier.

[Lavalink-client](https://github.com/FredBoat/Lavalink-Client) is the official Lavalink client for JDA.


### [JDA-nas](https://github.com/sedmelluq/jda-nas)

Created and maintained by [sedmelluq](https://github.com/sedmelluq).
<br>Provides a native implementation for the JDA audio send-system to avoid GC pauses.

Note that this send-system creates an extra UDP-client which causes audio receive to no longer function properly
since discord identifies the sending UDP-client as the receiver.

```java
JDABuilder builder = JDABuilder.createDefault(BOT_TOKEN)
    .setAudioSendFactory(new NativeAudioSendFactory());
```

### [JDA-ktx](https://github.com/MinnDevelopment/jda-ktx)

Created and maintained by [MinnDevelopment](https://github.com/MinnDevelopment).
<br>Provides [Kotlin](https://kotlinlang.org/) extensions for `RestAction` and events that provide a more idiomatic Kotlin experience.

```kotlin
fun main() {
    val jda = light(BOT_TOKEN)
    
    jda.onCommand("ping") { event ->
        val time = measureTime {
            event.reply("Pong!").await() // suspending
        }.inWholeMilliseconds

        event.hook.editOriginal("Pong: $time ms").queue()
    }
}
```

There is a number of examples available in the [README](https://github.com/MinnDevelopment/jda-ktx/#jda-ktx).

------

More can be found in the GitHub organization: [JDA-Applications](https://github.com/JDA-Applications)

## Dependencies:

This project requires **Java 8+**

* JDA (Java Discord API)
    * Version: **v5.0.0-alpha.12**
    * [Github](https://github.com/DV8FromTheWorld/JDA)
* slf4j-api
    * Version: **v1.7.36**
    * [Github](https://github.com/qos-ch/slf4j)
* logback-classic
    * Version: **v1.2.11**
    * [Github](https://github.com/qos-ch/logback)

These are only the libraries, which we have in our [pom.xml](https://github.com/BlockyDotJar/JDA-Commons/blob/main/pom.xml), but we are using [all libraries](https://github.com/DV8FromTheWorld/JDA#dependencies), which the original JDA uses too.

## JDA related projects

- [Discord.NET](https://github.com/discord-net/Discord.Net)
- [discord.py](https://github.com/Rapptz/discord.py)
- [discord.js](https://github.com/discordjs/discord.js)
- [Serenity](https://github.com/serenity-rs/serenity)

**See also:** https://discord.com/developers/docs/topics/community-resources#libraries 

