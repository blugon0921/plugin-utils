package kr.blugon.pluginplus.etc

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

@Deprecated("deprecated")
val Player.handItem : HandItem
    get() = HandItem(this.inventory.itemInMainHand, this.inventory.itemInOffHand)
@Deprecated("deprecated")
class HandItem(val mainHand : ItemStack, val offHand : ItemStack)