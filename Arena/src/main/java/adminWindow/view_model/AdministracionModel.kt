package com.unqui_arena.administracion.view_model

import adminWindow.view_model.criterios_de_orden_de_usuario.CriteriosDeOrdenDeUsuarios
import adminWindow.view_model.filtros_de_usuarios.FiltroBusquedaDeUsuario
import adminWindow.view_model.filtros_de_usuarios.FiltroCompleto
import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable
import wallet.DigitalWallet
import wallet.User

@Observable
class AdministracionModel(var wallet: DigitalWallet) {

    var textoCampoDeBusqueda = ""

    val criteriosDeOrden = CriteriosDeOrdenDeUsuarios.todos
    var criterioDeOrdenSeleccionado = criteriosDeOrden.first()

    var selectedUser = getUsers().first()

    @Dependencies("wallet")
    fun getUsers() = wallet.users

    @Dependencies("wallet", "textoCampoDeBusqueda", "criterioDeOrdenSeleccionado")
    fun getWantedUsers() =
        ordenados(filtrados(getUsers()))

    private fun ordenados(users: List<User>) =
        users.sortedBy { criterioDeOrdenSeleccionado.second(it) }

    private fun filtrados(users: List<User>) =
        users.filter { FiltroCompleto(textoCampoDeBusqueda).test(it) }

    private fun filtroParaBusqueda() =
        FiltroCompleto(textoCampoDeBusqueda)
}