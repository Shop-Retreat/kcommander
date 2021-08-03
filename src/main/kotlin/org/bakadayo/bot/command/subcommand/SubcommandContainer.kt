package org.bakadayo.bot.command.subcommand

class SubcommandContainer: LinkedHashSet<Subcommand>() {
    fun subcommand(init: Subcommand.() -> Unit) {
        val subcommand = Subcommand()
        subcommand.init()
        add(subcommand)
    }
}