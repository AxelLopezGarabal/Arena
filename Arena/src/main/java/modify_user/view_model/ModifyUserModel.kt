package modify_user.view_model

import administracion.view_model.UserModel
import org.uqbar.commons.model.annotations.Observable
import wallet.DigitalWallet
import wallet.User

@Observable
class ModifyUserModel(val selectedUser: User, val wallet: DigitalWallet) {
    val account = selectedUser.account

    val fullName = selectedUser.fullName()

    val firstName = selectedUser.firstName
    val lastName  = selectedUser.lastName
    var email     = selectedUser.email
    var esAdmin   = selectedUser.isAdmin

    //var estado    =
    val cvu     = account?.cvu
    val balance = account?.balance

}