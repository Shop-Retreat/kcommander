# KCommander
A Discord command framework for Discord4J and Kotlin. For people who have experience with Discord4J but want to develop bots in Kotlin.

I originally developed the bot framework as a part of a project, but then decided to make it a Maven module.
For now it's not finished.

Example usage:
```kotlin
bot("test") {
    commands {
        command {
            data {
                name = "test"
            }

            subcommands {
                subcommand {
                    data {
                        name = "subtest"
                    }

                    code {
                        event.message.channel.block()?.createMessage("test subcommand")
                    }
                }
            }

            code {
                event.message.channel.block()?.createMessage("test command")
            }
        }
    }
    
    connect()
}
```