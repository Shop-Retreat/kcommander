package org.bakadayo.bot.event

import discord4j.core.event.domain.Event

interface EventProcessor<T : Event> {
    fun process(sourceEvent: T)
}