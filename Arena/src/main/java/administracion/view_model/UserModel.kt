package administracion.view_model

import org.uqbar.commons.model.annotations.Observable
import wallet.User

@Observable
class UserModel(val user: User) {
    val model = user

    var firstName = user.firstName
    var lastName  = user.lastName
    var email     = user.email
    var esAdmin   = if (user.isAdmin) "si" else "no"

    var fullName = user.fullName()

    override fun toString() = fullName
}