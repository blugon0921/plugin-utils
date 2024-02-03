package kr.blugon.pluginplus.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

/*
override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
    val data = CommandData(sender, command, label, args)
    val commands = arrayListOf(TestCommand(data))
    for(child in commands) {
        if(command.name != child.commandName) continue
        return child.onCommand()
    }
    return false
}

override fun onTabComplete(sender: CommandSender, command: Command, label: String, args: Array<out String>): MutableList<String> {
    val data = CommandData(sender, command, label, args)
    val commands = arrayListOf(TestCommand(data))
    for(child in commands) {
        if(command.name != child.commandName) continue
        val original = child.args
        val result = ArrayList<String>()
        for(r in original) if(r.lowercase().startsWith(args[args.size-1].lowercase())) result.add(r)
        return result
    }
    return mutableListOf()
}
*/


interface ChildCommand {
    val commandName: String
    val args: ArrayList<String>

    fun onCommand(): Boolean
}
class CommandData(val sender: CommandSender, val command: Command, val label: String, val args: Array<out String>)