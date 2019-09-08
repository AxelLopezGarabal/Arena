package asdasdasdasd

import administracion.view_model.filtros_de_usuarios.FiltroCompleto
import wallet.DigitalWallet
import wallet.User

class BuscadorDeUsuarios(val wallet: DigitalWallet) {

    fun search(searchText: String, aComparator: Comparator<User>) =
        wallet.users
            .sortedWith(aComparator)
            .filter { FiltroCompleto(searchText).test(it) }
            .map { UserModel(it) }

}