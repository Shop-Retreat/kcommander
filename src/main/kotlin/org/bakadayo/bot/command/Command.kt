package org.bakadayo.bot.command

import org.bakadayo.bot.command.subcommand.SubcommandContainer

class Command {
    var data = CommandData()

    var subcommands = SubcommandContainer()

    var execute = { _: CommandContext -> }

    fun data(init: CommandData.() -> Unit) {
        data.init()
    }

    fun subcommands(init: SubcommandContainer.() -> Unit) {
        subcommands.init()
    }

    fun code(code: CommandContext.() -> Unit) {
        execute = code
    }
}