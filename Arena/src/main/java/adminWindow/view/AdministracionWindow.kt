package com.unqui_arena.administracion.view

import com.unqui_arena.Widgets
import com.unqui_arena.administracion.view_model.AdministracionModel
//import com.unqui_arena.administracion.view_model.Usuario
import org.uqbar.arena.kotlin.extensions.asHorizontal
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import loginwindow.Usuario


class AdministracionWindow : SimpleWindow<AdministracionModel> {
    constructor(owner: WindowOwner, model: AdministracionModel) : super(owner, model)

    override fun createFormPanel(mainPanel: Panel) {
        setUpWindow()
        createTitle(mainPanel)
        createSearchInput(mainPanel)
        createUsersTable(mainPanel)
        createButtonsPanel(mainPanel)
    }

    private fun createSearchInput(owner: Panel) {
        Widgets.searchBox(
            owner,
            "textoParaFiltroDeBusqueda",
            500) {  }
    }

    private fun setUpWindow() {
        setTitle("Digital Wallet - Administracion")
        setMinWidth(500)
    }

    private fun createTitle(owner: Panel) {
        Widgets
            .label(owner, "Listado de usuarios")
            .setFontSize(32)
    }

    private fun createUsersTable(owner: Panel) {
        Widgets.table(owner, Usuario::class.java, "usuarios") with {
            Widgets.column(it, "Nombre", "nombre")
            Widgets.column(it, "Apellido", "apellido")
            Widgets.column(it, "E-mail", "email")
        }
    }

    private fun createButtonsPanel(owner: Panel) {
        Panel(owner) with {
            asHorizontal()
            Widgets.button(it, "Ver")       { ver()       }
            Widgets.button(it, "Agregar")   { modificar() }
            Widgets.button(it, "Modificar") { agregar()   }
            Widgets.button(it, "Eliminar")  { eliminar()  }
        }
    }

    private fun ver()       { }
    private fun agregar()   { }
    private fun modificar() { }
    private fun eliminar()  { }

    override fun addActions(actionsPanel: Panel) {}

}