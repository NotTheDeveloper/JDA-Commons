[github-packages]: https://img.shields.io/github/v/release/BlockyDotJar/JDA-Commons

[license-shield]: https://img.shields.io/badge/License-Apache%202.0-white.svg
[license]: https://github.com/BlockyDotJar/JDA-Commons/tree/main/LICENSE

[discord-invite-shield]: https://discord.com/api/guilds/876766868864647188/widget.png
[discord-invite]: https://discord.gg/mYKK4BwGxe

[download]: #download

[ ![github-packages][] ][download]
[ ![license-shield][] ][license]
[ ![discord-invite-shield][] ][discord-invite]

> Note: If you have any suggestions/questions/feedback for this wiki please contact Blocky.jar ツ#8117 via [Discord](https://discord.gg/mYKK4BwGxe)

If you want some examples for JDA or JDA-C too than check out the [example directory](https://github.com/BlockyDotJar/JDA-Commons/tree/main/src/test/java/dev/blocky/discord).

## Summary

1. [ChannelUtils](#channelutils)
2. [GuildController](#guildcontroller)
3. [Interfaces](#interfaces)
4. [ClearSafety](#clearsafety)
5. [XYChannel](#xychannel)
6. [XYMember](#xymember)
7. [VoiceRecorder](#voicerecorder)
8. [Annotations](#annotations)
9. [Download](#download)
10. [Support](#getting-help)

<hr>

## ChannelUtils

```yml
Author: BlockyDotJar
Version: v2.0.0
Since: v1.0.0
```

**Description:** 

> This is an interface, which has many utility methods in it.

### Getting ChannelUtils:

`N/A` You can't get this interface.

### Methods

> Checks, which **ClearSafety** enum is given. (if the <code>clear</code> parameter equals **null**, the **ClearSafety** enum will be set to <code>NONE</code>)
>
> Parameter:
> <br>**clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>**channel** - The **MessageChannel**, which should be initialized.
> <br>**amount** - The amount of messages to delete.
> <br>Returns: A **List** of messages representing the precursor of all deletion tasks.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
checkClearSafety(@NotNull MessageChannel, int, @NotNull ClearSafety...)
```
<br>

> Checks, which **ClearSafety** enum is given. (if the <code>clear</code> parameter equals **null**, the **ClearSafety** enum will be set to <code>NONE</code>)
>
> Parameter:
> <br>**clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>**channel** - The **MessageChannel**, which should be initialized.
> <br>Returns: A **List** of messages representing the precursor of all deletion tasks.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
checkChannelClearSafety(@NotNull MessageChannel, @NotNull ClearSafety...)
```
<br>

> Calculates the delay, depending on which **TimeUnit** is specified.
>
> Parameter:
> <br>**unit** - The **TimeUnit**, which should be used for calculating each time. (if the <code>unit</code> parameter equals **null**, <code>SECONDS</code> will be used)
> <br>**delayInSeconds** - The delay in seconds which should be converted.
> <br>Returns: The delay calculated to the specified **TimeUnit**.
```swift
calculateDelay(@Nullable TimeUnit, long)
```
<br>

> The **HashMap** instance from the **ChannelUtils** class.
>
> Returns: **map**.
> <br>Annotation: **NotNull**
```swift
getHashMap()
```

### Overridden methods

`N/A` No overridden method found in this interface.

<hr>

## GuildController

```swift
@Deadline(version = "v1.3.0")
```

```yml
Author: BlockyDotJar
Version: v1.0.0-beta.2
Since: v1.0.0
```

**Description:** 

> This is a controller you can control guilds with. 
> <br>The exact use is still **unknown**.
> 
> Parameter: **guild** - The **Guild**, which should be used to get the **GuildController**.

### Getting GuildController:

```java
GuildController controller = new GuildController(@NotNull Guild);
```

### Methods

> As the user is typing an argument that has autocomplete enabled for it, the bot will receive an **CommandAutoCompleteInteractionEvent**.
> <br>This event isn't fired for each keystroke, but is sent when Discord determines the user has paused typing for a bit.
> 
> <p>An autocompletion can suggest up to 25 options, and users don't have to send a command with one of the options.
> <br>Maps the words to choices and only displays words that start with the user's current input.
>
> Parameter:
> <br>**query** - The query input for a **IAutoCompleteCallback**.
> <br>**words** - An array of words that can be displayed in the autocomplete menu.
>
> Returns: A **List** of **Command.Choice**, you can use to display it with <code>CommandAutoCompleteInteractionEvent#replyChoices(Collection)</code>.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
upsertAutocompleteCommand(@NotNull AutoCompleteQuery, @NotNull String[])
```


### Overridden methods

`N/A` No overridden method found in this record.

<hr>

## Interfaces

**Summary:**

1. [ICommand](#icommand)
2. [ISlashCommand](#islashcommand)
3. [IAutoCompletable](#iautocompletable)
4. [IMessageContext](#imessagecontext)
5. [IUserContext](#iusercontext)

## ICommand

```yml
Author: BlockyDotJar
Version: v2.1.4
Since: v1.0.0-alpha.3
```

**Description:** 

> A simple command interface, which you can use to easily program message commands.

### Getting ICommand:

You need a [CommandManager](https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/test/java/dev/blocky/discord/CommandManager.java) to use this interface.

### Methods

> A simple command interface, which you can use to easily program message commands.
> <br>This contains a **CommandManager**.
>
> Parameter:
> <br>**event** - The **MessageReceivedEvent** for performing a command.
> <br>**args** - An array of strings for performing a command.
```swift
onCommand(@NotNull MessageReceivedEvent, @NotNull String[])
```

### Overridden methods

`N/A` No overridden method found in this interface.

<hr>

## ISlashCommand

```yml
Author: BlockyDotJar
Version: v2.1.4
Since: v1.0.0
```

**Description:** 

> A simple slash-command interface, which you can use to easily program some slash-commands.

### Getting ISlashCommand:

You need an [ApplicationCommandManager](https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/test/java/dev/blocky/discord/ApplicationCommandManager.java) to use this interface.

### Methods

> A simple slash-command interface, which you can use to easily program some slash-commands.
> <br>This contains an **ApplicationCommandManager**.
>
> Parameter: **event** - Indicates that a slash-command was used in a **MessageChannel**.
```swift
onSlashCommand(@NotNull SlashCommandInteractionEvent)
```

### Overridden methods

`N/A` No overridden method found in this interface.

<hr>

## IAutoCompletable

```yml
Author: BlockyDotJar
Version: v1.0.3
Since: v1.1.4
```

**Description:** 

> A simple slash-command interface, which you can use to easily program some slash-commands with auto-complete.

### Getting IAutoCompletable:

You need an [ApplicationCommandManager](https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/test/java/dev/blocky/discord/ApplicationCommandManager.java) to use this interface.

### Methods

> A simple slash-command interface, which you can use to easily program some slash-commands with auto-complete.
> <br>This contains an **ApplicationCommandManager**.
>
> Parameter: **event** - Indicates that a slash-command with auto-complete was used in a **MessageChannel**.
```swift
onCommandAutoComplete(@NotNull CommandAutoCompleteInteractionEvent)
```

### Overridden methods

`N/A` No overridden method found in this interface.

<hr>

## IMessageContext

```yml
Author: BlockyDotJar
Version: v1.1.4
Since: v1.0.0
```

**Description:** 

> A simple message context-menu interface, which you can use to easily program some message context-menus.

### Getting IMessageContext:

You need an [ApplicationCommandManager](https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/test/java/dev/blocky/discord/ApplicationCommandManager.java) to use this interface.

### Methods

> A simple message context-menu interface, which you can use to easily program some message context-menus.
> <br>This contains an **ApplicationCommandManager**.
>
> Parameter: **event** - Indicates that a message context-command was used.
```swift
onMessageContext(@NotNull MessageContextInteractionEvent)
```

### Overridden methods

`N/A` No overridden method found in this interface.

<hr>

## IUserContext

```yml
Author: BlockyDotJar
Version: v1.1.4
Since: v1.0.0
```

**Description:** 

> A simple user context-menu interface, which you can use to easily program some user context-menus.

### Getting IUserContext:

You need an [ApplicationCommandManager](https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/test/java/dev/blocky/discord/ApplicationCommandManager.java) to use this interface.

### Methods

> A simple user context-menu interface, which you can use to easily program some user context-menus.
> <br>This contains an **ApplicationCommandManager**.
>
> Parameter: **event** - Indicates that a message context-command was used.
```swift
onUserContext(@NotNull UserContextInteractionEvent)
``` 

### Overridden methods

`N/A` No overridden method found in this interface.

<hr>

## ClearSafety

```yml
Author: BlockyDotJar
Version: v2.0.0
Since: v1.0.0
```

**Description:** 

> This is an enum, which is used for a safer clearing process.

### Getting ClearSafety:

```java
ClearSafety safety = ClearSafety.FIELD_NAME;
```

### Fields

> The clear process will be done normally without any checks.
```java
NONE
``` 
<br>

> The clear process will be done with all possible checks:
>
> * If the message is edited
> * If the message is pinned
> * If the message is a webhook message
> * If the message is ephemeral
> * If the message is containing suppressed embeds
> * If the message is triggering tts
```java
ALL
```
<br>

> The clear process will be done with the following check:
>
> * If the message is edited
```java
EDITED_MESSAGES
```
<br>

> The clear process will be done with the following check:
>
> * If the message is pinned
```java
PINNED_MESSAGES
```
<br>

> The clear process will be done with the following check:
>
> * If the message is a webhook message
```java
WEBHOOK_MESSAGES
```
<br>

> The clear process will be done with the following check:
>
> * If the message is ephemeral
```java
EPHEMERAL_MESSAGES
```
<br>

> The clear process will be done with the following check:
>
> * If the message is containing suppressed embeds
```java
SUPPRESSED_EMBEDS
```
<br>

> The clear process will be done with the following check:
>
> * If the message is triggering tts
```java
TTS_MESSAGES
```

### Overridden methods

`N/A` No overridden method found in this enum.

<hr>

## XYChannel

**Summary:**

1. [GuildTextChannel](#guildtextchannel)
2. [GuildMessageChannel](#guildmessagechannel)
3. [GuildNewsChannel](#guildnewschannel)
4. [GuildThreadChannel](#guildthreadchannel)
5. [GuildVoiceChannel](#guildvoicechannel)
6. [DirectMessageChannel](#directmessagechannel)

## GuildTextChannel

```yml
Author: BlockyDotJar
Version: v3.0.0
Since: v1.0.0-alpha.1
```

**Description:** 
> Represents a Discord text **GuildChannel**.
>
> Parameter:
> <br>**channel** - The **TextChannel**, which should be initialized.
> <br>**user** - The **User**, which should be initialized.

### Getting GuildTextChannel:

```java
GuildTextChannel channel = new GuildTextChannel(@NotNull TextChannel, @Nullable User);
```

### Methods

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete.
> <br>**clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeMessages(int, @NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **TextChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel(@NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **TextChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter: 
> <br>**content** - The message content, which should be checked .
> <br>**checkAmount** - The amount of messages, which should be checked.
> <br>Returns: 
> <br>**true** - If the content, you specified, is written in this channel.
> <br>**false** - If the content, you specified, is not written in this channel.
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the **User** in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified **User** in this channel.
> <br>Annotation: **Nullable**
```swift
getMessagesByUser()
```
<br>

> Gets all the messages from a specific **User** in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The **User**, from which the messages should be retrieved
> <br>Returns: The written messages of the specified **User** in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@NotNull User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction)
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## GuildMessageChannel

```yml
Author: BlockyDotJar
Version: v3.0.0
Since: v1.0.0-alpha.1
```

**Description:** 

> Represents a Discord channel that can have **messages** and files sent to it.
>
> Parameter:
> <br>**channel** - The **MessageChannel**, which should be initialized.
> <br>**user** - The **User**, which should be initialized.

### Getting GuildMessageChannel:

```java
GuildMessageChannel channel = new GuildMessageChannel(@NotNull MessageChannel, @Nullable User);
```

### Methods

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete.
> <br>**clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeMessages(int, @NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **MessageChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel(@NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **MessageChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter:
> <br>**content** - The message content, which should be checked.
> <br>**checkAmount** - The amount of messages, which should be checked.
> <br>Returns:
> <br>**true** - If the content, you specified, is written in this channel.
> <br>**false** - If the content, you specified, is not written in this channel.
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the **User** in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified **User** in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByUser()
```
<br>

> Gets all the messages from a specific **User** in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The **User**, from which the messages should be retrieved.
> <br>Returns: The written messages of the specified **User** in this channel.
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@NotNull User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction)
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## GuildNewsChannel

```yml
Author: BlockyDotJar
Version: v2.0.0
Since: v1.1.1
```

**Description:** 

> Represents **StandardGuildMessageChannel** that are **NewsChannel**. 
> <br>The Discord client may refer to these as announcement channels. 
> <br>Members can subscribe channels in their own guilds to receive messages cross-posted from this channel. 
> <br>This is referred to as following this channel. 
> <br>**Messages** sent in this channel can be cross-posted, at which point they will be sent (via **Webhook**) to all subscribed channels.
>
> Parameter:
> <br>**channel** - The **NewsChannel**, which should be initialized.
> <br>**user** - The **User**, which should be initialized.

### Getting GuildNewsChannel:

```java
GuildNewsChannel channel = new GuildNewsChannel(@NotNull NewsChannel, @Nullable User);
```

### Methods

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: <br>
> <br>**amount** - The amount of messages to delete.
> <br>**clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeMessages(int, @NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **NewsChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel(@NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **NewsChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter:
> <br>**content** - The message content, which should be checked.
> <br>**checkAmount** - The amount of messages, which should be checked.
> <br>Returns:
> <br>**true** - If the content, you specified, is written in this channel.
> <br>**false** - If the content, you specified, is not written in this channel.
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the **User** in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified **User** in this channel.
> <br>Annotation: **Nullable**
```swift
getMessagesByUser()
```
<br>

> Gets all the messages from a specific **User** in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The **User**, from which the messages should be retrieved.
> <br>Returns: The written messages of the specified **User** in this channel.
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@NotNull User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction)
```
<br>

> Attempts to cross post the provided message automatically.
>
> The following **ErrorResponses** are possible:
> <ul>
> <li>
> <b>ErrorResponse#ALREADY_CROSSPOSTED</b> - The target message has already been cross-posted.
> </li>
> 
> <li>
> <b>ErrorResponse#MISSING_ACCESS</b> - The request was attempted after the account lost access to the guild typically due to being kicked
> or removed, or after <b>Permission#VIEW_CHANNEL</b> was revoked in the MessageChannel. 
> </li>
> 
> <li>
> <b>ErrorResponse#MISSING_PERMISSIONS</b> - The request was attempted after the account lost <b>Permission#MESSAGE_MANAGE</b> in the MessageChannel. 
> </li>
> 
> <li>
> <b>ErrorResponse#UNKNOWN_MESSAGE</b> - The provided messageId is unknown in this MessageChannel, either due to the id being invalid, or
> the message it referred to has already been deleted. 
> </li>
> 
> <li>
> <b>ErrorResponse#UNKNOWN_CHANNEL</b> - The request was attempted after the channel was deleted. 
> </li>
> </ul>
>
> Returns: **RestAction** - Type: **Message**
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
autoPublish()
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## GuildThreadChannel

```yml
Author: BlockyDotJar
Version: v2.0.0
Since: v1.1.1
```

**Description:** 

> Represents private/public/news Discord **ThreadChannel**.
>
> Parameter:
> <br>**channel** - The **ThreadChannel**, which should be initialized.
> <br>**user** - The **User**, which should be initialized.

### Getting GuildThreadChannel:

```java
GuildThreadChannel channel = new GuildThreadChannel(@NotNull ThreadChannel, @Nullable User);
```

### Methods

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete
> <br>**clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeMessages(int, @NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **ThreadChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel(@NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **ThreadChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter:
> <br>**content** - The message content, which should be checked.
> <br>**checkAmount** - The amount of messages, which should be checked.
> <br>Returns:
> <br>**true** - If the content, you specified, is written in this channel.
> <br>**false** - If the content, you specified, is not written in this channel.
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the **User** in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified **User** in this channel.
> <br>Annotation: **Nullable**
```swift
getMessagesByUser()
```
<br>

> Gets all the messages from a specific **User** in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The **User**, from which the messages should be retrieved.
> <br>Returns: The written messages of the specified **User** in this channel.
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@NotNull User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction)
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## GuildVoiceChannel

```yml
Author: BlockyDotJar
Version: v2.0.0
Since: v1.1.5
```

**Description:** 

> Represents a Discord voice **GuildChannel**. 
> <br>Adds additional information specific to **VoiceChannels** in Discord.
>
> Parameter:
> <br>**channel** - The **VoiceChannel**, which should be initialized.
> <br>**user** - The **User**, which should be initialized.

### Getting GuildVoiceChannel:

```java
GuildVoiceChannel channel = new GuildVoiceChannel(@NotNull VoiceChannel, @Nullable User);
```

### Methods

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete.
> <br>**clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeMessages(int, @NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **VoiceChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel(@NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **VoiceChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter:
> <br>**content** - The message content, which should be checked.
> <br>**checkAmount** - The amount of messages, which should be checked.
> <br>Returns:
> <br>**true** - If the content, you specified, is written in this channel.
> <br>**false** - If the content, you specified, is not written in this channel.
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the **User** in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified **User** in this channel.
> <br>Annotation: **Nullable**
```swift
getMessagesByUser()
```
<br>

> Gets all the messages from a specific **User** in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The **User**, from which the messages should be retrieved.
> <br>Returns: The written messages of the specified **User** in this channel.
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@NotNull User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction)
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## DirectMessageChannel

```yml
Author: BlockyDotJar
Version: v2.0.0
Since: v1.1.1
```

**Description:** 

> Represents the connection used for direct-messaging.
> 
> Parameter: 
> <br>**channel** - The **PrivateChannel**, which should be initialized.
> <br>**user** - The **User**, which should be initialized.

### Getting DirectMessageChannel:

```java
DirectMessageChannel channel = new DirectMessageChannel(@NotNull PrivateChannel, @Nullable User);
```

### Methods

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete.
> <br>**clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeMessages(int, @NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **PrivateChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **ClearSafety** options, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel(@NotNull ClearSafety...)
```
<br>

> Convenience method to a complete **PrivateChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **NotNull**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter:
> <br>**content** - The message content, which should be checked.
> <br>**checkAmount** - The amount of messages, which should be checked.
> <br>Returns:
> <br>**true** - If the content, you specified, is written in this channel.
> <br>**false** - If the content, you specified, is not written in this channel.
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the **User** in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified **User** in this channel.
> <br>Annotation: **Nullable**
```swift
getMessagesByUser()
```
<br>

> Gets all the messages from a specific **User** in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The **User**, from which the messages should be retrieved.
> <br>Returns: The written messages of the specified **User** in this channel.
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@NotNull User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **MessageCreateAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **MessageCreateAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageCreateAction, long, @Nullable MessageCreateAction)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option is that you can use a specific **TimeUnit** like **TimeUnit#MINUTES**,
> **TimeUnit#HOURS** or **TimeUnit#DAYS**.
> <br>(if the <code>unit</code> parameter equals <b>null</b>, <code>SECONDS</code> will be used)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>**unit** - The **TimeUnit**, which is used for specifying the type of time for the delay.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (interaction) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the <code>delayInSeconds</code> parameter <b>must not equal to 0</b>)
> <br>If this is <code>true</code> a **IllegalArgumentException** will be thrown. The same is applicable for numbers under 0.
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The **ReplyCallbackAction**, which should be used.
> <br>**delayInSeconds** - The delay for the executing command in seconds.
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet.
> <br>Returns: The specified **ReplyCallbackAction**.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @NotNull ReplyCallbackAction)
```
<br>

> Closes a **PrivateChannel**. 
> <br>After being closed successfully the **PrivateChannel** is removed from the **JDA** mapping.
> <br>As a note, this does not remove the history of the **PrivateChannel**. 
> <br>If the channel is reopened the history will still be present.
>
> Returns: **RestAction** - Type: **Void**
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift 
close()
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## XYMember

**Summary:**

1. [GuildMember](#guildmember)
2. [GuildThreadMember](#guildthreadmember)
3. [SelfMember](#selfmember)

## GuildMember

```yml
Author: BlockyDotJar
Version: v3.0.0
Since: v1.0.0-alpha.1
```

**Description:**

> Represents a guild-specific **User**.
>
> Parameter: **member** - The **Member**, which should be used to get **GuildMember**.

### Getting GuildMember:

```java
GuildMember member = new GuildMember(@NotNull Member);
```

### Methods

> Checks if the **Role** with the id you specified, is found on the **Role** board of the **Member**.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked
> <br>Returns: The **Role** with the id you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(long)
```
<br>

> Checks if the **Role** with the id you specified, is found on the **Role** board of the **Member**.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns: The **Role** with the id you specified.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(@NotNull String)
```
<br>

> Checks if the **Role** with the name you specified, is found on the **Role** board of the **Member**.
>
> Parameter: **roleName** - The name of the **Role**, which should be checked.
> <br>Returns: The **Role** with the name you specified.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleByName(@NotNull String)
```
<br>

> Checks if the **Member** has the **Role** with the id you specified.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **Member** has the **Role**.
> <br>**false** - If the **Member** has not the **Role**.
```swift
hasRoleWithId(long)
```
<br>

> Checks if the **Member** has the **Role** with the id you specified.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **Member** has the **Role**.
> <br>**false** - If the **Member** has not the **Role**.
```swift
hasRoleWithId(@NotNull String)
```
<br>

> Checks if the **Member** has the **Role** with the name you specified.
>
> Parameter: **roleName** - The name of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **Member** has the **Role**.
> <br>**false** - If the **Member** has not the **Role**.
```swift
hasRoleWithName(@NotNull String)
```
<br>

> Checks if the **Member** was pinged in a specified **Message**.
>
> Parameter: **message** - The **Message**, which should checked, if the **Member** got pinged in the **Message**.
> <br>Returns:
> <br>**true** - If the **Member** got pinged in the **Message**.
> <br>**false** - If the **Member** got pinged in the **Message**.
```swift
isMentioned(@NotNull Message)
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## GuildThreadMember

```yml
Author: BlockyDotJar
Version: v2.0.0
Since: v1.1.1
```

**Description:** 

> Represents a **Member**, who joined a **ThreadChannel**.
> 
> Parameter: **member** - The **ThreadMember**, which should be used to get **GuildThreadMember**.

### Getting GuildThreadMember:

```java
GuildThreadMember member = new GuildThreadMember(@NotNull ThreadMember);
```

### Methods

> Checks if the **Role** with the id you specified, is found on the **Role** board of the **ThreadMember**.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns: The **Role** with the id you specified.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(long)
```
<br>

> Checks if the **Role** with the id you specified, is found on the **Role** board of the **ThreadMember**.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns: The **Role** with the id you specified.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(@NotNull String)
```
<br>

> Checks if the **Role** with the name you specified, is found on the **Role** board of the **ThreadMember**.
>
> Parameter: **roleName** - The name of the **Role**, which should be checked.
> <br>Returns: The **Role** with the name you specified.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleByName(@NotNull String)
```
<br>

> Checks if the **ThreadMember** has the **Role** with the id you specified.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **ThreadMember** has the **Role**.
> <br>**false** - If the **ThreadMember** has not the **Role**.
```swift
hasRoleWithId(long)
```
<br>

> Checks if the **ThreadMember** has the **Role** with the id you specified.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **ThreadMember** has the **Role**.
> <br>**false** - If the **ThreadMember** has not the **Role**.
```swift
hasRoleWithId(@NotNull String)
```
<br>

> Checks if the **ThreadMember** has the **Role** with the name you specified.
>
> Parameter: **roleName** - The name of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **ThreadMember** has the **Role**.
> <br>**false** - If the **ThreadMember** has not the **Role**.
```swift
hasRoleWithName(@NotNull String)
```
<br>

> Checks if the **ThreadMember** was pinged in a specified **Message**.
>
> Parameter: **message** - The **Message**, which should checked, if the **ThreadMember** got pinged in the **Message**.
> <br>Returns:
> <br>**true** - If the **ThreadMember** got pinged in the **Message**.
> <br>**false** - If the **ThreadMember** got pinged in the **Message**.
```swift
isMentioned(@NotNull Message)
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## SelfMember

```yml
Author: BlockyDotJar
Version: v2.0.0
Since: v1.0.1
```

**Description:** 

> Represents the **SelfMember** (aka. the bot itself) of a specific **Guild**.
> 
> Parameter: **guild** - The **Guild**, which should be used to get the **SelfMember**. 

### Getting SelfMember:

```java
SelfMember self = new SelfMember(@NotNull Guild);
```

### Methods

> Checks if the **Role** with the id you specified, is found on the **Role** board of the **SelfMember**.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns: The **Role** with the id you specified.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(long)
```
<br>

> Checks if the **Role** with the id you specified, is found on the **Role** board of the **SelfMember**.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns: The **Role** with the id you specified.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(@NotNull String)
```
<br>

> Checks if the **Role** with the name you specified, is found on the **Role** board of the **SelfMember**.
>
> Parameter: **roleName** - The name of the **Role**, which should be checked.
> <br>Returns: The **Role** with the name you specified.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleByName(@NotNull String)
```
<br>

> Checks if the **SelfMember** has the **Role** with the id you specified.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **SelfMember** has the **Role**.
> <br>**false** - If the **SelfMember** has not the **Role**.
```swift
hasRoleWithId(long)
```
<br>

> Checks if the **SelfMember** has the **Role** with the id you specified.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **SelfMember** has the **Role**.
> <br>**false** - If the **SelfMember** has not the **Role**.
```swift
hasRoleWithId(@NotNull String)
```
<br>

> Checks if the **SelfMember** has the **Role** with the name you specified.
>
> Parameter: **roleName** - The name of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **SelfMember** has the **Role**.
> <br>**false** - If the **SelfMember** has not the **Role**.
```swift
hasRoleWithName(@NotNull String)
```
<br>

> Checks if the **SelfMember** was pinged in a specified message.
>
> Parameter: **message** - The message, which should checked, if the **SelfMember** got pinged in the message.
> <br>Returns:
> <br>**true** - If the **SelfMember** got pinged in the message.
> <br>**false** - If the **SelfMember** got pinged in the message.
```swift
isMentioned(@NotNull Message)
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## VoiceRecorder

```yml
Author: BlockyDotJar
Version: v1.0.1
Since: v1.1.6
```

**PLEASE NOTE: Only use this feature to record conversations with the consent of all users in the channel.
<br>Recording a conversation against other users' consent is illegal, and you are violating the Discord Terms of Service.**

**Description:** 

> This class is used to record audio from a **VoiceChannel**.

### Getting VoiceRecorder:

```java
VoiceRecorder recorder = VoiceRecorder.newRecorder();
```

### Methods

> Represents a <b>new VoiceRecorder</b> instance.
>
> Returns: A <b>new VoiceRecorder</b> instance.
> <br>Annotation: **NotNull**
```swift
newRecorder()
```
<br>

> Sets the volume of the recorded audio.
> <br>If the volume isn't set the volume will be automatically set to 1.0.
> <br>This method should only be used if the value is greater or smaller than 1.0.
>
> Parameter: **volume** - The volume of the audio to be recorded.
> <br>Returns: The current instance of the **VoiceRecorder** class.
> <br>Annotation: **NotNull**
```swift
setVolume(double)
```
<br>

> Sets the **AudioReceivedHandler** that the **AudioManager** will use to
> process audio data received from an **AudioConnection**.
> <br>The handler provided here will persist between **AudioConnection** connect and disconnects.
> <br>Furthermore, you don't need to have an **AudioConnection** to set a handler.
> <br>When **JDA** sets up a <b>new AudioConnection</b> it will use the handler provided here.
> <br>Setting this to <code>null</code> will remove the **AudioReceivedHandler**.
>
> Parameter: **guild** - The **Guild** to receive the audio from.
> <br>Returns: The current instance of the **VoiceRecorder** class.
> <br>Annotation: **NotNull**
```swift
setReceivingHandler(@NotNull Guild)
```
<br>

> Sets if the audio should be stacked or not.
> <br>This means that you set, if the audio will or will not be removed from the **ConcurrentLinkedQueue**
> when the recording is finished.
> <br>This is useful if you want to record multiple conversations in one audio file.
> <br>If you want that the audio will be removed from the queue and thus with each join the audio file will be reinitialized, set this to <code>false</code>.
> <br>If the boolean isn't set this will be automatically set to <code>false</code>.
> <br>This method should only be used if the value is <code>true</code>.
>
> Parameter: **shouldStack** - Whether the audio should be stacked.
> <br>Returns: The current instance of the **VoiceRecorder** class.
> <br>Annotation: **NotNull**
```swift
shouldStack(boolean)
```
<br>

> <b>PLEASE NOTE: Only use this feature to record conversations with the consent of all users in the channel.
> <br>Recording a conversation against other users' consent is illegal, and you are violating the Discord Terms of Service.</b>
>
> This method will start recording audio from the **VoiceChannel** that the bot is currently in.
> <br>This method will return a **File** that contains the audio that was recorded.
>
> This is recommended to use, when the **User** leaves the channel.
> <br>Note that the **AudioConnection** should be closed before this method is called.
>
> <p>This method supports any kind of audio file.
> <br>Following audio file-formats are tested:
> <br>- <code>.wav</code>
> <br>- <code>.mp3</code>
> <br>- <code>.ogg</code>
> <br>- <code>.opus</code>
> <br>- <code>.m4a</code>
>
> Parameter: 
> <br>**file** - The **File** to save the audio to.
> <br>**sampleRate** - The number of samples per second.
> <br>Returns: The **File** that the audio was saved to.
> <br>Annotation: **NotNull**
```swift
createRecording(@NotNull File, float)
```
<br>

> <b>PLEASE NOTE: Only use this feature to record conversations with the consent of all users in the channel.
> <br>Recording a conversation against other users' consent is illegal, and you are violating the Discord Terms of Service.</b>
> 
> This method will start recording audio from the **VoiceChannel** that the bot is currently in.
> <br>This method will return a **File** that contains the audio that was recorded.
>
> This is recommended to use, when the **User** leaves the channel.
> <br>Note that the **AudioConnection** should be closed before this method is called.
>
> The sample rate of this method equals <code>48000</code>, but if you need a different sample rate use **VoiceRecorder#createRecording(File, float)**
> instead.
>
> <p>This method supports any kind of audio file.
> <br>Following audio file-formats are tested:
> <br>- <code>.wav</code>
> <br>- <code>.mp3</code>
> <br>- <code>.ogg</code>
> <br>- <code>.opus</code>
> <br>- <code>.m4a</code>
>
> Parameter: **file** - The **File** to save the audio to.
> <br>Returns: The **File** that the audio was saved to.
> <br>Annotation: **NotNull**
```swift
createRecording(@NotNull File)
```
<br>

> Gets the current volume of the audio.
> <br>This is the volume of the audio that will be recorded.
> <br>If the volume isn't set the volume will be automatically set to 1.0.
>
> Returns: The current volume of the audio as a double.
```swift
getVolume()
```
<br>

> The **AudioManager** that represents the **AudioConnection** for this **Guild**.
> <br>If no **AudioManager** exists for this **Guild**, this will create a <b>new</b> one.
> <br>This operation is <code>synchronized</code> on all **AudioManager** for this **JDA** instance, this means
> that calling <code>getAudioManager()</code> on any other **Guild** while a thread is accessing this method may be locked.
>
> Returns: The **AudioManager** for this **Guild**.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
getAudioManager()
```
<br>

> The **Guild**, the message was received in.
>
> Returns: The guild, the message was received in.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
getGuild()
```
<br>

> If the audio should be stacked or not.
> <br>This means that you set, if the audio will or will not be removed from the **ConcurrentLinkedQueue**
> when the recording is finished.
>
> Returns:
> <br>**true** - If the audio should be stacked.
> <br>**false** - If the audio should be removed from the queue.
```swift
stackEnabled()
```

### Overridden methods

```swift
canReceiveCombined()
canReceiveUser()
handleCombinedAudio(@NotNull CombinedAudio)

equals(@Nullable Object)
hashCode()
toString()
```

<hr>

## Annotations

**Summary:**

1. [Deadline](#deadline)
2. [DeprecatedSince](#deprecatedsince)
3. [ForRemoval](#forremoval)
4. [ReplaceWith](#replacewith)
5. [Undocumented](#undocumented)

## Deadline

```swift
@Retention(RUNTIME)
@Target({TYPE, METHOD})
```

```yml
Author: BlockyDotJar
Version: v1.1.2
Since: v1.0.0-alpha.1
```

**Description:** 

> This is an annotation, which tells the developers that a method or class should be finish in the future.

### Methods

> Specifies the version, in which the <b>new</b> method or class should be finished.
> 
> Returns: The version, in which the <b>new</b> method or class should be finished.
```swift
version()
```

## DeprecatedSince

```swift
@Retention(RUNTIME)
@Target({TYPE, METHOD})
```

```yml
Author: BlockyDotJar
Version: v1.1.2
Since: v1.0.0-alpha.1
```

**Description:** 

> This is an annotation, which tells the developers since when a method or class is deprecated.

### Methods

> Specifies the version, since when the method or class is deprecated.
> 
> Returns: The version, since when the method or class is deprecated.
```swift
version()
```

## ForRemoval

```swift
@Retention(RUNTIME)
@Target({TYPE, METHOD})
```

```yml
Author: BlockyDotJar
Version: v1.1.2
Since: v1.0.0
```

**Description:** 

> This is an annotation, which tells the developers that a method or class should be removed in the future.

### Methods

> Specifies the version, in which the deprecated method or class should be removed.
> 
> Returns: The version, in which the deprecated method or class should be removed.
```swift
deadline()
```

## ReplaceWith

```swift
@Retention(RUNTIME)
@Target({TYPE, METHOD})
```

```yml
Author: BlockyDotJar
Version: v1.1.3
Since: v1.0.0-alpha.1
```

**Description:** 

> This is an annotation, which tells the developers, with which method or class a deprecated method or class should be replaced.

### Methods

> Specifies the method or class, which should used instead.
> 
> Returns: The method or class, which should used instead.
```swift
value()
```

## Undocumented

```swift
@Retention(RUNTIME)
@Target({PACKAGE, TYPE, METHOD, CONSTRUCTOR})
```

```yml
Author: BlockyDotJar
Version: v1.1.2
Since: v1.0.0
```

**Description:** 

> This is an annotation, which tells the developers that a method, class, constructor/ or package is not documented yet.

### Methods

`N/A` No method found in this class.

## Download

You can get the latest released builds here: [Promoted downloads](https://github.com/BlockyDotJar/JDA-Commons/releases)

If you want the most up-to-date builds, you can get them here: [Latest build downloads](https://github.com/BlockyDotJar/JDA-Commons/packages/1365003)

## Getting help

For general troubleshooting you can visit JDA's wiki [troubleshooting](https://jda.wiki/using-jda/troubleshooting/) and [FAQ](https://jda.wiki/introduction/faq/).
<br>If you need help, or just want to talk with the JDA-C or other Devs, you can join the [support server](https://discord.gg/mYKK4BwGxe).

<br>Especially interesting are the [getting started](https://jda.wiki/introduction/jda/)
and [Setup](https://jda.wiki/setup/intellij/) pages.
