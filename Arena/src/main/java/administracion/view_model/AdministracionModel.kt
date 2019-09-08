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
    var selectedUserModel = getSeachedResultUserModels().first()

    val loggedUserFullName = loggedUser.fullName() // usar adapter en lugar de esto

    @Dependencies("textoCampoDeBusqueda", "selectedUserComparator", "allUserModels")
    fun getSeachedResultUserModels() =
        BuscadorDeUsuarios(wallet).search(textoCampoDeBusqueda, selectedUserComparator)

    fun reloadAllUsers() {
        allUserModels = getSeachedResultUserModels()//seachAllUserModels()
    }

    fun resetSearchText() {
        textoCampoDeBusqueda = ""
    }
}