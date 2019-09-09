package com.unqui_arena.administracion.view

import account_info.model.AccountInfoModel
import account_info.view.AccountInfoWindow
import administracion.view.SearchPanel
import asdasdasdasd.UserModel
import com.unqui_arena.Widgets
import com.unqui_arena.administracion.view_model.AdministracionModel
import login.view.LogInWindow
import login.view_model.LoginModel
import main_window.model.MainDigitalWalletModel
import main_window.view.MainDigitalWalletWindow
import new_user.view.RegisterNewUserWindow
import new_user.view_model.RegisterNewUserModel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.WindowOwner
import remove_user.view.RemoveUserWindow
import modify_user.view.ModifyUserWindow
import modify_user.view_model.ModifyUserModel
import remove_user.view_model.RemoveUserModel
import asdasdasdasd.DigitalWalletWindow

class AdministracionWindow : DigitalWalletWindow<AdministracionModel> {

    override var titleText = "Administracion de usuarios"

    constructor(owner: WindowOwner, model: AdministracionModel) : super(owner, model)

    override fun createHeader(owner: Panel) { createSearchPanel(owner) }
    override fun createBody(owner: Panel)   { createAdministracionPanel(owner) }
    override fun createFooter(owner: Panel) { createBackToMain(owner) }

    private fun createSearchPanel(owner: Panel) =
        Panel(owner) with {
            SearchPanel(it, "Buscar:", "textoCampoDeBusqueda", 500)
            RadioSelectorPanel(it, "Ordenar por:", "userComparators", "selectedUserComparator")
        }

    private fun createAdministracionPanel(owner: Panel) =
        Panel(owner).asHorizontal() with {
            createUsersTable(it)
            createOperationButtonsPanel(it)
        }

    private fun createBackToMain(owner: Panel) =
        Widgets.buttonDefaultColor(owner, "Volver a la pantalla principal") { openMainWindow() }

    //
    private fun createUsersTable(owner: Panel) =
        Table<UserModel>(owner, UserModel::class.java). with {
            bindItemsTo("seachedResultUserModels")
            bindTo("selectedUserModel")
            visibleRows = 10
            Widgets.column(it, "Nombre", "firstName")
            Widgets.column(it, "Apellido", "lastName")
            Widgets.column(it, "E-mail", "email")
            Widgets.column(it, "Es administrador", "esAdmin")
            Widgets.column(it, "Balance", "balance").alignRight()
        }

    private fun createOperationButtonsPanel(owner: Panel) =
        Panel(owner) with {
            Widgets.largeButton(it, "Dar de alta nuevo usuario") { openRegisterNewUserWindow() }
            Widgets.largeButton(it, "Ver informacion de cuenta") { openViewAccountInfo() }
            Widgets.largeButton(it, "Modificar usuario")         { openModifySelectedUserWindow() }
            Widgets.largeWarningButton(it, "Eliminar usuario")   { openRemoveSelectedUserWindow() }
        }

    private fun openRegisterNewUserWindow() {
        val dialog = RegisterNewUserWindow(this, RegisterNewUserModel(modelObject.wallet))
        dialog.onAccept { modelObject.refreshView() }
        dialog.open()
    }

    private fun openViewAccountInfo() {
        AccountInfoWindow(this, AccountInfoModel(modelObject.selectedUserModel.user)).open()
    }

    private fun openModifySelectedUserWindow() {
        val dialog = ModifyUserWindow(this, ModifyUserModel(modelObject.selectedUserModel.user, modelObject.wallet))
        dialog.onAccept { modelObject.refreshView() }
        dialog.open()
    }

    private fun openRemoveSelectedUserWindow() {
        val model  = RemoveUserModel(modelObject.selectedUserModel.user, modelObject.loggedUser, modelObject.wallet)
        val dialog = RemoveUserWindow(this, model)
        dialog.onAccept { modelObject.refreshView() }
        dialog.open()
    }

    private fun openMainWindow() {
        close()
        val model = MainDigitalWalletModel(modelObject.loggedUser, modelObject.wallet)
        MainDigitalWalletWindow(this, model).open()
    }

}
