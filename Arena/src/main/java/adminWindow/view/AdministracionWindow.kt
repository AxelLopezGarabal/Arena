package com.unqui_arena.administracion.view

import com.unqui_arena.Widgets
import com.unqui_arena.administracion.view_model.AdministracionModel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner

class AdministracionWindow : Window<AdministracionModel> {
    constructor(owner: WindowOwner, model: AdministracionModel) : super(owner, model)

    override fun createContents(mainPanel: Panel) {
        setUpWindow()
        createTitle(mainPanel)
        createSearchInput(mainPanel)
        createUsersTable(mainPanel)
        createButtonsPanel(mainPanel)
    }

    private fun createSearchInput(owner: Panel) {
        Widgets.searchBox(owner, "textoParaFiltroDeBusqueda", 500) {  }
    }

    private fun setUpWindow() {
        setTitle("Digital Wallet - Administracion")
        setMinWidth(500)
    }

    private fun createTitle(owner: Panel) {
        Widgets.titleLabel(owner, "Cuentas")
    }

    private fun createUsersTable(owner: Panel) {
        /*Widgets.table(owner, Usuario::class.java, "usuarios") with {
            Widgets.column(it, "Nombre", "name")
            Widgets.column(it, "Apellido", "apellido")
            Widgets.column(it, "E-mail", "email")
        }*/
    }

    private fun createButtonsPanel(owner: Panel) {
        Panel(owner) with {
            asHorizontal()
            Widgets.largeButton(it, "Ver")       { ver()       }
            Widgets.largeButton(it, "Agregar")   { modificar() }
            Widgets.largeButton(it, "Modificar") { agregar()   }
            Widgets.largeButton(it, "Eliminar")  { eliminar()  }
        }
    }

    private fun ver()       { }
    private fun agregar()   { }
    private fun modificar() { }
    private fun eliminar()  { }

}