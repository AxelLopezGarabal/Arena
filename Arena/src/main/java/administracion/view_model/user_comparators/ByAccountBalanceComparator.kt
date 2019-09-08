package administracion.view_model.user_comparators

import wallet.User

class ByAccountBalanceComparator : Comparator<User> {
    override fun compare(x: User, y: User) =
        x.account!!.balance.compareTo(y.account!!.balance)

    override fun toString() = "Balance de cuenta"
}