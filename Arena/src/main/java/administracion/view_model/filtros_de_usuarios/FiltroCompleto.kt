package administracion.view_model.filtros_de_usuarios

import wallet.User

class FiltroCompleto(searchText: String) {
    val regex = Regex(".*$searchText.*", RegexOption.IGNORE_CASE)

    fun test(aUser: User) =
        stringify(aUser).matches(regex)

    private fun stringify(user: User) =
        "${user.firstName} ${user.lastName} ${user.email}"


}