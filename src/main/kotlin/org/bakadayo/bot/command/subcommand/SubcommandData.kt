package org.bakadayo.bot.command.subcommand

import discord4j.rest.util.ApplicationCommandOptionType

class SubcommandData {
    var name = "newsubcommand"

    var description = ""

    var aliases = emptySet<String>()

    var args = mutableListOf<Pair<String, ApplicationCommandOptionType>>()

    var executeMainCommand = true
}