package net.shopretreat.bot.command

import discord4j.core.`object`.entity.Guild
import discord4j.core.`object`.entity.Member
import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.entity.channel.MessageChannel
import discord4j.core.event.domain.Event
import discord4j.core.event.domain.message.MessageCreateEvent
import discord4j.rest.util.Color

interface CommandEvent {
    val message: Message

    val channel: MessageChannel?

    val guild: Guild?

    val member: Member

    val rawEvent: Event

    fun reply(message: String, embedColor: Color = Color.LIGHT_GRAY)

    companion object {
        infix fun of(event: MessageCreateEvent): MessageCommandEvent = MessageCommandEvent(event)
    }
}