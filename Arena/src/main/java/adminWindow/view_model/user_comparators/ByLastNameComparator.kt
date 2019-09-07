package adminWindow.view_model.user_comparators

import wallet.User

class ByLastNameComparator : Comparator<User> {
    override fun compare(x: User, y: User) =
        x.lastName.compareTo(y.lastName)

    override fun toString() = "Apellido"
}