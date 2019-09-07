package com.unqui_arena.administracion.view

import adminWindow.view_model.UserModel
import com.unqui_arena.Widgets
import com.unqui_arena.administracion.view_model.AdministracionModel
import newUserWindow.view.RegisterNewUserWindow
import newUserWindow.view_model.RegisterNewUserModel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.RadioSelector
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.SimpleWindow
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
        setTitle("Digital Wallet - Administracion de usuarios")
        setMinWidth(500)
    }

    private fun createTitle(owner: Panel) =
        Widgets.titleLabel(owner, "Usuarios registrados")

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
            RadioSelector<String>(it) with {
                bindItemsTo("userComparator")
                bindSelectedTo("selectedUserComparator")
            }
        }

    private fun createUsersTable(owner: Panel) =
        Table<UserModel>(owner, UserModel::class.java). with {
            bindItemsTo("showedUsers")
            bindTo("selectedUser")
            height = 500
            visibleRows = 10
            Widgets.column(it, "Nombre", "firstName")
            Widgets.column(it, "Apellido", "lastName")
            Widgets.column(it, "E-mail", "email")
            Widgets.column(it, "Es administrador", "esAdmin")
        }

    private fun createButtonsPanel(owner: Panel) =
        Panel(owner) with {
            asHorizontal()
            Widgets.largeButton(it, "Dar de alta nuevo usuario") { openRegisterNewUserWindow() }
            Widgets.largeButton(it, "Ver") { }
            Widgets.largeButton(it, "Modificar") { }
            Widgets.largeWarningButton(it, "Eliminar") { openRemoveUserWindow() }
        }

    private fun openRegisterNewUserWindow() {
        val dialog = RegisterNewUserWindow(this, RegisterNewUserModel(modelObject.wallet))
        dialog.onAccept { modelObject.register(dialog.createdUser()) }
        dialog.open()
    }

    private fun openRemoveUserWindow() {
        val dialog = RemoveUserWindow(this, modelObject.selectedUser)
        dialog.onAccept { modelObject.deleteSelectedUser() }
        dialog.open()
    }


}