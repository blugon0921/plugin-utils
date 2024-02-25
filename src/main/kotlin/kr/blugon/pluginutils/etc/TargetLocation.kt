package kr.blugon.pluginutils.etc

import org.bukkit.Location
import org.bukkit.entity.Player

fun Player.getTargetLocation(maxDistance: Int, targetType: TargetType = TargetType.ALL): Location? {
    val player = this
    return when(targetType) {
        TargetType.ENTITY -> player.getTargetEntity(120)?.location
        TargetType.BLOCK -> player.getTargetBlockExact(maxDistance)?.location?.toCenterLocation().apply {
            val face = player.getTargetBlockFace(maxDistance)
            if(face != null) this?.add(face.direction.multiply(0.5))
        }
        TargetType.ALL -> (player.getTargetEntity(120)?.location?: player.getTargetBlockExact(120)?.location?.toCenterLocation().apply {
            val face = player.getTargetBlockFace(120)
            if(face != null) {
                this?.add(face.direction.multiply(0.5))
            }
        })?: return null
    }
}
enum class TargetType {
    ENTITY,
    BLOCK,
    ALL
}