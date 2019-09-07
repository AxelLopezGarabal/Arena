package adminWindow

import com.unqui_arena.administracion.view.AdministracionWindow
import com.unqui_arena.administracion.view_model.AdministracionModel
import org.uqbar.arena.Application

fun testModel() = AdministracionModel(TestWallets.testWalletA())

class TestAppAdministracion(val model: AdministracionModel) : Application() {
    override fun createMainWindow() =
        AdministracionWindow(this, model)
}

fun main() = TestAppAdministracion(testModel()).start()
