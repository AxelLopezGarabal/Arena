package com.unqui_arena.administracion.view_model

import adminWindow.view_model.UserModel
import adminWindow.view_model.criterios_de_orden_de_usuario.CriteriosDeOrdenDeUsuarios
import adminWindow.view_model.filtros_de_usuarios.FiltroCompleto
import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable
import wallet.DigitalWallet

@Observable
class AdministracionModel(var wallet: DigitalWallet) {

    var textoCampoDeBusqueda = ""

    val criteriosDeOrden = CriteriosDeOrdenDeUsuarios.todos
    var criterioDeOrdenSeleccionado = criteriosDeOrden.first()

    var selectedUser = getShowedUsers().first()

    @Dependencies("textoCampoDeBusqueda", "criterioDeOrdenSeleccionado", "allUsers")
    fun getShowedUsers() =
        wallet.users
            .sortedBy { criterioDeOrdenSeleccionado.second(it) }
            .filter { FiltroCompleto(textoCampoDeBusqueda).test(it) }
            .map { UserModel(it) }

    var allUsers = initAllUsers()

    private fun initAllUsers() =
        wallet.users
            .sortedBy { criterioDeOrdenSeleccionado.second(it) }
            .filter { FiltroCompleto(textoCampoDeBusqueda).test(it) }
            .map { UserModel(it) }

    fun deleteSelectedUser() {
        wallet.deleteUser(selectedUser.model)
        allUsers = initAllUsers()
    }
}