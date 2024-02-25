package kr.blugon.pluginutils.inventory

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.*
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

class UInventory(val plugin: JavaPlugin, val size: Int, title: Component) {
    var inventory = Bukkit.createInventory(null, size, title)
    val slots = MutableList<USlot?>(size) { null }
    var isSetOpen = false
    var isSetClose = false
//    var isSetDrag = false

    companion object {
        fun Player.openUI(plugin: JavaPlugin, size: Int, title: Component, events: UInventory.() -> Unit) {
            val uInventory = UInventory(plugin, size, title)
            events(uInventory)
            this.openUI(uInventory)
        }

        fun Player.openUI(uInventory: UInventory) {
            this.openInventory(uInventory.inventory)
        }
    }

    fun onOpen(openEvent: (InventoryOpenEvent) -> Unit) {
        if(isSetOpen) throw Exception("Already set open event")
        val uOpen = UOpen(this, openEvent)
        Bukkit.getPluginManager().registerEvents(uOpen, plugin)
        isSetOpen = true
    }

    fun onClose(closeEvent: (InventoryCloseEvent) -> Unit) {
        if(isSetClose) throw Exception("Already set close event")
        val uClose = UClose(this, closeEvent)
        Bukkit.getPluginManager().registerEvents(uClose, plugin)
        isSetClose = true
    }

//    fun onDrag(dragEvent: (InventoryDragEvent) -> Unit) {
//        if(isSetDrag) throw Exception("Already set drag event")
//        val uDrag = UDrag(this, dragEvent)
//        Bukkit.getPluginManager().registerEvents(uDrag, plugin)
//        isSetDrag = true
//    }

    fun slot(index: Int, item: ItemStack) {
        slot(index, item) {}
    }

    fun slot(index: Int, item: ItemStack, clickEvent: (InventoryClickEvent) -> Unit) {
        val uSlot = USlot(index, item, inventory, clickEvent)
        Bukkit.getPluginManager().registerEvents(uSlot, plugin)
        slots[index] = uSlot
        inventory.setItem(index, item)
    }


    class UOpen(val uInventory: UInventory, val openEvent: InventoryOpenEvent.() -> Unit): Listener {
        @EventHandler
        fun open(event: InventoryOpenEvent) {
            if(event.inventory != uInventory.inventory) return
            openEvent(event)
        }
    }

    class UClose(val uInventory: UInventory, val closeEvent: InventoryCloseEvent.() -> Unit): Listener {
        @EventHandler
        fun open(event: InventoryCloseEvent) {
            if(event.inventory != uInventory.inventory) return
            closeEvent(event)
        }
    }

//    class UDrag(val uInventory: UInventory, val dragEvent: InventoryDragEvent.() -> Unit): Listener {
//        @EventHandler
//        fun open(event: InventoryDragEvent) {
//            if(event.inventory != uInventory.inventory) return
//            dragEvent(event)
//        }
//    }

    class USlot(val slot: Int, val item: ItemStack, val inventory: Inventory, val clickEvent: InventoryClickEvent.() -> Unit): Listener {
        @EventHandler
        fun click(event: InventoryClickEvent) {
            if(event.inventory != inventory) return
            event.isCancelled = true
            if(event.clickedInventory?.type == InventoryType.PLAYER) return
            if(event.slot != slot) return
            clickEvent(event)
        }
    }
}