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
		catch(eV:UserException){
			throw UserException(eV.message)
		}
		catch(eM:LoginException){
			throw UserException(eM.message)
		}
	}
	
	fun validEmailField(){
		if(wallet.getAllAdmins().any { User -> User.email != email}){
			throw UserException("el email $email o la password es/son invalidas")
		}
	}
	
	fun validPasswordField(){
		if(wallet.getAllAdmins().filter { User -> User.email == email }.first().password != password){
			throw UserException("el email $email o la password es/son invalidas")
		}
	}
}