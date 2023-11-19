package kr.blugon.pluginplus.etc

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.title.Title
import net.kyori.adventure.title.TitlePart
import org.bukkit.entity.Player
import java.time.Duration

object Title {

    /*
    시간 단위 : tick
    unit of time : tick
    */

    fun Player.sendTitle(title : Component, subtitle : Component, fadeIn : Long, stay : Long, fadeOut : Long) {
        setTitleTime(fadeIn, stay, fadeOut)
        sendTitlePart(TitlePart.SUBTITLE, subtitle)
        sendTitlePart(TitlePart.TITLE, title)
    }

    fun Player.sendTitle(title : Component, fadeIn : Long, stay : Long, fadeOut : Long) {
        setTitleTime(fadeIn, stay, fadeOut)
        sendTitlePart(TitlePart.SUBTITLE, text(" "))
        sendTitlePart(TitlePart.TITLE, title)
    }

    fun Player.sendTitle(title : Component, subtitle : Component) {
        sendTitlePart(TitlePart.SUBTITLE, subtitle)
        sendTitlePart(TitlePart.TITLE, title)
    }

    fun Player.sendTitle(title : Component) {
        sendTitlePart(TitlePart.TITLE, title)
    }

    fun Player.setTitleTime(fadeIn : Long, stay : Long, fadeOut : Long) {
        sendTitlePart(
            TitlePart.TIMES, Title.Times.times(
                Duration.ofMillis((fadeIn/20.0*1000).toLong()),
                Duration.ofMillis((stay/20.0*1000).toLong()),
                Duration.ofMillis((fadeOut/20.0*1000).toLong())
            )
        )
    }
}