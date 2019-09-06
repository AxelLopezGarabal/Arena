package adminWindow

import com.unqui_arena.administracion.view.AdministracionWindow
import com.unqui_arena.administracion.view_model.AdministracionModel
import org.uqbar.arena.Application
import wallet.*

fun testModel(): AdministracionModel {
    val pepeAdmin = User("1", "Pepe", "Gomez", "pepegomez@gmail.com", "pass123", true)
    val juansito  = User("2", "Juan", "Perez", "juanperez@gmail.com", "pass123", false)

    val wallet = DigitalWallet()
    wallet.register(pepeAdmin)
    wallet.register(juansito)

    return AdministracionModel(wallet)
}

class TestAppAdministracion : Application() {
    override fun createMainWindow() =
        AdministracionWindow(this, testModel())
}

fun main() {
    TestAppAdministracion().start()
}