package com.unqui_arena.administracion.view_model

import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable
import wallet.Account

@Observable
class AdministracionModel(var accounts: MutableList<Account>) {

    var textoParaFiltroDeBusqueda = ""

    @Dependencies("accounts")
    fun getUsers() = accounts.map(Account::user)

}
