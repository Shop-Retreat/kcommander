package org.bakadayo.bot

class Bot internal constructor(token: String) : Tag("bot") {
    var commands: MutableSet<Command> = mutableSetOf()

    fun command(init: Command.() -> Unit): Command {
        val command = Command()
        command.init()
        commands.add(command)
        return command
    }
}

fun bot(token: String, init: Bot.() -> Unit): Bot {
    val bot = Bot(token)
    bot.init()
    return bot
}