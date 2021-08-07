package net.shopretreat.bot

import discord4j.core.DiscordClient
import discord4j.core.DiscordClientBuilder
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.domain.message.MessageCreateEvent
import net.shopretreat.bot.command.CommandContainer
import net.shopretreat.bot.event.EventContainer
import net.shopretreat.bot.event.MessageCreateEventProcessor

class Bot(val token: String) {
    val client: DiscordClient = DiscordClient.create(token)

    val gateway: GatewayDiscordClient = client.login().block() ?: throw Exception("Exiting, failed to log in")

    var commandContainer = CommandContainer()

    var eventContainer = EventContainer(this)

    private val bot = this

    fun events(init: EventContainer.() -> Unit) {
        eventContainer.init()
    }

    fun commands(init: CommandContainer.() -> Unit) {
        commandContainer.init()
    }

    fun defaultConfiguration() {
        val messageEventProcessor = MessageCreateEventProcessor(bot)

        gateway.on(MessageCreateEvent::class.java).subscribe {
            messageEventProcessor.process(it)
        }

        gateway.onDisconnect().block()
    }
}

fun bot(token: String, init: Bot.() -> Unit): Bot {
    val bot = Bot(token)
    bot.init()
    bot.defaultConfiguration()
    return bot
}