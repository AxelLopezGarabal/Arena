package adminWindow.view_model.user_comparators

import wallet.User

class ByFirstNameComparator : Comparator<User> {
    override fun compare(x: User, y: User) =
        x.firstName.compareTo(y.firstName)

    override fun toString() = "Nombre"
}