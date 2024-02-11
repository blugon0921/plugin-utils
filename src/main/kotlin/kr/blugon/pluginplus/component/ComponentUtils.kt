package kr.blugon.pluginplus.component

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.TranslatableComponent
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import net.kyori.adventure.translation.Translatable
import net.kyori.adventure.util.RGBLike

fun Component.plainText() : String = PlainTextComponentSerializer.plainText().serialize(this)

fun Translatable.translate() : TranslatableComponent = Component.translatable(this.translationKey())

fun Component.bold(apply : Boolean): Component = this.decoration(TextDecoration.BOLD, apply)
fun TextComponent.bold(apply : Boolean): TextComponent = this.decoration(TextDecoration.BOLD, apply)

fun Component.italic(apply : Boolean): Component = this.decoration(TextDecoration.ITALIC, apply)
fun TextComponent.italic(apply : Boolean): Component = this.decoration(TextDecoration.ITALIC, apply)

fun Component.underlined(apply : Boolean): Component = this.decoration(TextDecoration.UNDERLINED, apply)
fun TextComponent.underlined(apply : Boolean): Component = this.decoration(TextDecoration.UNDERLINED, apply)

fun Component.obfuscated(apply : Boolean): Component = this.decoration(TextDecoration.OBFUSCATED, apply)
fun TextComponent.obfuscated(apply : Boolean): Component = this.decoration(TextDecoration.OBFUSCATED, apply)

fun Component.strikethrough(apply : Boolean): Component = this.decoration(TextDecoration.STRIKETHROUGH, apply)
fun TextComponent.strikethrough(apply : Boolean): Component = this.decoration(TextDecoration.STRIKETHROUGH, apply)

fun Component.rgbColor(r: Int, g: Int, b: Int): Component = this.color(TextColor.color(TextColor.color(r, g, b)))
fun Component.rgbColor(rgb: RGBLike): Component = this.color(TextColor.color(TextColor.color(rgb)))