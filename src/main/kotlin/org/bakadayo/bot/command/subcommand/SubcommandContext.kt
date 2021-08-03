package org.bakadayo.bot.command.subcommand

import discord4j.core.event.domain.message.MessageCreateEvent

class SubcommandContext(val event: MessageCreateEvent, val args: List<String>)