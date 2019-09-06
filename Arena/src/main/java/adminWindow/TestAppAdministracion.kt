package adminWindow

import com.unqui_arena.administracion.view.AdministracionWindow
import com.unqui_arena.administracion.view_model.AdministracionModel
import org.uqbar.arena.Application
import wallet.*

fun testModel(): AdministracionModel {
    val pepeAdmin = User("1", "Pepe", "Gomez", "bbb@gmail.com", "pass123", true)
    val juansito  = User("2", "Juan", "Perez", "aaa@gmail.com", "pass123", false)
    val alvaro    = User("3", "Alvaro", "Gomez", "ccc@hotmail.com", "pass123", false)

    val wallet = DigitalWallet()
    wallet.register(pepeAdmin)
    wallet.register(juansito)
    wallet.register(alvaro)

    return AdministracionModel(wallet)
}

class TestAppAdministracion : Application() {
    override fun createMainWindow() =
        AdministracionWindow(this, testModel())
}

fun main() = TestAppAdministracion().start()
