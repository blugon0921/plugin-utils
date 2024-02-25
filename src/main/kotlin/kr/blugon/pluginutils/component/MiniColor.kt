package kr.blugon.pluginutils.component

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

enum class MiniColor {
    BLACK,
    DARK_BLUE,
    DARK_GREEN,
    DARK_AQUA,
    DARK_RED,
    DARK_PURPLE,
    GOLD,
    GRAY,
    DARK_GRAY,
    BLUE,
    GREEN,
    AQUA,
    RED,
    LIGHT_PURPLE,
    YELLOW,
    WHITE,

    BOLD,
    MAGIC,
    OBFUSCATED,
    STRIKETHROUGH,
    UNDERLINE,
    ITALIC,
    RESET;

    companion object {
        val String.miniMessage: Component
            get() = MiniMessage.miniMessage().deserialize(this)


        fun of(color: String): String = "<color:$color>"
        fun ofClose(color: String): String = "</color:$color>"
    }


    override fun toString(): String {
        return when(this) {
            MAGIC ->  "<obfuscated>"
            UNDERLINE -> "<underlined>"
            else -> "<${this.name.lowercase()}>"
        }
    }

    val close: String
        get() {
            return when(this) {
                MAGIC ->  "</obfuscated>"
                UNDERLINE -> "</underlined>"
                else -> "</${this.name.lowercase()}>"
            }
        }
}