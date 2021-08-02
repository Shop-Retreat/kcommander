package org.bakadayo.bot

class Command : Tag("command") {
    var data = CommandData()

    var subcommands = emptySet<Subcommand>()

    var execute = { _: CommandContext -> }

    fun data(init: CommandData.() -> Unit): CommandData {
        data.init()
        return data
    }

    fun code(code: CommandContext.() -> Unit) {
        execute = code
    }
}