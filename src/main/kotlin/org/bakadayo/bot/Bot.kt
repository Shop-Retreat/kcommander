package org.bakadayo.bot

import discord4j.core.DiscordClient
import discord4j.core.DiscordClientBuilder
import org.bakadayo.bot.command.CommandContainer
import org.bakadayo.bot.event.EventContainer

class Bot(val token: String) {
    val client: DiscordClient = DiscordClientBuilder.create(token).build()

    var commandContainer = CommandContainer()

    var eventContainer = EventContainer(this)

    fun events(init: EventContainer.() -> Unit) {
        eventContainer.init()
    }

    fun commands(init: CommandContainer.() -> Unit) {
        commandContainer.init()
    }
}

fun bot(token: String, init: Bot.() -> Unit): Bot {
    val bot = Bot(token)
    bot.init()
    return bot
}