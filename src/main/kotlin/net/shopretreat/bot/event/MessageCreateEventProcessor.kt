package net.shopretreat.bot.event

import discord4j.core.event.domain.message.MessageCreateEvent
import discord4j.rest.util.ApplicationCommandOptionType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import net.shopretreat.bot.Bot
import net.shopretreat.bot.command.CommandArgs
import net.shopretreat.bot.command.Command
import net.shopretreat.bot.command.CommandContext
import net.shopretreat.bot.command.CommandEvent
import net.shopretreat.bot.command.subcommand.Subcommand

class MessageCreateEventProcessor(private val bot: Bot) : EventProcessor<MessageCreateEvent> {
    override fun process(sourceEvent: MessageCreateEvent) {
        val scope = CoroutineScope(Dispatchers.IO)

        scope.launch {
            val (command, subcommand, args) = parseMessage(sourceEvent)

            if (command == null)
                return@launch

            val context = CommandContext(CommandEvent of sourceEvent, args)

            if (subcommand != null) {
                if (subcommand.data.executeMainCommand) {
                    command.execute.invoke(context)
                    subcommand.execute.invoke(context)
                    return@launch
                }

                subcommand.execute.invoke(context)
                return@launch
            }

            command.execute.invoke(context)
        }
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