package account_info.model

import org.uqbar.commons.model.annotations.Observable
import wallet.Account
import wallet.User

@Observable
class AccountInfoModel(val user: User) {
    val account = user.account

    val userFullName = user.fullName()
    val cvu          = account!!.cvu
    val balance      = account!!.balance

}
