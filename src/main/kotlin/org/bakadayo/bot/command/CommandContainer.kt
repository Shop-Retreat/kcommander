package org.bakadayo.bot.command

class CommandContainer(var commands: MutableSet<Command> = mutableSetOf()) {
    fun command(init: Command.() -> Unit) {
        val command = Command()
        command.init()
        commands.add(command)
    }
}