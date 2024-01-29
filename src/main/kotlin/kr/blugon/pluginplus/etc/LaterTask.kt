package kr.blugon.pluginplus.etc

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class LaterTask(val plugin: JavaPlugin, val delay : Long, val task: () -> Unit, run : Boolean = true) {

    init {
        if (run) {
            object : BukkitRunnable() {
                override fun run() {
                    task()
                }
            }.runTaskLater(plugin, delay)
        }
    }

    fun run() {
        object : BukkitRunnable() {
            override fun run() {
                task()
            }
        }.runTaskLater(plugin, delay)
    }
}