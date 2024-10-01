package kr.blugon.pluginutils.location

import org.bukkit.Location
import kotlin.math.atan
import kotlin.math.pow
import kotlin.math.sqrt

// copied from https://bukkit.org/threads/lookat-and-move-functions.26768/
// by bergerkiller
fun Location.lookAt(target: Location): Location {
    val location = this.clone()

    val dx = target.x - location.x
    val dy = target.y - location.y
    val dz = target.z - location.z

    if (dx != 0.0) {
        if (dx < 0) location.yaw = (1.5 * Math.PI).toFloat()
        else location.yaw = (0.5 * Math.PI).toFloat()
        location.yaw -= atan(dz / dx).toFloat()
    } else if (dz < 0) location.yaw = Math.PI.toFloat()

    val dxz = sqrt(dx.pow(2.0) + dz.pow(2.0))
    location.pitch = (-atan(dy / dxz)).toFloat()

    location.yaw = -location.yaw * 180f / Math.PI.toFloat()
    location.pitch = location.pitch * 180f / Math.PI.toFloat()

    return location
}