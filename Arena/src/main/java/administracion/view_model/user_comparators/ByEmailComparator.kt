package administracion.view_model.user_comparators

import wallet.User

class ByEmailComparator : Comparator<User> {
    override fun compare(x: User, y: User) =
        x.email.compareTo(y.email)

    override fun toString() = "E-mail"
}