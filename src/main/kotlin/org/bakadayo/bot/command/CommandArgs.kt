package org.bakadayo.bot.command

interface CommandArgs {
    operator fun get(name: String): String?

    companion object {
        infix fun of(args: Map<String, String>): MessageCommandArgs = MessageCommandArgs(args)
    }
}