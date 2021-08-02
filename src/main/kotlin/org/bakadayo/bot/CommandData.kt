package org.bakadayo.bot

class CommandData : Tag("data") {
    var name: String = "newcommand"

    var description: String = ""

    var aliases: Set<String> = emptySet()

    var admin: Boolean = false
}