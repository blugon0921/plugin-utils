package kr.blugon.pluginutils.entity

import org.bukkit.entity.Display
import org.bukkit.util.Transformation
import org.joml.Quaternionf
import org.joml.Vector3f

var Display.translation: Vector3f
    get() = transformation.translation
    set(value) {
        transformation = Transformation(
            value,
            transformation.leftRotation,
            transformation.scale,
            transformation.rightRotation,
        )
    }
var Display.leftRotation: Quaternionf
    get() = transformation.leftRotation
    set(value) {
        transformation = Transformation(
            transformation.translation,
            value,
            transformation.scale,
            transformation.rightRotation,
        )
    }
var Display.scale: Vector3f
    get() = transformation.scale
    set(value) {
        transformation = Transformation(
            transformation.translation,
            transformation.leftRotation,
            value,
            transformation.rightRotation,
        )
    }
var Display.rightRotation: Quaternionf
    get() = transformation.rightRotation
    set(value) {
        transformation = Transformation(
            transformation.translation,
            transformation.leftRotation,
            transformation.scale,
            value,
        )
    }