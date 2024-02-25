package kr.blugon.pluginutils.inventory

import org.bukkit.Material
import org.bukkit.inventory.Inventory


/*
When amount is insufficient, if ignoreLack is true, all items matching the type among the items in the inventory are removed and false is returned.

만약 아이템 수가 부족할때 ignoreLack이 true면 인벤토리에 있는 아이템 중 해당 유형과 일치하는 아이템을 모두 제거하고 false를 반환합니다.
*/
fun Inventory.removeItem(material: Material, amount: Int, ignoreLack: Boolean = false): Boolean {
    if(!this.contains(material, amount)) {
        if(!ignoreLack) return false
        else {
            this.remove(material)
            return false
        }
    }
    var count = amount
    for(i in 0 until this.size) {
        val item = this.getItem(i)
        if(item?.type != material) continue
        if(count <= item.amount) {
            item.amount-=count
            break
        }
        else {
            count-=item.amount
            item.amount = 0
        }
    }
    return true
}