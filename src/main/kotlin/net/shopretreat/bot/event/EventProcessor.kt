package net.shopretreat.bot.event

import discord4j.core.event.domain.Event
import discord4j.core.event.domain.message.MessageCreateEvent

interface EventProcessor<T : Event> {
    fun process(sourceEvent: T)
}