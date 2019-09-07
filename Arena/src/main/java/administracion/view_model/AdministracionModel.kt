package com.unqui_arena.administracion.view_model

import administracion.view_model.UserModel
import administracion.view_model.user_comparators.ByEmailComparator
import administracion.view_model.user_comparators.ByFirstNameComparator
import administracion.view_model.user_comparators.ByLastNameComparator
import administracion.view_model.filtros_de_usuarios.FiltroCompleto
import login.view.LogInWindow
import org.uqbar.arena.windows.Window
import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable
import wallet.DigitalWallet
import wallet.User

@Observable
class AdministracionModel(var wallet: DigitalWallet, val loggedUser: User) {
    // usar adapter en lugar de esto
    val loggedUserFullName = loggedUser.fullName()

    var textoCampoDeBusqueda = ""

    val userComparator = listOf(ByFirstNameComparator(), ByLastNameComparator(), ByEmailComparator())
    var selectedUserComparator = userComparator.first()

    var allUsers = initAllUsers()
    var selectedUser = getShowedUsers().first()

    @Dependencies("textoCampoDeBusqueda", "selectedUserComparator", "allUsers")
    fun getShowedUsers() = initAllUsers()

    fun initAllUsers() =
        wallet.users
            .sortedWith(selectedUserComparator)
            .filter { FiltroCompleto(textoCampoDeBusqueda).test(it) }
            .map { UserModel(it) }

    fun deleteSelectedUser() {
        wallet.deleteUser(selectedUser.model)
        allUsers = initAllUsers()
    }

    fun register(newUser: User) {
        wallet.register(newUser)
        allUsers = initAllUsers()
    }

    fun reloadAllUsers() {
        allUsers = initAllUsers()
    }
}