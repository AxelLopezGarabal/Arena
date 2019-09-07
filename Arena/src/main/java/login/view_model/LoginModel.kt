package login.view_model

import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException
import wallet.DigitalWallet
import wallet.LoginException
import wallet.User

@Observable
class LoginModel(val wallet: DigitalWallet) {

    var email    = ""
    var password = ""

    var errorMessage: String? = ""

    fun loggedUser() =wallet.login(email, password)

}