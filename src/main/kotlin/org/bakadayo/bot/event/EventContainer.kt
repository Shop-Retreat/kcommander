package org.bakadayo.bot.event

import discord4j.core.event.domain.Event
import kotlinx.coroutines.reactor.mono
import org.bakadayo.bot.Bot

class EventContainer(val bot: Bot) {
    inline fun <reified T : Event> event(noinline on: (T) -> Unit) {
        bot.client.withGateway {
            mono {
                it.on(T::class.java).subscribe(on)
            }
        }
    }

    inline fun <reified T : Event> eventProcessor(processor: EventProcessor<T>) {
        bot.client.withGateway {
            mono {
                it.on(T::class.java).subscribe {
                    processor.process(it)
                }
            }
        }
    }
}