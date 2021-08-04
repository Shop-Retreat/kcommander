package org.bakadayo.bot.event

import discord4j.core.event.domain.Event
import discord4j.core.event.domain.message.MessageCreateEvent

interface EventProcessor<T : Event> {
    suspend fun process(sourceEvent: T)
}