package main_window.model

import org.uqbar.commons.model.annotations.Observable
import wallet.DigitalWallet
import wallet.User

@Observable
class MainDigitalWalletModel(val loggedUser: User, val wallet: DigitalWallet) {

    

}
