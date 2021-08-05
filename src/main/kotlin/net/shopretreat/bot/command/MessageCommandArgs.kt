package net.shopretreat.bot.command

class MessageCommandArgs(private val args: Map<String, String>) : CommandArgs {
    override fun get(name: String): String? = args[name]
}