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

    var selectedUser = getUsers().first()

    @Dependencies("textoCampoDeBusqueda", "criterioDeOrdenSeleccionado")
    fun getUsers() =
        wallet.users
            .sortedBy { criterioDeOrdenSeleccionado.second(it) }
            .filter { FiltroCompleto(textoCampoDeBusqueda).test(it) }
            .map { UserModel(it) }

    fun deleteUser() {
        wallet.deleteUser(selectedUser.model)

        // Hay que ver que onda con las @Dependencies para
        // sacar esta chanchada de aca abajo
        val x = criterioDeOrdenSeleccionado
        criterioDeOrdenSeleccionado = criteriosDeOrden.first()
        criterioDeOrdenSeleccionado = criteriosDeOrden.last()
        criterioDeOrdenSeleccionado = x
    }
}