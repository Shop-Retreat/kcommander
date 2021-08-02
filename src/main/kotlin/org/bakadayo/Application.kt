package org.bakadayo

import org.bakadayo.bot.bot

fun main() {
    bot("test") {
        command {
            data {
                name = "ping"
                description = "Pong!"
            }

            code {
                event.message
                    .channel
                    .block()
                    ?.createMessage("Ping!")
            }
        }

        command {
            // Another command
        }
    }
}