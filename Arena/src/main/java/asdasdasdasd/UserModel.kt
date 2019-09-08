package asdasdasdasd

import org.uqbar.commons.model.Entity
import org.uqbar.commons.model.annotations.Observable
import wallet.Account
import wallet.User

@Observable
class UserModel(val user: User) : Entity() {
    val model = user

    var firstName = user.firstName
    var lastName  = user.lastName
    var email     = user.email
    var esAdmin   = if (user.isAdmin) "si" else "no"

    var isAdmin   = user.isAdmin

    var fullName = user.fullName()

    var balance   = user.account?.balance

    val account = user.account


    override fun toString() = fullName
}