package org.bakadayo.bot.command.subcommand

import org.bakadayo.bot.command.CommandContext

class Subcommand {
    var data: SubcommandData = SubcommandData()

    var execute = { _: CommandContext -> }

    fun data(init: SubcommandData.() -> Unit) {
        data.init()
    }

    fun code(init: CommandContext.() -> Unit) {
        execute = init
    }
}