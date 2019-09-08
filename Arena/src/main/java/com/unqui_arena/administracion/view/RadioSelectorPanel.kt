package com.unqui_arena.administracion.view

import com.unqui_arena.Widgets
import org.uqbar.arena.kotlin.extensions.asHorizontal
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Container
import org.uqbar.arena.widgets.Panel

class RadioSelectorPanel : Panel {
    constructor(
        container: Container,
        labelText: String,
        bindItemsToTexto: String,
        bindSelectedTo: String) : super(container)
    {
        this with {
            asHorizontal()
            Widgets.label(it, labelText)
            Widgets.radioSelector(it, bindItemsToTexto, bindSelectedTo)
        }
    }
}
