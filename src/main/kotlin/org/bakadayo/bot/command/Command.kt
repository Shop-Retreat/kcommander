package org.bakadayo.bot.command

import org.bakadayo.bot.command.subcommand.Subcommand

class Command {
    var data = CommandData()

    var subcommands = emptySet<Subcommand>()

    var execute = { _: CommandContext -> }

    fun data(init: CommandData.() -> Unit): CommandData {
        data.init()
        return data
    }

    fun subcommand(init: CommandData.() -> Unit) {

    }

    fun code(code: CommandContext.() -> Unit) {
        execute = code
    }
}