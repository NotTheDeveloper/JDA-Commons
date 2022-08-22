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

If you want some examples for JDA too than check out the [example directory](https://github.com/BlockyDotJar/JDA-Commons/tree/main/src/test/java/dev/blocky/discord).

## Summary

1. [CommonsClient](#commonsclient)
2. [Utility](#utility)
3. [GuildController](#guildcontroller)
4. [Interfaces](#interfaces)
5. [SafetyClear](#safetyclear)
6. [XYChannel](#xychannel)
7. [XYMember](#xymember)
8. [VoiceRecorder](#voicerecorder)
9. [MessageMention](#messagemention)
10. [Annotations](#annotations)
11. [Download](#download)
12. [Support](#getting-help)

<hr>

## CommonsClient

```swift
@Deadline(version = "v1.3.0")
```

```yml
Author: BlockyDotJar
Version: v1.0.0-alpha.5
Since: v1.0.0
```

**Description:** This is a client for the JDA-Commons library. The exact use is still unknown.

### Getting CommonsClient:

```java
CommonsClient client = CommonsClient.Builder.getCommonsClient();
```

### Methods

`N/A` No method found in this class.

### Overridden methods

`N/A` No overridden method found in this class.

## Builder

```swift
@Deadline(version = "v1.3.0")
```

```yml
Author: BlockyDotJar
Version: v1.0.0-alpha.6
Since: v1.0.0
```

**Description:** This is the builder for the **CommonsClient**.

### Getting CommonsClient.Builder:

`N/A` You can't get this class.

### Methods

> Represents a <b>new CommonsClient</b> instance.
>
> Returns: A <b>new CommonsClient</b> instance 
> <br>Annotation: **NotNull**
```swift
getCommonsClient()
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## Utility

```yml
Author: BlockyDotJar
Version: v1.1.5
Since: v1.0.0
```

**Description:** This is a class, which has many utility methods in it.

### Getting Utility:

`N/A` You can't get this class.

### Methods

> Checks, which **SafetyClear** enum is given. (if the <code>clear</code> parameter equals **null**, the **SafetyClear** enum will be set to <code>NONE</code>)
>
> Parameter:
> <br>**clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>**channel** - The **MessageChannelUnion**, which should be initialized.
> <br>**amount** - The amount of messages to delete.
> <br>Returns: A **List** of messages representing the precursor of all deletion tasks.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
checkClearSafety(@Nullable SafetyClear, @NotNull MessageChannelUnion, int)
```
<br>

> Checks, which **SafetyClear** enum is given. (if the <code>clear</code> parameter equals **null**, the **SafetyClear** enum will be set to <code>NONE</code>)
>
> Parameter:
> <br>**clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>**channel** - The **MessageChannelUnion**, which should be initialized.
> <br>Returns: A **List** of messages representing the precursor of all deletion tasks.
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
checkChannelClearSafety(@Nullable SafetyClear, @NotNull MessageChannelUnion)
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

> The **HashMap** instance from the **Utility** class.
>
> Returns: **map**.
> <br>Annotation: **NotNull**
```swift
getHashMap()
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## GuildController

```swift
@Deadline(version = "v1.3.0")
```

```yml
Author: BlockyDotJar
Version: v1.0.0-beta.1
Since: v1.0.0
```

**Description:** This is a controller you can control guilds with. The exact use is still **unknown**.

### Getting GuildController:

```java
GuildController controller = GuildController.set(@NotNull Guild);
```

### Methods

> Constructs a <b>new GuildController</b> instance. 
> <br>If you don't initialize a **Guild**,  the **GuildController** always will be <b>null</b>.
>
> Parameter: **guild** - The **Guild**, which should be used to get the **GuildController**.
> <br>Returns: A <b>new GuildController</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull Guild)
```
<br>

> The **Guild**, the message was received in.
>
> Returns: The **Guild** the message was received in.
> <br>Annotation: **Nullable**
```swift
getGuild()
```
<br>

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

```swift
equals(@Nullable Object)
hashCode()
toString()
```

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
Version: v2.1.3
Since: v1.0.0-alpha.3
```

**Description:** A simple command interface, which you can use to easily program message commands.

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
Version: v2.1.3
Since: v1.0.0
```

**Description:** A simple slash-command interface, which you can use to easily program some slash-commands.

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
Version: v1.0.2
Since: v1.1.4
```

**Description:** A simple slash-command interface, which you can use to easily program some slash-commands with auto-complete.

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
Version: v1.1.3
Since: v1.0.0
```

**Description:** A simple message context-menu interface, which you can use to easily program some message context-menus.

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
Version: v1.1.3
Since: v1.0.0
```

**Description:** A simple user context-menu interface, which you can use to easily program some user context-menus.

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

## SafetyClear

```yml
Author: BlockyDotJar
Version: v1.1.1
Since: v1.0.0
```

**Description:** This is an enum, which is used for a safer clearing process.

### Getting SafetyClear:

```java
SafetyClear clear = SafetyClear.FIELD_NAME;
```

### Fields

> The clear process will be done normally without any checks.
```java
NONE
``` 
<br>

> The clear process will be done with all possible checks:
>
> * If the message is pinned
> * If the message is a webhook message
> * If the message is edited
```java
ALL
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
> * If the message is edited
```java
EDITED_MESSAGES
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
Version: v2.1.4
Since: v1.0.0-alpha.1
```

**Description:** Represents a Discord text guild channel.

### Getting GuildTextChannel:

**Recommended:**
```java
GuildTextChannel channel = GuildTextChannel.set(@NotNull MessageChannelUnion, @Nullable Member);
```

**Alternatively:**
```java
GuildTextChannel channel = GuildTextChannel.set(@NotNull MessageChannelUnion);
```

### Methods

> Constructs a <b>new GuildTextChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion** or a **Member**, the **GuildTextChannel** always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The **MessageChannelUnion**, which should be initialized.
> <br>**member** - The **Member**, which should be initialized.
> <br>Returns: A <b>new GuildTextChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion, @Nullable Member)
```
<br>

> Constructs a <b>new GuildTextChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion**, the **GuildTextChannel** always will be <b>null</b>.
>
> Parameter: **channel** - The **MessageChannelUnion**, which should be initialize.
> <br>Returns: A <b>new GuildTextChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion)
```
<br>

> The author of the **Message** received as **Member** object.
>
> Returns: The author of the **Message** as null-able **Member** object.
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> The **TextChannel** for this **Message**.
>
> Returns: The **TextChannel**.
> <br>Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete.
> <br>**clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete **TextChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete **TextChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
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

> Gets all the messages from the **User**, which was specified with the <code>set(@NotNull MessageChannelUnion, @Nullable Member)</code> method,
> in this channel. (max. 1000 messages per channel)
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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

```swift
equals(@Nullable Object)
hashCode()
toString()
```

<hr>

## GuildMessageChannel

```yml
Author: BlockyDotJar
Version: v2.1.4
Since: v1.0.0-alpha.1
```

**Description:** Represents a Discord channel that can have messages and files sent to it.

### Getting GuildMessageChannel:

**Recommended:**
```java
GuildMessageChannel channel = GuildMessageChannel.set(@NotNull MessageChannelUnion, @Nullable Member);
```

**Alternatively:**
```java
GuildMessageChannel channel = GuildMessageChannel.set(@NotNull MessageChannelUnion);
```

### Methods

> Constructs a <b>new GuildMessageChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion** or a **Member**, the **GuildMessageChannel** always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The **MessageChannelUnion**, which should be initialized.
> <br>**member** - The **Member**, which should be initialized.
> <br>Returns: A <b>new GuildMessageChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion, @Nullable Member)
```
<br>

> Constructs a <b>new GuildMessageChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion**, **Member** always will be <b>null</b>.
>
> Parameter: **channel** - The **MessageChannelUnion**, which should be initialized.
> <br>Returns: A <b>new GuildMessageChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion)
```
<br>

> The author of the **Message** received as **Member** object.
>
> Returns: The author of the **Message** as null-able **Member** object.
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> The **MessageChannel** for this **Message**.
>
> Returns: The **MessageChannel**.
> <br>Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete.
> <br>**clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete **MessageChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete **MessageChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
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

> Gets all the messages from the **User**, which was specified with the <code>set(@NotNull MessageChannelUnion, @Nullable Member)</code> method,
> in this channel. (max. 1000 messages per channel)
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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

```swift
equals(@Nullable Object)
hashCode()
toString()
```

<hr>

## GuildNewsChannel

```yml
Author: BlockyDotJar
Version: v1.1.4
Since: v1.1.1
```

**Description:** Represents standard GuildMessageChannel that are **NewsChannel**. The Discord client may refer to these as announcement channels. Members can subscribe channels in their own guilds to receive messages cross-posted from this channel. This is referred to as following this channel. Messages sent in this channel can be cross-posted, at which point they will be sent (via webhook) to all subscribed channels.

### Getting GuildNewsChannel:

**Recommended:**
```java
GuildNewsChannel channel = GuildNewsChannel.set(@NotNull MessageChannelUnion, @Nullable Member);
```

**Alternatively:**
```java
GuildNewsChannel channel = GuildNewsChannel.set(@NotNull MessageChannelUnion);
```

### Methods

> Constructs a <b>new GuildNewsChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion** or a **Member**, the **GuildNewsChannel** always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The **MessageChannelUnion**, which should be initialized.
> <br>**member** - The **Member**,, which should be initialized.
> <br>Returns: A <b>new GuildNewsChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion, @Nullable Member)
```
<br>

> Constructs a <b>new GuildNewsChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion**, **GuildNewsChannel** always will be <b>null</b>.
>
> Parameter: **channel** - The **MessageChannelUnion**, which should be initialized .
> <br>Returns: A <b>new GuildNewsChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion)
```
<br>

> The author of the **Message** received as **Member** object.
>
> Returns: The author of the **Message** as null-able **Member** object.
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> The **NewsChannel** for this **Message**.
>
> Returns: The **NewsChannel**.
> <br>Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: <br>
> <br>**amount** - The amount of messages to delete.
> <br>**clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete **NewsChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete **NewsChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
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

> Gets all the messages from the **User**, which was specified with the <code>set(@NotNull MessageChannelUnion, @Nullable Member)</code> method,
> in this channel. (max. 1000 messages per channel)
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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

```swift
equals(@Nullable Object)
hashCode()
toString()
```

<hr>

## GuildThreadChannel

```yml
Author: BlockyDotJar
Version: v1.1.4
Since: v1.1.1
```

**Description:** Represents private/public/news Discord **ThreadChannel**.

### Getting GuildThreadChannel:

**Recommended:**
```java
GuildThreadChannel channel = GuildThreadChannel.set(@NotNull MessageChannelUnion, @Nullable Member);
```

**Alternatively:**
```java
GuildThreadChannel channel = GuildThreadChannel.set(@NotNull MessageChannelUnion);
```

### Methods

> Constructs a <b>new GuildThreadChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion** or a **Member**, the **GuildThreadChannel** always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The **MessageChannelUnion**, which should be initialized.
> <br>**member** - The **Member**, which should be initialized.
> <br>Returns: A <b>new GuildThreadChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion, @Nullable Member)
```
<br>

> Constructs a <b>new GuildThreadChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion**, **GuildThreadChannel** always will be <b>null</b>.
>
> Parameter: **channel** - The **MessageChannelUnion**, which should be initialized.
> <br>Returns: A <b>new GuildThreadChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion)
```
<br>

> The author of the **Message** received as **Member** object.
>
> Returns: The author of the **Message** as null-able **Member** object.
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> The **ThreadChannel** for this **Member**.
>
> Returns: The **ThreadChannel**.
> <br>Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete
> <br>**clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete **ThreadChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete **ThreadChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
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

> Gets all the messages from the **User**, which was specified with the <code>set(@NotNull MessageChannelUnion, @Nullable Member)</code> method,
> in this channel. (max. 1000 messages per channel)
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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

```swift
equals(@Nullable Object)
hashCode()
toString()
```

<hr>

## GuildVoiceChannel

```yml
Author: BlockyDotJar
Version: v1.0.1
Since: v1.1.5
```

**Description:** Represents a Discord voice guild channel. Adds additional information specific to **VoiceChannels** in Discord.

### Getting GuildVoiceChannel:

**Recommended:**
```java
GuildVoiceChannel channel = GuildVoiceChannel.set(@NotNull MessageChannelUnion, @Nullable Member);
```

**Alternatively:**
```java
GuildVoiceChannel channel = GuildVoiceChannel.set(@NotNull MessageChannelUnion);
```

### Methods

> Constructs a <b>new GuildVoiceChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion** or a **Member**, the **GuildVoiceChannel** always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The **MessageChannelUnion**, which should be initialized.
> <br>**member** - The **Member**, which should be initialized.
> <br>Returns: A <b>new GuildVoiceChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion, @Nullable Member)
```
<br>

> Constructs a <b>new GuildVoiceChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion**, **GuildVoiceChannel** always will be <b>null</b>.
>
> Parameter: **channel** - The **MessageChannelUnion**, which should be initialized.
> <br>Returns: A <b>new GuildVoiceChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion)
```
<br>

> The author of the **Message** received as **Member** object.
>
> Returns: The author of the **Message** as null-able **Member** object.
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> The **VoiceChannel** for this **Message**.
>
> Returns: The **VoiceChannel**.
> Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete.
> <br>**clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete **VoiceChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete **VoiceChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
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

> Gets all the messages from the **User**, which was specified with the <code>set(@NotNull MessageChannelUnion, @Nullable Member)</code> method,
> in this channel. (max. 1000 messages per channel)
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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

```swift
equals(@Nullable Object)
hashCode()
toString()
```

<hr>

## DirectMessageChannel

```yml
Author: BlockyDotJar
Version: v1.1.4
Since: v1.1.1
```

**Description:** Represents the connection used for direct-messaging.

### Getting DirectMessageChannel:

**Recommended:**
```java
DirectMessageChannel channel = DirectMessageChannel.set(@NotNull MessageChannelUnion, @Nullable User);
```

**Alternatively:**
```java
DirectMessageChannel channel = DirectMessageChannel.set(@NotNull MessageChannelUnion);
```

### Methods

> Constructs a <b>new DirectMessageChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion** or a **User**, the **DirectMessageChannel** always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The **MessageChannelUnion**, which should be initialized.
> <br>**member** - The **User**, which should be initialized.
> <br>Returns: A <b>new DirectMessageChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion, @Nullable User)
```
<br>

> Constructs a <b>new DirectMessageChannel</b> instance.
> <br>If you don't initialize a **MessageChannelUnion**, **DirectMessageChannel** always will be <b>null</b>.
>
> Parameter: **channel** - The **MessageChannelUnion**, which should be initialized.
> <br>Returns: A <b>new DirectMessageChannel</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannelUnion)
```
<br>

> The author of the **Message** received as **User** object.
>
> Returns: The author of the **Message** as null-able **User** object.
> <br>Annotation: **Nullable**
```swift
getUser()
```
<br>

> The **PrivateChannel** for this **Message**.
>
> Returns: The **PrivateChannel**.
> <br>Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete.
> <br>**clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete **PrivateChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Parameter: **clear** - The **SafetyClear** option, which helps for specifying different message types, which will not be deleted.
> <br>Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete **PrivateChannel** in the most efficient way available.
> <br>No checks will be done to prevent failures, use <code>CompletionStage#exceptionally(Function)</code> to handle failures.
>
> Returns: A **List** of futures representing all deletion task.
> <br>Annotation: **Nullable**
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

> Gets all the messages from the **User**, which was specified with the <code>set(@NotNull MessageChannelUnion, @Nullable Member)</code> method,
> in this channel. (max. 1000 messages per channel)
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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
> <br>You must specify a delay to time out a command. (the  <code>delayInSeconds</code> parameter <b>must not equal to 0</b>.
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

```swift
equals(@Nullable Object)
hashCode()
toString()
```

<hr>

## XYMember

**Summary:**

1. [GuildMember](#guildmember)
2. [GuildTargetMember](#guildtargetmember)
3. [GuildThreadMember](#guildthreadmember)
4. [SelfMember](#selfmember)

## GuildMember

```yml
Author: BlockyDotJar
Version: v2.1.4
Since: v1.0.0-alpha.1
```

**Description:** Represents a guild-specific **User**.

### Getting GuildMember:

```java
GuildMember member = GuildMember.set(@NotNull Member);
```

### Methods

> Constructs a <b>new< GuildMember/b> instance. 
> <br>If you don't initialize a **Member**, the **GuildMember** always will be <b>null</b>.
>
> Parameter: **member** - The **Member**, which should be used to get **GuildMember**.
> <br>Returns: A <b>new GuildMember</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull Member)
```
<br>

> The author of the **Message** received as **Member** object.
>
> Returns: The author of the **Message** as **non-null Member** object.
> <br>Annotation: **NotNull**
```swift
getMember()
```
<br>

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

```swift
equals(@Nullable Object)
hashCode()
toString()
```

<hr>

## GuildTargetMember

```yml
Author: BlockyDotJar
Version: v1.1.4
Since: v1.0.0-alpha.4
```

**Description:** Represents the **Member** instance for the target **User**.

### Getting GuildTargetMember:

```java
GuildTargetMember target = GuildTargetMember.set(@NotNull UserContextInteractionEvent);
```
**or:**
```java
GuildTargetMember target = GuildTargetMember.set(@NotNull MessageContextInteractionEvent);
```

### Methods

> Constructs a <b>new GuildTargetMember</b> instance. 
> <br>If you don't initialize a **UserContextInteractionEvent**, the **GuildTargetMember** always will be <b>null</b>.
>
> Parameter: **userEvent** - The **UserContextInteractionEvent**, which should be initialized.
> <br>Returns: A <b>new GuildTargetMember</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull UserContextInteractionEvent)
```
<br>

> Constructs a <b>new GuildTargetMember</b> instance. 
> If you don't initialize a **MessageContextInteractionEvent**, the **GuildTargetMember** always will be <b>null</b>.
>
> Parameter: **messageEvent** - The **MessageContextInteractionEvent**, which should be initialized.
> <br>Returns: A <b>new GuildTargetMember</b> instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageContextInteractionEvent)
```
<br>

> Indicates that a user context-command was used.
>
> Returns: The **UserContextInteractionEvent**.
> <br>Annotation: **NotNull**
```swift
getUserContext()
```
<br>

> Indicates that a message context-command was used.
>
> Returns: The **MessageContextInteractionEvent**.
> <br>Annotation: **NotNull**
```swift
getMessageContext()
```
<br>

> Checks if the **Role** with the id you specified, is found on the **Role** board of the **TargetMember**.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns: The **Role** with the id you specified.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(long)
```
<br>

> Checks if the **Role** with the id you specified, is found on the **Role** board of the **TargetMember**.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns: The **Role** with the id you specified.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(@NotNull String)
```
<br>

> Checks if the **Role** with the name you specified, is found on the **Role** board of the **TargetMember**.
>
> Parameter: **roleName** - The name of the **Role**, which should be checked.
> <br>Returns: The **Role** with the name you specified.
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleByName(@NotNull String)
```
<br>

> Checks if the **TargetMember** has the **Role** with the id you specified.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **TargetMember** has the **Role**.
> <br>**false** - If the **TargetMember** has not the **Role** .
```swift
hasRoleWithId(long)
```
<br>

> Checks if the **TargetMember** has the **Role** with the id you specified.
>
> Parameter: **roleId** - The id of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **TargetMember** has the **Role**.
> <br>**false** - If the **TargetMember** has not the **Role**.
```swift
hasRoleWithId(@NotNull String)
```
<br>

> Checks if the **TargetMember** has the **Role** with the name you specified.
>
> Parameter: **roleName** - The name of the **Role**, which should be checked.
> <br>Returns:
> <br>**true** - If the **TargetMember** has the **Role**.
> <br>**false** - If the **TargetMember** has not the **Role**.
```swift
hasRoleWithName(@NotNull String)
```
<br>

> Checks if the **TargetMember** was pinged in a specified **Message**.
>
> Parameter: **message** - The **Message**, which should checked, if the **TargetMember** got pinged in the **Message**.
> <br>Returns:
> <br>**true** - If the **TargetMember** got pinged in the **Message**.
> <br>**false** - If the **TargetMember** got pinged in the **Message**.
```swift
isMentioned(@NotNull Message)
```

### Overridden methods

```swift
equals(@Nullable Object)
hashCode()
toString()
```

<hr>

## GuildThreadMember

```yml
Author: BlockyDotJar
Version: v1.1.4
Since: v1.1.1
```

**Description:** Represents a **Member**, who joined a **ThreadChannel**.

### Getting GuildThreadMember:

```java
GuildThreadMember member = GuildThreadMember.set(@NotNull ThreadMember);
```

### Methods

> Constructs a <b>new GuildThreadMember</b> instance. 
> <br>If you don't initialize a **ThreadMember**, the **GuildThreadMember** always will be <b>null</b>.
>
> Parameter: **member** - The **ThreadMember**, which should be used to get **GuildThreadMember**.
> <br>Returns: A <b>new</b> **GuildThreadMember** instance.
> <br>Annotation: **NotNull**
```swift
set(@NotNull ThreadMember)
```
<br>

> The author of the **Message** received as **Member** object.
>
> Returns: The author of the **Message** as **non-null ThreadMember** object.
> <br>Annotation: **NotNull**
```swift
getMember()
```
<br>

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

```swift
equals(@Nullable Object)
hashCode()
toString()
```

<hr>

## SelfMember

```yml
Author: BlockyDotJar
Version: v1.1.4
Since: v1.0.1
```

**Description:** Represents the **SelfMember** (aka. the bot itself) of a specific **Guild**.

### Getting SelfMember:

```java
SelfMember self = SelfMember.set(@NotNull Guild);
```

### Methods

> Constructs a <b>new SelfMember</b> instance.
> <br>If you don't initialize a **Guild**, the **SelfMember** always will be <b>null</b>.
>
> Parameter: **guild** - The **Guild**, which should be used to get the **SelfMember**
> <br>Returns: A <b>new SelfMember</b> instance.
> <br>Annotation: **NotNull**.
```swift
set(@NotNull Guild)
```
<br>

> The **Guild**, the message was received in.
>
> Returns: The **Guild**, the message was received in.
> <br>Annotation: **Nullable**
```swift
getGuild()
```
<br>

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

```swift
equals(@Nullable Object)
hashCode()
toString()
```

<hr>

## VoiceRecorder

```yml
Author: BlockyDotJar
Version: v1.0.0
Since: v1.1.6
```

**PLEASE NOTE: Only use this feature to record conversations with the consent of all users in the channel.
<br>Recording a conversation against other users' consent is illegal, and you are violating the Discord Terms of Service.**

**Description:** This class is used to record audio from a VoiceChannel.

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
> <p>This method will start recording audio from the **VoiceChannel** that the bot is currently in.
> <br>This method will return a **File** that contains the audio that was recorded.
>
> <p>This is recommended to use in the **ListenerAdapter#onGuildVoiceLeave(GuildVoiceLeaveEvent)** method.
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

## MessageMention

```yml
Author: BlockyDotJar
Version: v1.0.0
Since: v1.1.6
```

**Description:** Class to access the mentions of various entities.

### Getting MessageMention:

```java
MessageMention mention = MessageMention.set(@NotNull Message);
```

### Methods

> Constructs a <b>new MessageMention</b> instance.
> <br>If you don't initialize a **Message**, the **MessageMention** always will be <b>null</b>.
>
> Parameter: **message** - The **Message**, which should be used to get a **MessageMention**.
> <br>Returns: A <b>new</b> **MessageMention** instance.
```swift
set(@NotNull Message)
```
<br>

> The received **Message** object.
>
> Returns: The received **Message** object.
> <br>Annotation: **NotNull**
```swift
getMessage()
```
<br>

> An immutable **List** of all mentioned slash-commands.
> <br>If none were mentioned, this **List** is empty.
> <br>Elements are sorted in order of appearance.
>
> Returns: A **List** of all mentioned slash-commands.
> <br>Annotation: **NotNull**
```swift
getSlashCommands()
```
<br>

> A **Bag** of slash-commands used.
> <br>This can be used to retrieve the amount of times a slash-command was used.
> <br><b>Example:</b>
> <br><pre><code>
> void sendCount(@NotNull MessageMention msg)
> {
>     List<String> mentions = msg.getSlashCommands(); // distinct list, in order of appearance
>     Bag<String> count = msg.getSlashCommandsBag();
>     StringBuilder content = new StringBuilder();
>     for (String slash : mentions)
>     {
>         content.append(slash)
>                .append(": ")
>                .append(count.getCount(slash))
>                .append("\n");
>     }
>     msg.getMessage().getChannel().sendMessage(content.toString()).queue();
> }
> </code></pre>
>
> Returns: **Bag** of used slash-commands.
> <br>Annotation: **NotNull**
```swift
getSlashCommandsBag()
```
<br>

> Checks if given **Type** is mentioned in the **Message**.
>
> Parameter: **type** - The **Type** to check for.
> <br>Returns:
> <br><b>true</b> - If the **Type** is mentioned in the **Message**.
> <br><b>false</b> - If the **Type** is not mentioned in the **Message**.
```swift
isMentioned(@NotNull Type)
```
<br>

> Creates a slash-command mention for you.
> <br>Only use this method in combination with <code>SlashCommandEventInteractionEvent.getRawData()</code>.
>
> Parameter: **rawData** - The **DataObject** to parse. (Only use this method in combination with <code>SlashCommandEventInteractionEvent.getRawData()</code>).
> <br>Returns: The slash-command mention as a string.
> <br>Annotation: **NotNull**
```swift
createSlashCommandMention(@NotNull DataObject)
```

### Overridden methods

```swift
equals(@Nullable Object)
hashCode()
toString()
```

## Type

```yml
Author: BlockyDotJar
Version: v1.0.0
Since: v1.1.6
```

**Description:** Mention constants, useful for use with **Patterns**.

### Getting VoiceRecorder:

```java
MessageMention.Type mentionType = MessageMention.Type.FIELD_NAME;
```

### Methods

> Represents a mention for a slash-command.
> <br>The first group matches the name of the command and the second the id of the mention.
```java
SLASH_COMMAND("</([a-zA-Z0-9_/[^\\S\\r\\n]/-]+):([0-9]+)>");
```
<br>

> Annotation: **NotNull** 
```swift
getPattern()
```

### Overridden methods

```swift
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
@Target( { TYPE, METHOD } )
```

```yml
Author: BlockyDotJar
Version: v1.1.1
Since: v1.0.0-alpha.1
```

**Description:** This is an annotation, which tells the developers that a method/class should be finish in the future. <br>

### Methods

> Returns: The version, in which the <b>new</b> method/class should be finished.
```swift
version()
```

## DeprecatedSince

```swift
@Retention(RUNTIME)
@Target( { TYPE, METHOD } )
```

```yml
Author: BlockyDotJar
Version: v1.1.1
Since: v1.0.0-alpha.1
```

**Description:** This is an annotation, which tells the developers since when a method/class is deprecated. <br>

### Methods

> Returns: The version, since when the method/class is deprecated.
```swift
version()
```

## ForRemoval

```swift
@Retention(RUNTIME)
@Target( { TYPE, METHOD } )
```

```yml
Author: BlockyDotJar
Version: v1.1.1
Since: v1.0.0
```

**Description:** This is an annotation, which tells the developers that a method/class should be removed in the future. <br>

### Methods

> Returns: The version, in which the deprecated method/class should be removed.
```swift
deadline()
```

## ReplaceWith

```swift
@Retention(RUNTIME)
@Target( { TYPE, METHOD } )
```

```yml
Author: BlockyDotJar
Version: v1.1.2
Since: v1.0.0-alpha.1
```

**Description:** This is an annotation, which tells the developers, with which method/class a deprecated method/class should be replaced. <br>

### Methods

> Returns: The method or class, which should used instead.
```swift
value()
```

## Undocumented

```swift
@Retention(RUNTIME)
@Target( { PACKAGE, TYPE, METHOD, CONSTRUCTOR } )
```

```yml
Author: BlockyDotJar
Version: v1.1.1
Since: v1.0.0
```

**Description:** This is an annotation, which tells the developers that a method/class/constructor/package is not documented yet. <br>

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
