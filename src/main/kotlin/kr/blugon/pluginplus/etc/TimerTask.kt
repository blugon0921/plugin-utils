package kr.blugon.pluginplus.etc

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class TimerTask(val plugin: JavaPlugin, val delay : Long, val period: Long, val task: () -> Unit, run : Boolean = true) {

    init {
        if(run) {
            object : BukkitRunnable() {
                override fun run() {
                    task()
                }
            }.runTaskTimer(plugin, delay, period)
        }
    }

    fun run() {
        object : BukkitRunnable() {
            override fun run() {
                task()
            }
        }.runTaskTimer(plugin, delay, period)
    }
}