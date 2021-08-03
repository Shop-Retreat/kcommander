package org.bakadayo.bot.processing

import discord4j.core.event.domain.message.MessageCreateEvent
import org.bakadayo.bot.command.CommandArgs
import org.bakadayo.bot.command.Command
import org.bakadayo.bot.command.subcommand.Subcommand

object MessageCreateEventProcessor : EventProcessor<MessageCreateEvent> {
    override fun process(event: MessageCreateEvent): Triple<Command?, Subcommand?, CommandArgs> {
        TODO("Not yet implemented")
    }
}