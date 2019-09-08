package main_window.view

import asdasdasdasd.DigitalWalletWindow
import com.unqui_arena.Widgets
import com.unqui_arena.administracion.view.AdministracionWindow
import com.unqui_arena.administracion.view_model.AdministracionModel
import main_window.model.MainDigitalWalletModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner

class MainDigitalWalletWindow : DigitalWalletWindow<MainDigitalWalletModel> {

    override var titleText = "Seleccion de operacion"

    constructor(owner: WindowOwner, model: MainDigitalWalletModel) : super(owner, model)

    override fun createBody(owner: Panel) {
        Widgets.largeButton(owner, "Revisar mi cuenta")      { openCheckLoggedUserAccount() }
        Widgets.largeButton(owner, "Transferir dinero")      { openTransferMoney() }
        Widgets.largeButton(owner, "Administrar usuarios")   { openAdministrarUsuarios() }
        Widgets.largeButton(owner, "Administrar beneficios") { openAdministrarBeneficios() }
    }

    private fun openCheckLoggedUserAccount() {

    }

    private fun openTransferMoney() {

    }

    private fun openAdministrarUsuarios() {
        close()
        val model = AdministracionModel(modelObject.wallet, modelObject.loggedUser)
        AdministracionWindow(this, model).open()
    }

    private fun openAdministrarBeneficios() {

    }
}