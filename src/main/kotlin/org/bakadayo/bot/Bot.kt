package org.bakadayo.bot

import org.bakadayo.bot.command.CommandContainer

class Bot internal constructor(token: String) {
    var commandContainer = CommandContainer()

    fun commands(init: CommandContainer.() -> Unit) {
        commandContainer.init()
    }
}

fun bot(token: String, init: Bot.() -> Unit): Bot {
    val bot = Bot(token)
    bot.init()
    return bot
}