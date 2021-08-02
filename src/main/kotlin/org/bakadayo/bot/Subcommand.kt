package org.bakadayo.bot

class Subcommand(
    val name: String,
    val description: String = "",
    val aliases: Set<String> = emptySet(),
    val args: List<String> = emptyList(),
    val executeMainCommand: Boolean = true,
    val execute: CommandContext.() -> Unit
)