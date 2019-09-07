package administracion.view_model.filtros_de_usuarios

import wallet.User

object FiltroBusquedaDeUsuario {

    fun filtrarEnBaseA(searchText: String, users: List<User>) =
        users.filter { stringify(it).matches(regexFor(searchText)) }

    private fun stringify(user: User) =
        "${user.firstName} ${user.lastName} ${user.email}"

    private fun regexFor(searchText: String) =
        Regex(".*$searchText.*", RegexOption.IGNORE_CASE)

}