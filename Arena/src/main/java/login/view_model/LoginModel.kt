package login.view_model

import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException
import wallet.DigitalWallet
import wallet.LoginException
import wallet.User

@Observable
class LoginModel(val wallet: DigitalWallet) {

    val wellcomeImage = "wellcome.jpg"

    var email    = ""//wallet.getAllAdmins().first().email
    var password = ""//wallet.getAllAdmins().first().password

    var errorMessage: String? = ""

    fun loggedUser() = wallet.login(email, password)

	fun validate(){
		try{
			validEmailField();
			validPasswordField();
		}
		catch(e:UserException){
			throw UserException(e.message)
		}
	}
	
	fun validEmailField(){
		if(validateEmail()){
			throw UserException("el email $email o la password es/son invalidas")
		}
	}
	
	fun validPasswordField(){
		if(validatePassword()){
			throw UserException("el email $email o la password es/son invalidas")
		}
	}
	
	fun validatePassword() = wallet.getAllAdmins().filter { User -> User.email == email }.first().password == password;
	
	fun validateEmail() = wallet.getAllAdmins().any { User -> User.email != email};
}