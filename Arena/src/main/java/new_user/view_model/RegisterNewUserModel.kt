package new_user.view_model

import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException
import wallet.DigitalWallet
import wallet.User

@Observable
class RegisterNewUserModel(val wallet: DigitalWallet) {
    var errorMessage  = ""

    var idCard        = ""
    var firstName     = ""
    var lastName      = ""
    var email         = ""
    var password      = ""
    var passwordAgain = ""
    var esAdmin       = false

    fun makeUser() = User(idCard, firstName, lastName, email, password, esAdmin)

    fun registerNewUser() {
        validateInput()
        wallet.register(makeUser())
    }

    @Dependencies("email")
    fun getCheckInvalidMail() =
        email != "" && !email.matches("^[a-z_]+[a-z0-1_]*@[a-z_][a-z0-1_]*([.][a-z]+)+$$".toRegex(RegexOption.IGNORE_CASE))

    @Dependencies("password", "passwordAgain")
    fun getCheckDifferentPasswords() = password != passwordAgain

    @Dependencies("email")
    fun getCheckRepeatedMail() = wallet.users.any { it.email == email }

    @Dependencies("idCard", "firstName", "lastName", "email", "password", "passwordAgain")
    fun getCheckEmptyRequieredFields() =
        listOf(idCard, firstName, lastName, email, password, passwordAgain).any { it.isEmpty() }

    private fun validateInput() {
        assertValidEmail()
        assertEmailIsAvalable()
        assertFillAllRequiredFields()
    }

    private fun assertValidEmail() {
        if (getCheckInvalidMail())
            throw UserException("El mail ingresado es invalido")
    }

    private fun assertEmailIsAvalable() {
        if (getCheckRepeatedMail())
            throw UserException("Ya existe una usuario registrado con el mail ingresado")
    }

    private fun assertFillAllRequiredFields() {
        if (getCheckEmptyRequieredFields())
            throw UserException("Quedaron campos sin llenar")
    }

}
