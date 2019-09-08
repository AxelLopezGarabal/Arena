package remove_user.view_model

import asdasdasdasd.UserModel
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException
import wallet.DigitalWallet
import wallet.User

@Observable
class RemoveUserModel(val userToBeRemoved: User, val loggedUser: User, val wallet: DigitalWallet) {

    val fullName = userToBeRemoved.fullName()

    fun removeUser() {
        validateAction()
        wallet.deleteUser(userToBeRemoved)
    }

    private fun validateAction() {
        checkSuicide()
        checkEmptyAccount()
    }

    private fun checkSuicide() {
        if (userToBeRemoved === loggedUser)
            throw UserException("No podes eliminarte a vos mismo")
    }

    private fun checkEmptyAccount() {
        if (userToBeRemoved.account?.balance != 0.0)
            throw UserException("Solo se puede eliminar una cuenta con su balance en $0.0")
    }

}
