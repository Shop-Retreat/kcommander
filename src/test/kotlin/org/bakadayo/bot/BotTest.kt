package org.bakadayo.bot

import org.junit.jupiter.api.Test

internal class BotTest {
    @Test
    fun bot() {
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
        }
    }
}