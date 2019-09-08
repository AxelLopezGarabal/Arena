package remove_user.view_model

import asdasdasdasd.UserModel
import org.uqbar.commons.model.annotations.Observable
import wallet.DigitalWallet

@Observable
class RemoveUserModel(val userToBeRemovedModel: UserModel, val wallet: DigitalWallet) {

    val fullName = userToBeRemovedModel.fullName

    fun removeUser() {
        wallet.deleteUser(userToBeRemovedModel.user)
    }

}
