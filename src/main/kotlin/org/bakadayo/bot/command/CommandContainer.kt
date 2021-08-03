package org.bakadayo.bot.command

class CommandContainer : LinkedHashSet<Command>() {
    fun command(init: Command.() -> Unit) {
        val command = Command()
        command.init()
        add(command)
    }
}