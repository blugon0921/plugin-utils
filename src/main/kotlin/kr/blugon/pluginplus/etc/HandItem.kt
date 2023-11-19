package kr.blugon.pluginplus.etc

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

val Player.handItem : HandItem
    get() = HandItem(this.inventory.itemInMainHand, this.inventory.itemInOffHand)
class HandItem(val mainHand : ItemStack, val offHand : ItemStack)