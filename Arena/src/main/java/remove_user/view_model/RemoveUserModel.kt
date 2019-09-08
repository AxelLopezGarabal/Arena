package remove_user.view_model

import administracion.view_model.UserModel
import org.uqbar.commons.model.annotations.Observable
import wallet.DigitalWallet

@Observable
class RemoveUserModel(val userModel: UserModel, val wallet: DigitalWallet) {
    val fullName = userModel.fullName

    fun removeUser() {
        wallet.deleteUser(userModel.user)
    }

}
