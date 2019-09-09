package transfer_money.model

import org.uqbar.commons.model.annotations.Observable
import wallet.DigitalWallet
import wallet.User

@Observable
class TransferMoneyModel(val user: User, val wallet: DigitalWallet) {

    val cvuSourceAccount = user.account!!.cvu
    var cvuTargetAccount = ""
    var amount           = 0.0

    fun transferMoney() {
        wallet.transfer(cvuSourceAccount, cvuTargetAccount, amount)
    }

}
