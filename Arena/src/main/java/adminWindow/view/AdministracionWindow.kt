package com.unqui_arena.administracion.view

import adminWindow.view_model.UserModel
import com.unqui_arena.Widgets
import com.unqui_arena.administracion.view_model.AdministracionModel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.RadioSelector
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import removeUserWindow.view.RemoveUserWindow
import removeUserWindow.view_model.RemoveUserModel
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
        Table<UserModel>(owner, UserModel::class.java). with {
            bindItemsTo("users")
            bindTo("selectedUser")
            height = 500
            Widgets.column(it, "Nombre", "firstName")
            Widgets.column(it, "Apellido", "lastName")
            Widgets.column(it, "E-mail", "email")
            Widgets.column(it, "Es administrador", "esAdmin")
        }
    }

    private fun createButtonsPanel(owner: Panel) {
        Panel(owner) with {
            asHorizontal()
            Widgets.largeButton(it, "Ver")       { viewUser() }
            Widgets.largeButton(it, "Modificar") { modifyUser() }
            Widgets.largeButton(it, "Agregar")   { addNewUser() }
            Widgets.largeButton(it, "Eliminar")  { deleteUser() }
        }
    }

    private fun viewUser() {}
    private fun modifyUser() { }
    private fun addNewUser() { }

    private fun deleteUser() {
        val dialog = RemoveUserWindow(this, modelObject.selectedUser)
        dialog.onAccept { modelObject.deleteUser() }
        dialog.open()
    }

}