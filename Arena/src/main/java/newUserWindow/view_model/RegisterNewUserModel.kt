package newUserWindow.view_model

import org.uqbar.commons.model.annotations.Observable
import wallet.User

@Observable
class RegisterNewUserModel {

    var idCard        = ""
    var firstName     = ""
    var lastName      = ""
    var email         = ""
    var password      = ""
    var passwordAgain = ""
    var esAdmin       = false

    val user get() = User(idCard, firstName, lastName, email, password, esAdmin)

}
