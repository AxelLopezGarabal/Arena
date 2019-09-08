package com.unqui_arena

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import java.awt.Color

object Widgets {
    val defaultTextInputWidth  = 200

    val mediumFontSize         = 14
    val inputFieldPreferedSize = 150
    val largeInputFieldSize    = 200

    val defaultForegroundColor = Color(0x2A7A69)
    val defaultBackgroundColor = Color(0x38AB99)

    val warningForegroundColor = Color(0xB50705)
    val warningBackgroundColor = Color(0x690805)

    val infoForegroundColor    = Color(0x26A833)
    val infoBackgroundColor    = Color(0x17641F)

    fun titleLabel(owner: Panel, text: String) =
        label(owner, text) with {
            fontSize   = 32
            foreground = defaultForegroundColor
            background = defaultBackgroundColor
        }

    fun warningTitleLabel(owner: Panel, text: String) =
        titleLabel(owner, text) with {
            foreground = warningForegroundColor
            background = warningBackgroundColor
        }

    fun button(owner: Panel, caption: String, onClickBlock: () -> Unit = {}) =
        Button(owner)
            .setCaption(caption)
            .onClick(onClickBlock)

    fun largeButton(owner: Panel, caption: String, onClickBlock: () -> Unit) =
        button(owner, caption, onClickBlock) with { fontSize = 18; alignCenter() }

    fun largeButtonDefaultColor(owner: Panel, caption: String, onClickBlock: () -> Unit) =
        button(owner, caption, onClickBlock) with {
            fontSize = 18
            foreground = defaultForegroundColor
            background = defaultBackgroundColor
            alignCenter()
        }

    fun label(owner: Panel, text: String) =
        Label(owner).setText(text)

    fun bindedLabel(owner: Panel, propertyName: String) =
        Label(owner) with { bindTo(propertyName) }

    fun infoLabel(owner: Panel, text: String) =
        label(owner, text) with { foreground = infoForegroundColor }

    fun infoBindedLabel(owner: Panel, propertyName: String) =
        Label(owner) with { bindTo(propertyName); foreground = infoForegroundColor }

    fun textBox(owner: Panel, propertyName: String) =
        TextBox(owner) with { bindTo(propertyName); width = defaultTextInputWidth }

    fun numericField(owner: Panel, propertyName: String) =
        NumericField(owner) with { bindTo(propertyName) }

    fun passwordField(owner: Panel, propertyName: String) =
        PasswordField(owner) with { bindTo(propertyName); width = defaultTextInputWidth }

    fun table(owner: Panel, itemType: Class<*>, propertyName: String) =
        Table<Any>(owner, itemType as Class<Any>) with {
            bindItemsTo(propertyName)
        }

    fun column(table: Table<*>, title: String, propertyName: String) =
        Column(table) with {
            setTitle(title)
            bindContentsToProperty(propertyName)
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

    fun errorLabel(owner: Panel, texto: String, modelProperty: String) =
        label(owner, texto) with {
            bindVisibleTo(modelProperty)
            foreground = warningForegroundColor
        }

    fun mediumTextBox(owner: Panel, bindedProperty: String) =
        textBox(owner, bindedProperty) with {
            fontSize = mediumFontSize
            width    = inputFieldPreferedSize
        }

    fun largeTextBox(owner: Panel, bindedProperty: String) =
        textBox(owner, bindedProperty) with {
            fontSize = mediumFontSize
            width    = largeInputFieldSize
        }

    fun mediumPasswordField(owner: Panel, bindedProperty: String) =
        passwordField(owner, bindedProperty) with {
            fontSize = mediumFontSize
            width    = inputFieldPreferedSize
        }

    fun checkBoxField(owner: Panel, labelText: String, bindedProperty: String) =
        Panel(owner) with {
            asHorizontal()
            label(it, labelText)
            CheckBox(it) with { bindTo(bindedProperty) }
        }

    fun largeWarningButton(owner: Panel, caption: String, onClickBlock: () -> Unit) =
        largeButton(owner, caption, onClickBlock) with {
            //foreground = warningForegroundColor
            //background = warningBackgroundColor
            foreground = warningBackgroundColor
            background = warningForegroundColor
        }

    fun buttonDefaultColor(owner: Panel, caption: String, onClickBlock: () -> Unit) =
        button(owner, caption, onClickBlock) with {
            foreground = defaultForegroundColor
            background = defaultBackgroundColor
            setAsDefault()
        }

    fun icon(owner: Panel, pathToImage: String) =
        Label(owner) with { bindImageTo(pathToImage) }

    fun radioSelector(owner: Panel, bindItemsTo: String, bindSelectedTo: String) =
        RadioSelector<String>(owner) with {
            bindItemsTo(bindItemsTo)
            bindSelectedTo(bindSelectedTo)
        }

}