package org.bakadayo.bot.commands

import org.bakadayo.bot.command.Command

fun Command.pingCommand() {
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