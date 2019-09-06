package com.unqui_arena.administracion.view_model

import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable
import wallet.DigitalWallet

@Observable
class AdministracionModel(var wallet: DigitalWallet) {

    var textoCampoDeBusqueda = ""

    var selectedUser = getUsers().first()

    @Dependencies("wallet")
    fun getUsers() = wallet.users

}
