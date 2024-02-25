package kr.blugon.pluginutils.firework


//fun JavaPlugin.initFireworkEffect() {
//    class Init: Listener {
//        @EventHandler
//        fun noDamageFirework(event: EntityDamageByEntityEvent) {
//            val damager = event.damager
//            if(damager is Firework && damager.scoreboardTags.contains("firework.only_effect")) event.isCancelled = true
//        }
//    }
//    Bukkit.getPluginManager().registerEvents(Init(), this)
//}
//fun World.playFirework(location: Location, effect: FireworkEffect.Builder.() -> FireworkEffect) = playFirework(location, effect(FireworkEffect.builder()))
//fun World.playFirework(location: Location, effect: FireworkEffect, soundData: SoundData? = SoundData(Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1f, 1f)) {
//    spawn(location, Firework::class.java).apply {
//        val meta = fireworkMeta
//        meta.power = 0
//        meta.addEffect(effect)
//        fireworkMeta = meta
//        this.detonate()
//        this.addScoreboardTag("firework.only_effect")
//    }
//    if(soundData != null) playSound(location, soundData)
//}