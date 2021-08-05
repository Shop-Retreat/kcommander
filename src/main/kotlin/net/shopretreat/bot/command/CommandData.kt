package net.shopretreat.bot.command

import discord4j.rest.util.ApplicationCommandOptionType

class CommandData {
    var name = "newcommand"

    var description = ""

    var aliases = mutableSetOf<String>()

    var args = mutableListOf<Pair<String, ApplicationCommandOptionType>>()

    var admin = false
}