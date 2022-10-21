[github-packages-shield]: https://img.shields.io/github/v/release/BlockyDotJar/JDA-Commons
[github-packages]: https://github.com/BlockyDotJar/JDA-Commons/packages/1365003

[license-shield]: https://img.shields.io/badge/License-Apache%202.0-white.svg
[license]: https://github.com/BlockyDotJar/JDA-Commons/tree/main/LICENSE

[discord-invite-shield]: https://discord.com/api/guilds/876766868864647188/widget.png
[discord-invite]: https://discord.gg/mYKK4BwGxe

[download]: #download

# JDA-C (JDA-Commons)

[ ![github-packages-shield][] ][download] [ ![license-shield][] ][license] [ ![discord-invite-shield][] ][discord-invite]

**What is the JDA (Java Discord API)?**

JDA strives to provide a clean and full wrapping of the Discord REST API and its websocket-events for Java. This library is a helpful tool that provides the functionality to create a Discord bot in Java.

**OK but what is the JDA-C (JDA-Commons) library now?**

The JDA-Commons library is only a little extension to the JDA library, which adds lots of utility methods and classes to the original library.

## Summary

1. [Introduction](#introduction)
2. [Download](#download)
3. [Documentation](#documentation)
4. [Support](#getting-help)
5. [Other extensions and plugins](#third-party-recommendations)
6. [Contributing](#contribution)
7. [Dependencies](#dependencies)
8. [Other libraries](#jda-related-projects)

## User- and Self- bots

Discord is currently prohibiting creation and usage of automated client accounts.
<br>Because of this, this library will never support this kind of client accounts.
<br>If you need a bot, use a bot account from the [application dashboard](https://discord.com/developers/applications).

[Read more here](https://support.discord.com/hc/en-us/articles/115002192352-Automated-user-accounts-self-bots-).

## Introduction

This is only an extension to the original library, but you should definitely read [the introduction to JDA](https://jda.wiki/introduction/jda/).
<br>[Click here](https://BlockyDotJar.github.io/JDA-Commons) to get to the github.io page, where you can find, all the documentations of JDA-C.

## Download

[ ![github-packages-shield][] ][github-packages]

Find the latest GitHub release [here](https://github.com/BlockyDotJar/JDA-Commons/releases/latest).

Be sure to replace the **`VERSION`** key below with the one of the versions shown above!

### Maven

First you should create a `settings.xml` and add this to it:
<br>Be sure to replace the **`GITHUB_USERNAME`** key below with your GitHub username and **`GITHUB_TOKEN`** with a [GitHub token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)!

```xml
<servers>
  <server>
    <id>github</id>
    <username>GITHUB_USERNAME</username>
    <password>GITHUB_TOKEN</password>
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
    <version>VERSION</version>
  </dependency>
</dependencies>
```

### Gradle

Be sure to replace the **`GITHUB_USERNAME`** key below with your GitHub username and **`GITHUB_TOKEN`** with a [GitHub token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)!

**Gradle Groovy:**

```gradle
repositories {
    maven {
        url = uri 'https://maven.pkg.github.com/BlockyDotJar/JDA-Commons'
        credentials {
            username = project.findProperty('gpr.user') ?: 'GITHUB_USERNAME'
            password = project.findProperty('gpr.key') ?: 'GITHUB_TOKEN'
        }
    }
}
```

```gradle
dependencies {
    implementation 'dev.blocky.library:jda-commons:VERSION'
}
```

**Kotlin DSL:**

```gradle
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/BlockyDotJar/JDA-Commons")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: "GITHUB_USERNAME"
            password = project.findProperty("gpr.key") as String? ?: "GITHUB_TOKEN"
        }
    }
}
```

```gradle
dependencies {
    implementation("dev.blocky.library:jda-commons:VERSION")
}
```

### Logging framework - SLF4J

The JDA and the JDA-C libraries are using [SLF4J](https://www.slf4j.org/) to log its messages.

That means you should add some SLF4J implementation to your build path in addition to JDA and JDA-C.
If no implementation is found, following message will be printed to the console on startup:

```php
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#noProviders for further details.
```

Or if you use an outdated version of it, something like this will appear in your console:

```php
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#noProviders for further details.
SLF4J: Class path contains SLF4J bindings targeting slf4j-api versions prior to 1.8.
SLF4J: Ignoring binding found at [jar:file:/C:/Users/UserName/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-classic/1.2.11/4741689214e9d1e8408b206506cbe76d1c6a7d60/logback-classic-1.2.11.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#ignoredBindings for an explanation.
```

JDA and JDA-C are currently providing a fallback logger in case that no SLF4J implementation is present.
We strongly recommend to use one though, as that can improve speed and allows you to customize the logger as well as logging to some files.

There is a guide for logback-classic available at our wiki: [Logging Setup](https://github.com/BlockyDotJar/JDA-Commons/wiki/Logging-Setup).

## Documentation

Docs can be found on [our GitHub io page](https://BlockyDotJar.github.io/JDA-Commons).
<br>A simple wiki of the JDA can also be found at [jda.wiki](https://jda.wiki/).

## Getting help

For general troubleshooting you can visit JDA's wiki [troubleshooting](https://jda.wiki/using-jda/troubleshooting/) and [FAQ](https://jda.wiki/introduction/faq/).
<br>If you need help, or just want to talk with the JDA-C or other devs, you can join the [support server][discord-invite].

For guides and setup help you can also take a look at the [JDA wiki](https://jda.wiki/) or [our github.io page](https://BlockyDotJar.github.io/JDA-Commons).
<br>Especially interesting are the [getting started](https://jda.wiki/introduction/jda/) and the [JDA setup](https://jda.wiki/setup/intellij/) pages, but also the [complete documentation](https://BlockyDotJar.github.io/JDA-Commons) of JDA-C.

## Third party recommendations

### [LavaPlayer](https://github.com/sedmelluq/lavaplayer)

Created and maintained by [sedmelluq](https://github.com/sedmelluq).
<br>LavaPlayer is the most popular library used by music bots created in Java.
It is highly compatible with JDA and Discord4J and allows to play audio from
YouTube, SoundCloud, Twitch, Bandcamp and [more providers](https://github.com/sedmelluq/lavaplayer#supported-formats).
<br>The library can easily be expanded to more services by implementing your own `AudioSourceManager` and registering it.

It is recommended to read the [usage](https://github.com/sedmelluq/lavaplayer#usage) section of LavaPlayer
to understand a proper implementation.
<br>Sedmelluq provided a [demo](https://github.com/sedmelluq/lavaplayer/tree/master/demo-jda) in his repository which presents an example implementation for JDA.

### [Lavalink](https://github.com/freyacodes/Lavalink)

Maintained by [Freya Arbjerg](https://github.com/freyacodes).
<br>Lavalink is a popular standalone audio sending node based on Lavaplayer. Lavalink was built with scalability in mind,
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

<hr>

More can be found in the GitHub organization: [JDA-Applications](https://github.com/JDA-Applications)

<hr>


## Contribution

If you want to contribute to JDA-C, make sure to base your branch off of our **developer** or a **feature** branch
and create your PR into that **same** branch.
<br>**We will be rejecting any PRs, which are not based to the developer or a feature branch!**
<br>It is very possible that your change might already be in development or you missed something.

More information can be found at the [contributing](https://github.com/BlockyDotJar/JDA-Commons/wiki/Contributing) wiki page.

### Deprecation Policy

When a feature is introduced to replace or enhance existing functionality we might deprecate old functionality.

A deprecated method/class usually has a replacement mentioned in its documentation which should be switched to.
<br>Deprecated functionality might or might not exist in the next minor release. (Hint: The minor version is the `MM` of `XX.MM.RR` in our version format)

It is possible that some features are deprecated without replacement, in this case the functionality is no longer supported by either the JDA-C structure
due to fundamental changes or due to Tixte-API changes that cause it to be removed.

We highly recommend discontinuing usage of deprecated functionality and update by going through each minor release instead of jumping.
<br>For instance, when updating from version `1.1.0` to version `1.1.6` you should do the following:

- Update to `1.1.3` and check for deprecation
- Update to `1.1.6` and check for deprecation

The `RR` in version `1.1.RR` should be replaced by the latest version that was published for `1.1`, you can find out which the latest
version was by looking at the [release page](https://github.com/BlockyDotJar/JDA-Commons/releases).

## Dependencies:

This project requires **Java 19+**

* JDA (Java Discord API)
    * Version: **v5.0.0-alpha.21**
    * [Github](https://github.com/DV8FromTheWorld/JDA)
* slf4j-api
    * Version: **v2.0.3**
    * [Github](https://github.com/qos-ch/slf4j)
* jetbrains-annotations
    * Version: **v23.0.0**
    * [Github](https://github.com/JetBrains/java-annotations)
* error_prone_annotations
    * Version: **v2.16.0**
    * [Github](https://github.com/google/error-prone)

<hr>

These are only the libraries, which we have in our [build.gradle.kts](https://github.com/BlockyDotJar/JDA-Commons/blob/main/build.gradle.kts), but we are using [all libraries](https://github.com/DV8FromTheWorld/JDA#dependencies), which the original JDA uses too.

<hr>

## JDA related projects

- [discord.py-message-components](https://github.com/mccoderpy/discord.py-message-components/tree/developer)
- [DisCatSharp](https://github.com/Aiko-IT-Systems/DisCatSharp)
- [discord.js](https://github.com/discordjs/discord.js)
- [serenity](https://github.com/serenity-rs/serenity)

**See also:** [Discord API community libraries](https://github.com/apacheli/discord-api-libs)

