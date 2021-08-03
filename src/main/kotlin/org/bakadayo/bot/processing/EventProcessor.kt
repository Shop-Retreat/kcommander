package org.bakadayo.bot.processing

import discord4j.core.event.domain.Event
import org.bakadayo.bot.command.CommandArgs
import org.bakadayo.bot.command.Command
import org.bakadayo.bot.command.subcommand.Subcommand

interface EventProcessor<T : Event> {
    fun process(event: T): Triple<Command?, Subcommand?, CommandArgs>
}