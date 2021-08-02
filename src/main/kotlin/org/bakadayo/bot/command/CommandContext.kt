package org.bakadayo.bot.command

import discord4j.core.event.domain.message.MessageCreateEvent

class CommandContext(val event: MessageCreateEvent, val args: List<String>)
