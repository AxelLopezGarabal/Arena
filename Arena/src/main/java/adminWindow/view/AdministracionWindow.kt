package com.unqui_arena.administracion.view

import com.unqui_arena.Widgets
import com.unqui_arena.administracion.view_model.AdministracionModel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.RadioSelector
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import wallet.*

class AdministracionWindow : Window<AdministracionModel> {
    constructor(owner: WindowOwner, model: AdministracionModel) : super(owner, model)

    override fun createContents(mainPanel: Panel) {
        setUpWindow()
        createTitle(mainPanel)
        createSearchPanel(mainPanel)
        createUsersTable(mainPanel)
        createButtonsPanel(mainPanel)
    }

    private fun setUpWindow() {
        setTitle("Digital Wallet - Administracion")
        setMinWidth(500)
    }

    private fun createSearchPanel(owner: Panel) {
        Panel(owner) with {
            asHorizontal()
            Widgets.label(it, "Buscar:")
            Widgets.textBox(it, "textoCampoDeBusqueda").setWidth(500)
        }

        Panel(owner) with {
            asHorizontal()
            Widgets.label(it, "Ordenar por:")
            RadioSelector<String>(owner) with {
                bindItemsTo("criteriosDeOrden").adaptWith(Pair::class.java, "first")
                bindSelectedTo("criterioDeOrdenSeleccionado")
            }
        }
    }

    private fun createTitle(owner: Panel) {
        Widgets.titleLabel(owner, "Cuentas")
    }

    private fun createUsersTable(owner: Panel) {
        List<User>(owner) with {
            bindItemsTo("wantedUsers").adaptWith(User::class.java, "fullName")
            bindSelectedTo("selectedUser")
        }

        //Table<User>(owner, User::class.java)
    }

    private fun createButtonsPanel(owner: Panel) {
        Panel(owner) with {
            asHorizontal()
            Widgets.largeButton(it, "Ver")       { verDatosDeUsuarioSeleccionado() }
            Widgets.largeButton(it, "Agregar")   { modificar() }
            Widgets.largeButton(it, "Modificar") { agregar() }
            Widgets.largeButton(it, "Eliminar")  { eliminar() }
        }
    }

    private fun verDatosDeUsuarioSeleccionado() {

    }
    private fun agregar()   { }
    private fun modificar() { }
    private fun eliminar()  { }

}