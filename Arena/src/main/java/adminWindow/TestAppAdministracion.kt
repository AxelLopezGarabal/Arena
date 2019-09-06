package adminWindow

import com.unqui_arena.administracion.view.AdministracionWindow
import com.unqui_arena.administracion.view_model.AdministracionModel
import org.uqbar.arena.Application
import wallet.Account
import wallet.User

val pepeAdmin = User("1", "Pepe", "Gomez", "pepegomez@gmail.com", "pass123", true)
val juansito  = User("2", "Juan", "Perez", "juanperez@gmail.com", "pass123", false)

val accounts = mutableListOf<Account>(
    Account(pepeAdmin, "00001"),
    Account(juansito, "00002")
)
val administracionModel= AdministracionModel(accounts)

class TestAppAdministracion : Application() {
    override fun createMainWindow() =
        AdministracionWindow(this, administracionModel)
}

fun main() {
    TestAppAdministracion().start()
}