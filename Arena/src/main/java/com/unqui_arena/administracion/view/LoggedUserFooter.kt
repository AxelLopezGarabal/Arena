package com.unqui_arena.administracion.view

import com.unqui_arena.Widgets
import org.uqbar.arena.kotlin.extensions.asHorizontal
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Panel
import wallet.User

class LoggedUserFooter : Panel {

    constructor(
            container: Panel,
            loggedUser: User,
            logOutBlock: () -> Unit) : super(container)
    {
        this with {
            asHorizontal()
            createLoggedUserInfo(it, loggedUser)
            createLogoutButton(it, logOutBlock)
        }
    }

    private fun createLoggedUserInfo(owner: Panel, loggedUser: User) {
        Widgets.infoLabel(owner, "Loggeado como: ${loggedUser.fullName()}")
    }

    private fun createLogoutButton(owner: Panel, logOutBlock: () -> Unit) =
        Widgets.buttonDefaultColor(owner, "Cerrar sesion") { logOutBlock() }

}
