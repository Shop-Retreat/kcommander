package org.bakadayo.bot.command.subcommand

class SubcommandData {
    var name: String = "newsubcommand"

    var description: String = ""

    var aliases: Set<String> = emptySet()

    var executeMainCommand: Boolean = true
}