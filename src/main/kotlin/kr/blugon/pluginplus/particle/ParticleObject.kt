package kr.blugon.pluginplus.particle

import org.bukkit.Location
import org.bukkit.Particle

class ParticleObject(val particle : Particle, val location : Location) {
    var count = 1
    var force = true
    var extra = 0.0
    var offsetX = 0.0
    var offsetY = 0.0
    var offsetZ = 0.0
    var data : Any? = null


    //===================<Create>===================
    constructor(type: Particle, location: Location, count: Int) : this(type, location) {
        this.count = count
    }
    constructor(type: Particle, location: Location, count: Int, data: Any?) : this(type, location) {
        this.count = count
        this.data = data
    }
    constructor(type: Particle, location: Location, count: Int, data: Any?, extra: Double) : this(type, location) {
        this.count = count
        this.data = data
        this.extra = extra
    }
    constructor(type: Particle, location: Location, count: Int, data: Any?, extra: Double, offsetX: Double) : this(type, location) {
        this.count = count
        this.data = data
        this.extra = extra
        this.offsetX = offsetX
    }
    constructor(type: Particle, location: Location, count: Int, data: Any?, extra: Double, offsetX: Double, offsetY: Double) : this(type, location) {
        this.count = count
        this.data = data
        this.extra = extra
        this.offsetX = offsetX
        this.offsetY = offsetY
    }
    constructor(type: Particle, location: Location, count: Int, data: Any?, extra: Double, offsetX: Double, offsetY: Double, offsetZ: Double) : this(type, location) {
        this.count = count
        this.data = data
        this.extra = extra
        this.offsetX = offsetX
        this.offsetY = offsetY
        this.offsetZ = offsetZ
    }
    constructor(type: Particle, location: Location, count: Int, data: Any?, extra: Double, offsetX: Double, offsetY: Double, offsetZ: Double, force: Boolean) : this(type, location) {
        this.count = count
        this.force = force
        this.data = data
        this.extra = extra
        this.offsetX = offsetX
        this.offsetY = offsetY
        this.offsetZ = offsetZ
    }


    //===================<Build>===================
    fun spawn() {
        location.world.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data, force)
    }
}