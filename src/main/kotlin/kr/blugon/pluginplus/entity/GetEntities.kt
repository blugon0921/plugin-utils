package kr.blugon.pluginplus.entity

import org.bukkit.Bukkit
import org.bukkit.World.Environment
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType

object GetEntities {
    fun entities(): ArrayList<Entity> {
        val entities = ArrayList<Entity>()
        Bukkit.getWorlds().forEach { world ->
            world.entities.forEach { entity ->
                entities.add(entity)
            }
        }
        return entities
    }

    fun entities(entityType: EntityType): ArrayList<Entity> {
        val entities = ArrayList<Entity>()
        Bukkit.getWorlds().forEach { world ->
            world.entities.forEach { entity ->
                if(entity.type == entityType) entities.add(entity)
            }
        }
        return entities
    }

    fun entities(scoreboardTag: String): ArrayList<Entity> {
        val entities = ArrayList<Entity>()
        Bukkit.getWorlds().forEach { world ->
            world.entities.forEach { entity ->
                if(entity.scoreboardTags.contains(scoreboardTag)) entities.add(entity)
            }
        }
        return entities
    }


    fun entities(worldType: Environment): ArrayList<Entity> {
        val entities = ArrayList<Entity>()
        Bukkit.getWorlds().forEach { world ->
            if(world.environment == worldType) {
                world.entities.forEach { entity ->
                    entities.add(entity)
                }
            }
        }
        return entities
    }

    fun entities(worldTypes: List<Environment>): ArrayList<Entity> {
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
}