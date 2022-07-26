[github-packages]: https://img.shields.io/github/v/release/BlockyDotJar/JDA-Commons

[license-shield]: https://img.shields.io/badge/License-Apache%202.0-white.svg
[license]: https://github.com/BlockyDotJar/JDA-Commons/tree/main/LICENSE

[discord-invite-shield]: https://discord.com/api/guilds/876766868864647188/widget.png
[discord-invite]: https://discord.gg/FnGFbzCw2r

[download]: #download

[ ![github-packages][] ][download]
[ ![license-shield][] ][license]
[ ![discord-invite-shield][] ][discord-invite]

> Note: If you have any suggestions/questions/feedback for this wiki please contact Blocky.jar ツ#8117 via [Discord](https://discord.gg/FnGFbzCw2r)

If you want some examples for JDA too than check out the [example directory](https://github.com/BlockyDotJar/JDA-Commons/tree/main/src/main/java/dev/blocky/library/testzone).

## Summary

1. [CommonsClient](#commonsclient)
2. [Utility](#utility)
3. [GuildController](#guildcontroller)
4. [Interfaces](#interfaces)
5. [SafetyClear](#safetyclear)
6. [XYChannel](#xychannel)
7. [XYMember](#xymember)
8. [Annotations](#annotations)
9. [Download](#download)
10. [Support](#getting-help)

<hr>

## CommonsClient

```swift
@Deadline(version = "v1.5.0")
```

```yml
Author: BlockyDotJar
Version: v1.0.0-alpha.4
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
@Deadline(version = "v1.6.0")
```

```yml
Author: BlockyDotJar
Version: v1.0.0-alpha.5
Since: v1.0.0
```

**Description:** This is the builder for the commons client.

### Getting CommonsClient.Builder:

`N/A` You can not get this class.

### Methods

> Represents a <b>new</b> commons client instance.
>
> Returns: A <b>new</b> commons client instance 
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
Version: v1.1.4
Since: v1.0.0
```

**Description:** This is a class, which has many utility methods in it.

### Getting Utility:

`N/A` You can not get this class.

### Methods

> Checks, which safety clear enum is given. (if **clear** equals null, the safety clear enum will be set to **SafetyClear#NONE**)
>
> Parameter:
> <br>**clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>**channel** - The text channel, which should be initialized
> <br>**amount** - The amount of messages to delete
> <br>Returns: A list of messages representing the precursor of all deletion tasks
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
checkClearSafety(@Nullable SafetyClear, @NotNull TextChannel, int)
```
<br>

> Checks, which safety clear enum is given. (if **clear** equals null, the safety clear enum will be set to **SafetyClear#NONE**)
>
> Parameter:
> <br>**clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>**channel** - The message channel, which should be initialized
> <br>**amount** - The amount of messages to delete
> <br>Returns: A list of messages representing the precursor of all deletion tasks
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
checkClearSafety(@Nullable SafetyClear, @NotNull MessageChannel, int)
```
<br>

> Checks, which safety clear enum is given. (if **clear** equals null, the safety clear enum will be set to **SafetyClear#NONE**).
>
> Parameter:
> <br>**clear**   The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>**channel** The text channel, which should be initialized
> <br>Returns: A list of messages representing the precursor of all deletion tasks
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
checkChannelClearSafety(@Nullable SafetyClear, @NotNull TextChannel)
```
<br>

> Checks, which safety clear enum is given. (if **clear** equals null, the safety clear enum will be set to **SafetyClear#NONE**).
>
> Parameter:
> <br>**clear**   The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>**channel** The message channel, which should be initialized
> <br>Returns: A list of messages representing the precursor of all deletion tasks
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
checkChannelClearSafety(@Nullable SafetyClear, @NotNull MessageChannel)
```
<br>

> Calculates the delay, depending on which time unit is specified.
>
> Parameter:
> <br>**unit** - The time unit, which should be used for calculating each time (if time unit equals null the default time unit will be used **[TimeUnit#SECONDS]**)
> <br>**delayInSeconds** - The delay in seconds which should be converted
> <br>Returns: The delay calculated to the specified time unit
```swift
calculateDelay(@Nullable TimeUnit, long)
```
<br>

> The hash map instance from the utility class.
>
> Returns: **Utility#map**
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
getHashMap()
```

### Overridden methods

`N/A` No overridden method found in this class.

<hr>

## GuildController

```swift
@Deadline(version = "v1.5.0")
```

```yml
Author: BlockyDotJar
Version: v1.0.0-beta.1
Since: v1.0.0
```

**Description:** This is a controller you can control guilds with. The exact use is still **unknown.**

### Getting GuildController:

```java
GuildController controller = GuildController.set(@Nullable Guild);
```

### Methods

> Constructs a <b>new</b> guild controller instance. If you don't initialize a guild,
> the guild controller always will be <b>null</b>.
>
> Parameter: **guild** - The guild, which should be used to get guild controller
> <br>Returns: A <b>new</b> guild controller instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull Guild)
```
<br>

> The guild, the message was received in.
>
> Returns: The guild the message was received in
> <br>Annotation: **Nullable**
```swift
getGuild()
```
<br>

> Gets a <b>new</b> self member, by initializing a specific guild.
>
> Returns: A <b>new</b> self member instance
> <br>Annotation: **NotNull**
```swift
getSelfMember()
```
<br>

> As the user is typing an argument that has autocomplete enabled for it, the bot will receive an
> command-autocomplete-interaction-event.
> This event isn't fired for each keystroke, but is sent when Discord determines the user has paused typing for a bit.
>
> Autocompletions can suggest up to 25 options, and users do not have to send a command with one of the options.
> Maps the words to choices and only displays words that start with the user's current input.
>
> Parameter:
> <br>**query** - The query input for an auto-complete interaction
> <br>**words** - An array of words that can be displayed in the autocomplete menu
>
> Returns: A list of choices, you can use to display it with `replyChoices(Collection)`
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
Version: v2.1.2
Since: v1.0.0-alpha.3
```

**Description:** A simple command interface, which you can use to easily program message commands.

### Getting ICommand:

Of course you can not get an interface. <br>
Because of this you need a [command manager](https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/test/java/dev/blocky/discord/CommandManager.java) to use this interface.

### Methods

> A simple command interface, which you can use to easily program message commands.
> <br>This contains a command manager.
>
> Parameter:
> <br>**event** - The message received event for performing a command
> <br>**args** - An array of strings for performing a command
```swift
onCommand(@NotNull MessageReceivedEvent, @NotNull String[])
```

### Overridden methods

`N/A` No overridden method found in this interface.

<hr>

## ISlashCommand

```yml
Author: BlockyDotJar
Version: v2.1.2
Since: v1.0.0
```

**Description:** A simple slash command interface, which you can use to easily program some slash commands.

### Getting ISlashCommand:

Of course you can not get an interface. <br>
Because of this you need an [application command manager](https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/test/java/dev/blocky/discord/ApplicationCommandManager.java) to use this interface.

### Methods

> A simple slash command interface, which you can use to easily program some slash commands.
> <br>This contains an application command manager.
>
> Parameter: **event** - Indicates that a slash command was used in a message channel
```swift
onSlashCommand(@NotNull SlashCommandInteractionEvent)
```

### Overridden methods

`N/A` No overridden method found in this interface.

<hr>

## IAutoCompletable

```yml
Author: BlockyDotJar
Version: v1.0.1
Since: v1.1.4
```

**Description:** A simple slash command interface, which you can use to easily program some slash commands with auto-complete.

### Getting IAutoCompletable:

Of course you can not get an interface. <br>
Because of this you need an [application command manager](https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/test/java/dev/blocky/discord/ApplicationCommandManager.java) to use this interface.

### Methods

> A simple slash command interface, which you can use to easily program some slash commands with auto-complete.
> <br>This contains an application command manager.
>
> Parameter: **event** - Indicates that a slash command with auto-complete was used in a message channel
```swift
onCommandAutoComplete(@NotNull CommandAutoCompleteInteractionEvent)
```

### Overridden methods

`N/A` No overridden method found in this interface.

<hr>

## IMessageContext

```yml
Author: BlockyDotJar
Version: v1.1.2
Since: v1.0.0
```

**Description:** A simple message context menu interface, which you can use to easily program some message context menus.

### Getting IMessageContext:

Of course you can not get an interface. <br>
Because of this you need an [application command manager](https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/test/java/dev/blocky/discord/ApplicationCommandManager.java) to use this interface.

### Methods

> A simple message context menu interface, which you can use to easily program some message context menus.
> <br>This contains an  application command manager.
>
> Parameter: **event** - Indicates that a message context command was used
```swift
onMessageContext(@NotNull MessageContextInteractionEvent)
```

### Overridden methods

`N/A` No overridden method found in this interface.

<hr>

## IUserContext

```yml
Author: BlockyDotJar
Version: v1.1.2
Since: v1.0.0
```

**Description:** A simple user context menu interface, which you can use to easily program some user context menus.

### Getting IUserContext:

Of course you can not get an interface. <br>
Because of this you need an [application command manager](https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/test/java/dev/blocky/discord/ApplicationCommandManager.java) to use this interface.

### Methods

> A simple user context menu interface, which you can use to easily program some user context menus.
> <br>This contains an application command manager.
>
> Parameter: **event** - Indicates that a message context command was used
```swift
onUserContext(@NotNull UserContextInteractionEvent)
``` 

### Overridden methods

`N/A` No overridden method found in this interface.

<hr>

## SafetyClear

```yml
Author: BlockyDotJar
Version: v1.1.0
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

> The clear process will be done with all possible checks.
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
GuildTextChannel channel = GuildTextChannel.set(@NotNull TextChannel, @Nullable Member);
```

**Alternatively:**
```java
GuildTextChannel channel = GuildTextChannel.set(@NotNull TextChannel);
```

### Methods

> Constructs a <b>new</b> guild text channel instance.
> <br>If you don't initialize a text channel or a member, the guild text channel always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The text channel, which should be initialized
> <br>**member** - The member, which should be initialized
> <br>Returns: A <b>new</b> guild text channel instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull TextChannel, @Nullable Member)
```
<br>

> Constructs a <b>new</b> guild text channel instance.
> <br>If you don't initialize a text channel, the guild text channel always will be <b>null</b>.
>
> Parameter: **channel** - The text channel, which should be initialize
> <br>Returns: A <b>new</b> guild text channel instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull TextChannel)
```
<br>

> The author of the message received as member object.
>
> Returns: The author of the message as null-able member object
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> The text channel for this message.
>
> Returns: The text channel
> <br>Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete
> <br>**clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete text channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter: **clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete text channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter: 
> <br>**content** - The message content, which should be checked 
> <br>**checkAmount** - The amount of messages, which should be checked 
> <br>Returns: 
> <br>**true** - If the content, you specified, is written in this channel
> <br>**false** - If the content, you specified, is not written in this channel
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the member, which was specified with the `set(@NotNull TextChannel, @Nullable Member)` method,
> in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember()
```
<br>

> Gets all the messages from a specific member in this channel. (max. 1000 messages per channel)
>
> Parameter: **member** - The member, from which the messages should be retrieved 
> <br>Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember(@Nullable Member)
```
<br>

> Gets all the messages from a specific user in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The member, from which the messages should be retrieved
> <br>Returns: The written messages of the specified user in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@Nullable User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals <b>null</b>, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals null, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long delay in seconds <b>must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction)
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
GuildMessageChannel channel = GuildMessageChannel.set(@NotNull MessageChannel, @Nullable Member);
```

**Alternatively:**
```java
GuildMessageChannel channel = GuildMessageChannel.set(@NotNull MessageChannel);
```

### Methods

> Constructs a <b>new</b> guild message channel instance.
> <br>If you don't initialize a message channel or a member, the guild message channel always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The message channel, which should be initialized
> <br>**member** - The member, which should be initialized
> <br>Returns: A <b>new</b> guild message channel instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannel, @Nullable Member)
```
<br>

> Constructs a <b>new</b> guild message channel instance.
> <br>If you don't initialize a message channel, guild message channel always will be <b>null</b>.
>
> Parameter: **channel** - The message channel, which should be initialized
> <br>Returns: A <b>new</b> guild message channel instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageChannel)
```
<br>

> The author of the message received as member object.
>
> Returns: The author of the message as null-able member object
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> The message channel for this message.
>
> Returns: The message channel
> <br>Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete
> <br>**clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete message channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter: **clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete message channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter:
> <br>**content** - The message content, which should be checked
> <br>**checkAmount** - The amount of messages, which should be checked
> <br>Returns:
> <br>**true** - If the content, you specified, is written in this channel
> <br>**false** - If the content, you specified, is not written in this channel
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the member, which was specified with the `set(@NotNull MessageChannel, @Nullable Member)` method,
> in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember()
```
<br>

> Gets all the messages from a specific member in this channel. (max. 1000 messages per channel)
>
> Parameter: **member** - The member, from which the messages should be retrieved
> <br>Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember(@Nullable Member)
```
<br>

> Gets all the messages from a specific user in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The member, from which the messages should be retrieved
> <br>Returns: The written messages of the specified user in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@Nullable User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals <b>null</b>, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals null, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long delay in seconds <b>must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction)
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

**Description:** Represents standard guild message channel that are news channels. The Discord client may refer to these as announcement channels. Members can subscribe channels in their own guilds to receive messages cross-posted from this channel. This is referred to as following this channel. Messages sent in this channel can be cross-posted, at which point they will be sent (via webhook) to all subscribed channels.

### Getting GuildNewsChannel:

**Recommended:**
```java
GuildNewsChannel channel = GuildNewsChannel.set(@NotNull NewsChannel, @Nullable Member);
```

**Alternatively:**
```java
GuildNewsChannel channel = GuildNewsChannel.set(@NotNull NewsChannel);
```

### Methods

> Constructs a <b>new</b> guild news channel instance.
> <br>If you don't initialize a news channel or a member, the guild news channel always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The news channel, which should be initialized
> <br>**member** - The member, which should be initialized
> <br>Returns: A <b>new</b> guild news channel instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull NewsChannel, @Nullable Member)
```
<br>

> Constructs a <b>new</b> guild news channel instance.
> <br>If you don't initialize a news channel, guild news channel always will be <b>null</b>.
>
> Parameter: **channel** - The news channel, which should be initialized 
> <br>Returns: A <b>new</b> guild news channel instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull NewsChannel)
```
<br>

> The author of the message received as member object.
>
> Returns: The author of the message as null-able member object
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> The news channel for this message.
>
> Returns: The news channel
> <br>Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter: <br>
> <br>**amount** - The amount of messages to delete
> <br>**clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete news channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter: **clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete news channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter:
> <br>**content** - The message content, which should be checked
> <br>**checkAmount** - The amount of messages, which should be checked
> <br>Returns:
> <br>**true** - If the content, you specified, is written in this channel
> <br>**false** - If the content, you specified, is not written in this channel
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the member, which was specified with the `set(@NotNull NewsChannel, @Nullable Member)` method,
> in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember()
```
<br>

> Gets all the messages from a specific member in this channel. (max. 1000 messages per channel)
>
> Parameter: **member** - The member, from which the messages should be retrieved
> <br>Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember(@Nullable Member)
```
<br>

> Gets all the messages from a specific user in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The member, from which the messages should be retrieved
> <br>Returns: The written messages of the specified user in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@Nullable User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals <b>null</b>, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals null, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long delay in seconds <b>must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction)
```
<br>

> Attempts to cross post the provided message automatically.
>
> The following error responses are possible:
> <ul>
> <li>
> <b>ALREADY_CROSSPOSTED</b> - The target message has already been cross-posted.
> </li>
> <li>
> <b>MISSING_ACCESS</b> - The request was attempted after the account lost access to the guild typically due to being kicked
> or removed, or after <b>Permission#VIEW_CHANNEL</b> was revoked in the message channel. 
> </li>
> <li>
> <b>MISSING_PERMISSIONS</b> - The request was attempted after the account lost <b>Permission#MESSAGE_MANAGE</b> in the message channel. 
> </li>
> <li>
> <b>UNKNOWN_MESSAGE</b> - The provided messageId is unknown in this message channel, either due to the id being invalid, or
> the message it referred to has already been deleted. 
> </li>
> <li>
> <b>UNKNOWN_CHANNEL</b> - The request was attempted after the channel was deleted. 
> </li>
> </ul>
>
> Returns: A rest-action - Type: message
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

**Description:** Represents private/public/news Discord thread channel.

### Getting GuildThreadChannel:

**Recommended:**
```java
GuildThreadChannel channel = GuildThreadChannel.set(@NotNull ThreadChannel, @Nullable Member);
```

**Alternatively:**
```java
GuildThreadChannel channel = GuildThreadChannel.set(@NotNull ThreadChannel);
```

### Methods

> Constructs a <b>new</b> guild thread channel instance.
> <br>If you don't initialize a thread channel or a member, the guild thread channel always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The thread channel, which should be initialized
> <br>**member** - The member, which should be initialized
> <br>Returns: A <b>new</b> guild thread channel instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull ThreadChannel, @Nullable Member)
```
<br>

> Constructs a <b>new</b> guild thread channel instance.
> <br>If you don't initialize a thread channel, guild thread channel always will be <b>null</b>.
>
> Parameter: **channel** - The thread channel, which should be initialized
> <br>Returns: A <b>new</b> guild thread channel instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull ThreadChannel)
```
<br>

> The author of the message received as member object.
>
> Returns: The author of the message as null-able member object
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> The thread channel for this message.
>
> Returns: The thread channel
> <br>Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete
> <br>**clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete thread channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter: **clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete thread channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter:
> <br>**content** - The message content, which should be checked
> <br>**checkAmount** - The amount of messages, which should be checked
> <br>Returns:
> <br>**true** - If the content, you specified, is written in this channel
> <br>**false** - If the content, you specified, is not written in this channel
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the member, which was specified with the `set(@NotNull ThreadChannel, @Nullable Member)` method,
> in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember()
```
<br>

> Gets all the messages from a specific member in this channel. (max. 1000 messages per channel)
>
> Parameter: **member** - The member, from which the messages should be retrieved
> <br>Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember(@Nullable Member)
```
<br>

> Gets all the messages from a specific user in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The member, from which the messages should be retrieved
> <br>Returns: The written messages of the specified user in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@Nullable User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals <b>null</b>, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals null, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long delay in seconds <b>must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction)
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

**Description:** Represents a Discord voice guild channel. Adds additional information specific to voice channels in Discord.

### Getting GuildVoiceChannel:

**Recommended:**
```java
GuildVoiceChannel channel = GuildVoiceChannel.set(@NotNull VoiceChannel, @Nullable Member);
```

**Alternatively:**
```java
GuildVoiceChannel channel = GuildVoiceChannel.set(@NotNull VoiceChannel);
```

### Methods

> Constructs a <b>new</b> guild voice channel instance.
> <br>If you don't initialize a voice channel or a member, the guild voice channel always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The voice channel, which should be initialized
> <br>**member** - The member, which should be initialized
> <br>Returns: A <b>new</b> guild voice channel instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull VoiceChannel, @Nullable Member)
```
<br>

> Constructs a <b>new</b> guild voice channel instance.
> <br>If you don't initialize a voice channel, guild voice channel always will be <b>null</b>.
>
> Parameter: **channel** - The voice channel, which should be initialized <br>
> <br>Returns: A <b>new</b> guild voice channel instance <br>
> <br>Annotation: **NotNull**
```swift
set(@NotNull VoiceChannel)
```
<br>

> The author of the message received as member object.
>
> Returns: The author of the message as null-able member object
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> The voice channel for this message.
>
> Returns: The voice channel
> Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete
> <br>**clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete voice channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter: **clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete voice channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter:
> <br>**content** - The message content, which should be checked
> <br>**checkAmount** - The amount of messages, which should be checked
> <br>Returns:
> <br>**true** - If the content, you specified, is written in this channel
> <br>**false** - If the content, you specified, is not written in this channel
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the member, which was specified with the `set(@NotNull VoiceChannel, @Nullable Member)` method,
> in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember()
```
<br>

> Gets all the messages from a specific member in this channel. (max. 1000 messages per channel)
>
> Parameter: **member** - The member, from which the messages should be retrieved
> <br>Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember(@Nullable Member)
```
<br>

> Gets all the messages from a specific user in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The member, from which the messages should be retrieved
> <br>Returns: The written messages of the specified user in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@Nullable User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals <b>null</b>, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals null, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long delay in seconds <b>must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction)
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

**Description:** Represents the connection used for direct messaging.

### Getting DirectMessageChannel:

**Recommended:**
```java
DirectMessageChannel channel = DirectMessageChannel.set(@NotNull PrivateChannel, @Nullable Member);
```

**Alternatively:**
```java
DirectMessageChannel channel = DirectMessageChannel.set(@NotNull PrivateChannel);
```

### Methods

> Constructs a <b>new</b> direct message channel instance.
> <br>If you don't initialize a private channel or a member, the direct message channel always will be <b>null</b>.
>
> Parameter:
> <br>**channel** - The private channel, which should be initialized
> <br>**member** - The member, which should be initialized
> <br>Returns: A <b>new</b> direct message channel instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull PrivateChannel, @Nullable Member)
```
<br>

> Constructs a <b>new</b> direct message channel instance.
> <br>If you don't initialize a private channel, direct message channel always will be <b>null</b>.
>
> Parameter: **channel** - The private channel, which should be initialized
> <br>Returns: A <b>new</b> direct message channel instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull PrivateChannel)
```
<br>

> The author of the message received as member object.
>
> Returns: The author of the message as null-able member object
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> The private channel for this message.
>
> Returns: The private channel
> <br>Annotation: **NotNull**
```swift
getChannel()
```
<br>

> Convenience method to delete messages in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter:
> <br>**amount** - The amount of messages to delete
> <br>**clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeMessages(int, @Nullable SafetyClear)
```
<br>

> Convenience method to a complete private channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Parameter: **clear** - The safety clear option, which helps for specifying different message types, which will not be deleted
> <br>Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel(@Nullable SafetyClear)
```
<br>

> Convenience method to a complete private channel in the most efficient way available.
> <br>No checks will be done to prevent failures, use **CompletionStage#exceptionally(Function)** to handle failures.
>
> Returns: A list of futures representing all deletion task
> <br>Annotation: **Nullable**
```swift
purgeChannel()
```
<br>

> Checks if the content, you specified, is written in this channel.
>
> Parameter:
> <br>**content** - The message content, which should be checked
> <br>**checkAmount** - The amount of messages, which should be checked
> <br>Returns:
> <br>**true** - If the content, you specified, is written in this channel
> <br>**false** - If the content, you specified, is not written in this channel
```swift
containsMessage(@NotNull CharSequence, int)
```
<br>

> Gets all the messages from the member, which was specified with the `set(@NotNull PrivateChannel, @Nullable Member)` method,
> in this channel. (max. 1000 messages per channel)
>
> Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember()
```
<br>

> Gets all the messages from a specific member in this channel. (max. 1000 messages per channel)
>
> Parameter: **member** - The member, from which the messages should be retrieved
> <br>Returns: The written messages of the specified member in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByMember(@Nullable Member)
```
<br>

> Gets all the messages from a specific user in this channel. (max. 1000 messages per channel)
>
> Parameter: **user** - The member, from which the messages should be retrieved
> <br>Returns: The written messages of the specified user in this channel
> <br>Annotation: **Nullable**
```swift
getMessagesByUser(@Nullable User)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals <b>null</b>, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction, @Nullable TimeUnit)
```
<br>

> This works like a normal message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The message action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
sendTimeoutedMessage(@NotNull MessageAction, long, @Nullable MessageAction)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
> <br>Another option you can use a specified time like minutes, hours or even days.
> <br>(if the time unit equals null, there will be used a default time unit: <b>TimeUnit#SECONDS</b>)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>**unit** - The time unit, which is used for specifying the type of time for the delay
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction, @Nullable TimeUnit)
```
<br>

> This works like a normal (message component) message sending, but with more given options and a delay between using this.
> <br>You must specify a delay to time out a command. (the long delay in seconds <b>must not equal to 0</b>.
> If this is <b>true</b> a illegal argument exception will be thrown. The same is applicable for numbers under 0)
> <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
> equals <b>null</b>, there will be sent a default error message)
>
> Parameter:
> <br>**message** - The reply callback action, which should be used
> <br>**delayInSeconds** - The delay for the executing command in seconds
> <br>**delayMessage** - The error message, which should appear, if the member has not waited for the delay yet
> <br>Returns: The specified message action
> <br>Annotation: **NotNull**, **CheckReturnValue**
```swift
replyTimeoutedMessage(@NotNull ReplyCallbackAction, long, @Nullable ReplyCallbackAction)
```
<br>

> Closes a private channel. After being closed successfully the private channel
> is removed from the JDA mapping.
> <br>As a note, this does not remove the history of the private channel. If the channel is
> reopened the history will still be present.
>
> Returns: A rest-action - Type: void
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

**Description:** Represents a guild-specific user.

### Getting GuildMember:

```java
GuildMember member = GuildMember.set(@Nullable Member);
```

### Methods

> Constructs a <b>new</b> guild member instance. 
> <br>If you don't initialize a member, the guild member always will be <b>null</b>.
>
> Parameter: **member** - The member, which should be used to get guild member
> <br>Returns: A <b>new</b> guild member instance
> <br>Annotation: **NotNull**
```swift
set(@Nullable Member)
```
<br>

> The author of the message received as member object.
>
> Returns: The author of the message as null-able member object
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> Checks if the role with the id you specified, is found on the role board of the member.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns: The role with the id you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(long)
```
<br>

> Checks if the role with the id you specified, is found on the role board of the member.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns: The role with the id you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(@NotNull String)
```
<br>

> Checks if the role with the name you specified, is found on the role board of the member.
>
> Parameter: **roleName** - The name of the role, which should be checked
> <br>Returns: The role with the name you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleByName(@NotNull String)
```
<br>

> Checks if the member has the role with the id you specified.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns:
> <br>**true** - If the member has the role
> <br>**false** - If the member has not the role
```swift
hasRoleWithId(long)
```
<br>

> Checks if the member has the role with the id you specified.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns:
> <br>**true** - If the member has the role
> <br>**false** - If the member has not the role
```swift
hasRoleWithId(@NotNull String)
```
<br>

> Checks if the member has the role with the name you specified.
>
> Parameter: **roleName** - The name of the role, which should be checked
> <br>Returns:
> <br>**true** - If the member has the role
> <br>**false** - If the member has not the role
```swift
hasRoleWithName(@NotNull String)
```
<br>

> Checks if the member was pinged in a specified message.
>
> Parameter: **message** - The message, which should checked, if the member got pinged in the message
> <br>Returns:
> <br>**true** - If the member got pinged in the message
> <br>**false** - If the member got pinged in the message
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

**Description:** Represents the member instance for the target user.

### Getting GuildTargetMember:

```java
GuildTargetMember target = GuildTargetMember.set(@NotNull UserContextInteractionEvent);
```
**or:**
```java
GuildTargetMember target = GuildTargetMember.set(@NotNull MessageContextInteractionEvent);
```

### Methods

> Constructs a <b>new</b> guild target member instance. 
> <br>If you don't initialize a user context interaction event, the guild target member always will be <b>null</b>.
>
> Parameter: **userEvent** - The user context interaction event, which should be initialized
> <br>Returns: A <b>new</b> guild target member instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull UserContextInteractionEvent)
```
<br>

> Constructs a <b>new</b> guild target member instance. 
> If you don't initialize a message context interaction event, the guild target member always will be <b>null</b>.
>
> Parameter: **messageEvent** - The message context interaction event, which should be initialized
> <br>Returns: A <b>new</b> guild target member instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull MessageContextInteractionEvent)
```
<br>

> Indicates that a user context command was used.
>
> Returns: The user context interaction event
> <br>Annotation: **NotNull**
```swift
getUserContext()
```
<br>

> Indicates that a message context command was used.
>
> Returns: The message context interaction event
> <br>Annotation: **NotNull**
```swift
getMessageContext()
```
<br>

> Checks if the role with the id you specified, is found on the role board of the target member.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns: The role with the id you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(long)
```
<br>

> Checks if the role with the id you specified, is found on the role board of the target member.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns: The role with the id you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(@NotNull String)
```
<br>

> Checks if the role with the name you specified, is found on the role board of the target member.
>
> Parameter: **roleName** - The name of the role, which should be checked
> <br>Returns: The role with the name you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleByName(@NotNull String)
```
<br>

> Checks if the target member has the role with the id you specified.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns:
> <br>**true** - If the target member has the role
> <br>**false** - If the target member has not the role 
```swift
hasRoleWithId(long)
```
<br>

> Checks if the target member has the role with the id you specified.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns:
> <br>**true** - If the target member has the role
> <br>**false** - If the target member has not the role
```swift
hasRoleWithId(@NotNull String)
```
<br>

> Checks if the target member has the role with the name you specified.
>
> Parameter: **roleName** - The name of the role, which should be checked
> <br>Returns:
> <br>**true** - If the target member has the role
> <br>**false** - If the target member has not the role
```swift
hasRoleWithName(@NotNull String)
```
<br>

> Checks if the target member was pinged in a specified message.
>
> Parameter: **message** - The message, which should checked, if the target member got pinged in the message
> <br>Returns:
> <br>**true** - If the target member got pinged in the message
> <br>**false** - If the target member got pinged in the message
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

**Description:** Represents a member, who joined a thread channel.

### Getting GuildThreadMember:

```java
GuildThreadMember member = GuildThreadMember.set(@Nullable ThreadMember);
```

### Methods

> Constructs a <b>new</b> guild thread member instance. 
> <br>If you don't initialize a thread member, the guild thread member always will be <b>null</b>.
>
> Parameter: **member** - The thread member, which should be used to get guild thread member
> <br>Returns: A <b>new</b> guild thread member instance
> <br>Annotation: **NotNull**
```swift
set(@Nullable ThreadMember)
```
<br>

> The author of the message received as member object.
>
> Returns: The author of the message as null-able thread member object
> <br>Annotation: **Nullable**
```swift
getMember()
```
<br>

> Checks if the role with the id you specified, is found on the role board of the thread member.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns: The role with the id you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(long)
```
<br>

> Checks if the role with the id you specified, is found on the role board of the thread member.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns: The role with the id you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(@NotNull String)
```
<br>

> Checks if the role with the name you specified, is found on the role board of the thread member.
>
> Parameter: **roleName** - The name of the role, which should be checked
> <br>Returns: The role with the name you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleByName(@NotNull String)
```
<br>

> Checks if the thread member has the role with the id you specified.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns:
> <br>**true** - If the thread member has the role
> <br>**false** - If the thread member has not the role
```swift
hasRoleWithId(long)
```
<br>

> Checks if the thread member has the role with the id you specified.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns:
> <br>**true** - If the thread member has the role
> <br>**false** - If the thread member has not the role
```swift
hasRoleWithId(@NotNull String)
```
<br>

> Checks if the thread member has the role with the name you specified.
>
> Parameter: **roleName** - The name of the role, which should be checked
> <br>Returns:
> <br>**true** - If the thread member has the role
> <br>**false** - If the thread member has not the role
```swift
hasRoleWithName(@NotNull String)
```
<br>

> Checks if the thread member was pinged in a specified message.
>
> Parameter: **message** - The message, which should checked, if the thread member got pinged in the message
> <br>Returns:
> <br>**true** - If the thread member got pinged in the message
> <br>**false** - If the thread member got pinged in the message
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

**Description:** Represents the self member (aka. the bot itself) of a specific guild.

### Getting SelfMember:

```java
GuildController controller = GuildController.set(@Nullable Guild);
SelfMember self = controller.getSelfMember();
```

### Methods

> Constructs a <b>new</b> self member instance.
> <br>If you don't initialize a guild, the self member always will be <b>null</b>.
>
> Parameter: **guild** - The guild, which should be used to get the self member
> <br>Returns: A <b>new</b> self member instance
> <br>Annotation: **NotNull**
```swift
set(@NotNull Guild)
```
<br>

> The guild, the message was received in.
>
> Returns: The guild, the message was received in
> <br>Annotation: **Nullable**
```swift
getGuild()
```
<br>

> Checks if the role with the id you specified, is found on the role board of the self member.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns: The role with the id you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(long)
```
<br>

> Checks if the role with the id you specified, is found on the role board of the self member.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns: The role with the id you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleById(@NotNull String)
```
<br>

> Checks if the role with the name you specified, is found on the role board of the self member.
>
> Parameter: **roleName** - The name of the role, which should be checked
> <br>Returns: The role with the name you specified
> <br>Annotation: **Nullable**, **CheckReturnValue**
```swift
findRoleByName(@NotNull String)
```
<br>

> Checks if the self member has the role with the id you specified.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns:
> <br>**true** - If the self member has the role
> <br>**false** - If the self member has not the role
```swift
hasRoleWithId(long)
```
<br>

> Checks if the self member has the role with the id you specified.
>
> Parameter: **roleId** - The id of the role, which should be checked
> <br>Returns:
> <br>**true** - If the self member has the role
> <br>**false** - If the self member has not the role
```swift
hasRoleWithId(@NotNull String)
```
<br>

> Checks if the self member has the role with the name you specified.
>
> Parameter: **roleName** - The name of the role, which should be checked
> <br>Returns:
> <br>**true** - If the self member has the role
> <br>**false** - If the self member has not the role
```swift
hasRoleWithName(@NotNull String)
```
<br>

> Checks if the self member was pinged in a specified message.
>
> Parameter: **message** - The message, which should checked, if the self member got pinged in the message
> <br>Returns:
> <br>**true** - If the self member got pinged in the message
> <br>**false** - If the self member got pinged in the message
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

## Annotations

**Summary:**

1. [Deadline](#deadline)
2. [DeprecatedSince](#deprecatedsince)
3. [ForRemoval](#forremoval)
4. [ReplaceWith](#replacewith)
4. [Undocumented](#undocumented)

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

> Returns: The version, in which the <b>new</b> method/class should be finished
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

> Returns: The version, since when the method/class is deprecated
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

> Returns: The version, in which the deprecated method/class should be removed
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

> Returns: The method or class, which should used instead
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
<br>If you need help, or just want to talk with the JDA-C or other Devs, you can join the [support server](https://discord.gg/FnGFbzCw2r).

<br>Especially interesting are the [getting started](https://jda.wiki/introduction/jda/)
and [Setup](https://jda.wiki/setup/intellij/) pages.
