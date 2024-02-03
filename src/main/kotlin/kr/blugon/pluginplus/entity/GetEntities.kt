package kr.blugon.pluginplus.entity

import org.bukkit.Bukkit
import org.bukkit.World.Environment
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

fun entities(): List<Entity> {
    val entities = ArrayList<Entity>()
    Bukkit.getWorlds().forEach { world ->
        world.entities.forEach { entity ->
            entities.add(entity)
        }
    }
    return entities
}

fun entities(vararg entityType: EntityType): List<Entity> {
    val entities = ArrayList<Entity>()
    entities().forEach { entity ->
        if(entityType.contains(entity.type)) entities.add(entity)
    }
    return entities
}

fun entities(scoreboardTags: List<String>, tagsType: TagsType = TagsType.HAVE_ALL): List<Entity> {
    val entities = ArrayList<Entity>()
    Entities@for(entity in entities()) {
        for(tag in scoreboardTags) {
            when(tagsType) {
                TagsType.HAVE_ALL -> if(!entity.scoreboardTags.contains(tag)) continue@Entities
                TagsType.HAVE_ONE -> {
                    if(entity.scoreboardTags.contains(tag)) {
                        entities.add(entity)
                        continue@Entities
                    }
                }
            }
        }
        entities.add(entity)
    }
    return entities
}
fun entities(vararg scoreboardTag: String): List<Entity> = entities(scoreboardTag.toList())
enum class TagsType {
    HAVE_ALL,
    HAVE_ONE
}


fun entities(vararg worldTypes: Environment): List<Entity> {
    val entities = ArrayList<Entity>()
    Bukkit.getWorlds().forEach { world ->
        if(worldTypes.contains(world.environment)) {
            world.entities.forEach { entity ->
                entities.add(entity)
            }
        }
    }
    return entities
}