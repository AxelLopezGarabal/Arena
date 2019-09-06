package adminWindow.view_model.criterios_de_orden_de_usuario

import wallet.User

object CriteriosDeOrdenDeUsuarios {

    val todos = listOf(
        Pair("Nombre", { aUser: User -> aUser.firstName }),
        Pair("Apellido", { aUser: User -> aUser.lastName }),
        Pair("Email", { aUser: User -> aUser.email })
    )

}