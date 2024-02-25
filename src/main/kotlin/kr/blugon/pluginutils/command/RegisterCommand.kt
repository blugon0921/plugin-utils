package kr.blugon.pluginutils.command

import org.bukkit.command.CommandExecutor
import org.bukkit.command.TabCompleter
import org.bukkit.plugin.java.JavaPlugin

fun JavaPlugin.registerCommands(executor: CommandExecutor, tabComplete: TabCompleter, vararg commands: String) {
    commands.forEach { command ->
        getCommand(command)?.apply {
            this.setExecutor(executor)
            this.tabCompleter = tabComplete
        }
    }
}