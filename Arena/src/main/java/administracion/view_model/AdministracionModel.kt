package com.unqui_arena.administracion.view_model

import administracion.view_model.user_comparators.ByEmailComparator
import administracion.view_model.user_comparators.ByFirstNameComparator
import administracion.view_model.user_comparators.ByLastNameComparator
import administracion.view_model.user_comparators.UserComparators
import asdasdasdasd.BuscadorDeUsuarios
import asdasdasdasd.UserModel
import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable
import wallet.DigitalWallet
import wallet.User

@Observable
class AdministracionModel(var wallet: DigitalWallet, val loggedUser: User) {

    val searchIconPath         = "search-icon.png"
    var textoCampoDeBusqueda   = ""
    val userComparators        = UserComparators.all
    var selectedUserComparator = userComparators.first()

    var allUserModels     = getSeachedResultUserModels()
    var selectedUserModel = allUserModels.first()

    val loggedUserFullName = loggedUser.fullName() // Deberia usar un adapter pero no funciona

    @Dependencies("textoCampoDeBusqueda", "selectedUserComparator", "allUserModels")
    fun getSeachedResultUserModels() =
        BuscadorDeUsuarios(wallet).search(textoCampoDeBusqueda, selectedUserComparator)

    fun reloadAllUsers() {
        allUserModels = getSeachedResultUserModels()
    }

    fun resetSearchText() {
        textoCampoDeBusqueda = ""
    }

    fun refreshView() {
        resetSearchText()
    }
}