package asdasdasdasd

import org.uqbar.commons.model.Entity
import org.uqbar.commons.model.annotations.Observable
import wallet.User

@Observable
class UserModel(val user: User) : Entity() {
    val model = user

    var firstName = user.firstName
    var lastName  = user.lastName
    var email     = user.email
    var esAdmin   = if (user.isAdmin) "si" else "no"

    var isAdmin   = user.isAdmin

    var balance   = user.account?.balance

    var fullName = user.fullName()

    override fun toString() = fullName
}