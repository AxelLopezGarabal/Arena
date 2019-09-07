package com.unqui_arena.administracion.view

import adminWindow.view_model.UserModel
import com.unqui_arena.Widgets
import com.unqui_arena.administracion.view_model.AdministracionModel
import newUserWindow.view.NewUserWindow
import newUserWindow.view_model.NewUserModel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.RadioSelector
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import removeUserWindow.view.RemoveUserWindow

class AdministracionWindow : SimpleWindow<AdministracionModel> {
    override fun addActions(p0: Panel?) {}

    override fun createFormPanel(p0: Panel?) {}

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

    private fun createTitle(owner: Panel) =
        Widgets.titleLabel(owner, "Cuentas")

    private fun createSearchPanel(owner: Panel) =
        Panel(owner) with {
            createSearchInput(owner)
            createFilterResults(owner)
        }

    private fun createSearchInput(owner: Panel) =
        Panel(owner) with {
            asHorizontal()
            Widgets.label(it, "Buscar:")
            Widgets.textBox(it, "textoCampoDeBusqueda").setWidth(500)
        }

    private fun createFilterResults(owner: Panel) =
        Panel(owner) with {
            asHorizontal()
            Widgets.label(it, "Ordenar por:")
            RadioSelector<String>(owner) with {
                bindItemsTo("userComparator")
                bindSelectedTo("selectedUserComparator")
            }
        }

    private fun createUsersTable(owner: Panel) =
        Table<UserModel>(owner, UserModel::class.java). with {
            bindItemsTo("showedUsers")
            bindTo("selectedUser")
            height = 500
            Widgets.column(it, "Nombre", "firstName")
            Widgets.column(it, "Apellido", "lastName")
            Widgets.column(it, "E-mail", "email")
            Widgets.column(it, "Es administrador", "esAdmin")
        }

    private fun createButtonsPanel(owner: Panel) =
        Panel(owner) with {
            asHorizontal()
            Widgets.largeButton(it, "Ver")       { viewSelectedUser() }
            Widgets.largeButton(it, "Modificar") { modifySelectedUser() }
            Widgets.largeButton(it, "Agregar")   { addNewUser() }
            Widgets.largeButton(it, "Eliminar")  { deleteSelectedUser() }
        }

    private fun viewSelectedUser() {}
    private fun modifySelectedUser() { }
    private fun addNewUser() {
        val dialog = NewUserWindow(this, NewUserModel())
        dialog.open()
    }

    private fun deleteSelectedUser() {
        val dialog = RemoveUserWindow(this, modelObject.selectedUser)
        dialog.onAccept { modelObject.deleteSelectedUser() }
        dialog.open()
    }

}