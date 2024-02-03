package kr.blugon.pluginplus.etc

import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.World

fun World.playSound(location: Location, soundData: SoundData) = this.playSound(location, soundData.sound, soundData.category, soundData.pitch, soundData.volume)
data class SoundData(val sound: Sound, val pitch: Float = 1f, val volume: Float = 1f, val category: SoundCategory = SoundCategory.MASTER)