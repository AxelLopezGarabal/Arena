package com.unqui_arena

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.lacar.ui.model.ControlBuilder
import java.awt.Color

object Widgets {
    val mediumFontSize = 14
    val inputFieldPreferedSize = 150
    val largeInputFieldSize = 200

    fun titleLabel(owner: Panel, text: String) =
        label(owner, text) with { fontSize = 32 }

    fun button(owner: Panel, caption: String, onClickBlock: () -> Unit = {}) =
        Button(owner)
            .setCaption(caption)
            .onClick(onClickBlock)

    fun largeButton(owner: Panel, caption: String, onClickBlock: () -> Unit) =
        button(owner, caption, onClickBlock) with { fontSize = 18; alignCenter() }

    fun label(owner: Panel, text: String) =
        Label(owner).setText(text)

    fun bindedLabel(owner: Panel, propertyName: String) =
        Label(owner) with { bindTo(propertyName) }

    fun textBox(owner: Panel, propertyName: String) =
        TextBox(owner) with { bindTo(propertyName) }

    fun numericField(owner: Panel, propertyName: String) =
        NumericField(owner) with { bindTo(propertyName) }

    fun passwordField(owner: Panel, propertyName: String) =
        PasswordField(owner) with { bindTo(propertyName) }

    fun table(owner: Panel, itemType: Class<*>, propertyName: String) =
        Table<Any>(owner, itemType as Class<Any>) with {
            bindItemsTo(propertyName)
        }

    fun column(table: Table<*>, title: String, propertyName: String) =
        Column(table) with {
            setTitle(title)
            bindContentsToProperty(propertyName)
        }

    fun searchBox(owner: Panel, propertyName: String, textBoxWidth: Int, onSeachBlock: () -> Unit = {}) {
        Panel(owner).asHorizontal() with {
            button(it, "Buscar", onSeachBlock)
            textBox(it, propertyName).setWidth(textBoxWidth)
        }
    }

    fun labeledTextBox(owner: Panel, labelText: String, propertyName: String): TextBox {
        label(owner, labelText)
        return textBox(owner, propertyName)
    }

    fun labeledPasswordField(owner: Panel, labelText: String, propertyName: String): PasswordField {
        label(owner, labelText)
        return passwordField(owner, propertyName)
    }

    fun mediumLabel(owner: Panel, text: String) =
        label(owner, text) with { fontSize = mediumFontSize }

    fun mediumTextBox(owner: Panel, bindedProperty: String) =
        textBox(owner, bindedProperty) with {
            fontSize = mediumFontSize
            width = inputFieldPreferedSize
        }

    fun largeTextBox(owner: Panel, bindedProperty: String) =
        textBox(owner, bindedProperty) with {
            fontSize = mediumFontSize
            width = largeInputFieldSize
        }

    fun mediumPasswordField(owner: Panel, bindedProperty: String) =
        passwordField(owner, bindedProperty) with {
            fontSize = mediumFontSize
            width = inputFieldPreferedSize
        }

    fun checkBoxField(owner: Panel, labelText: String, bindedProperty: String): CheckBox {
        label(owner, labelText)
        return CheckBox(owner) with { bindTo(bindedProperty) }
    }

}