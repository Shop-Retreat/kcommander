package org.bakadayo.bot.command

import discord4j.core.`object`.entity.Guild
import discord4j.core.`object`.entity.Member
import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.entity.channel.MessageChannel
import discord4j.core.event.domain.Event
import discord4j.core.event.domain.message.MessageCreateEvent
import discord4j.rest.util.Color

class MessageCommandEvent(event: MessageCreateEvent) : CommandEvent {
    override val message: Message = event.message

    override val channel: MessageChannel? = event.message.channel.block()

    override val guild: Guild? = event.guild.block()

    override val member: Member = event.member.get()

    override val rawEvent: Event = event

    override fun reply(message: String, embedColor: Color) {
        channel?.createEmbed {
            it.setAuthor(member.displayName, null, member.avatarUrl)
                .setColor(embedColor)
                .setDescription(message)
        }
    }
}