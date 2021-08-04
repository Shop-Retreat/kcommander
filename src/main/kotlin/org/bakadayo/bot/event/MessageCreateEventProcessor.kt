package org.bakadayo.bot.event

import discord4j.core.event.domain.message.MessageCreateEvent
import discord4j.rest.util.ApplicationCommandOptionType
import org.bakadayo.bot.Bot
import org.bakadayo.bot.command.CommandArgs
import org.bakadayo.bot.command.Command
import org.bakadayo.bot.command.CommandEvent
import org.bakadayo.bot.command.subcommand.Subcommand

class MessageCreateEventProcessor(private val bot: Bot) : EventProcessor<MessageCreateEvent> {
    override fun process(sourceEvent: MessageCreateEvent) {
        val (command, subcommand, args) = parseMessage(sourceEvent)

        if (command == null || args == null)
            return

        val event = CommandEvent of sourceEvent
    }

    private fun parseMessage(event: MessageCreateEvent): Triple<Command?, Subcommand?, CommandArgs?> {
        val noPrefix = event.message.content.removePrefix(bot.token)
        val splitMessage = noPrefix.split(" ")

        if (splitMessage.isEmpty())
            return Triple(null, null, null)

        val command = bot.commandContainer.find {
            it.data.name == splitMessage[0] ||
                    it.data.aliases.contains(splitMessage[0])
        } ?: return Triple(null, null, null)

        if (splitMessage.size == 1)
            return Triple(command, null, null)

        val subcommand = command.subcommands.find {
            it.data.name == splitMessage[1] ||
                    it.data.aliases.contains(splitMessage[1])
        }

        val commandArgs: MutableList<Pair<String, ApplicationCommandOptionType>>

        val args = if (subcommand != null) {
            commandArgs = subcommand.data.args
            splitMessage.subList(2, 2 + commandArgs.size)
        } else {
            commandArgs = command.data.args
            splitMessage.subList(1, 1 + commandArgs.size)
        }

        val data = CommandArgs of commandArgs.map { it.first }.zip(args).toMap()

        return Triple(command, subcommand, data)
    }
}