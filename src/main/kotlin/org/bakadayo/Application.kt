package org.bakadayo

import org.bakadayo.bot.bot
import org.bakadayo.bot.commands.pingCommand

fun main() {
    bot("test") {
        commands {
            command {
                pingCommand()
            }
        }
    }
}