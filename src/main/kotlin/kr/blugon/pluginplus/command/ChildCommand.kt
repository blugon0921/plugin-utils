package kr.blugon.pluginplus.command


interface ChildCommand {
    fun onCommand() {}
    val tabCompleteValues: MutableList<String>
}