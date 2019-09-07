package modify_user.view_model

import org.uqbar.commons.model.annotations.Observable
import wallet.DigitalWallet
import wallet.User

@Observable
class ModifyUserModel(val user: User, val wallet: DigitalWallet) {
    val account = user.account

    val fullName = user.fullName()

    val firstName = user.firstName
    val lastName  = user.lastName
    var email     = user.email
    var esAdmin   = user.isAdmin

    //var estado    =
    val cvu     = account?.cvu
    val balance = account?.balance

    fun modifyUser() {
        wallet.users.remove(user)
        wallet.users.add(user.copy(email = email))
    }
}