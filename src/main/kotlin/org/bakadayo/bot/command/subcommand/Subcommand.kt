package org.bakadayo.bot.command.subcommand

class Subcommand {
    var data: SubcommandData = SubcommandData()

    var execute = { _: SubcommandContext -> }

    fun data(init: SubcommandData.() -> Unit) {
        data.init()
    }

    fun code(init: SubcommandContext.() -> Unit) {
        execute = init
    }
}