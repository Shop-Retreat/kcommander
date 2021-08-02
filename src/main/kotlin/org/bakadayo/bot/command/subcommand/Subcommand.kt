package org.bakadayo.bot.command.subcommand

import org.bakadayo.bot.command.CommandContext

class Subcommand(
    val name: String,
    val description: String = "",
    val aliases: Set<String> = emptySet(),
    val args: List<String> = emptyList(),
    val executeMainCommand: Boolean = true,
    val execute: CommandContext.() -> Unit
) {

}