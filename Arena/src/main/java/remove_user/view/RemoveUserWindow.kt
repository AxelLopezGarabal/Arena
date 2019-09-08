package remove_user.view

import administracion.view_model.UserModel
import com.unqui_arena.Widgets
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import remove_user.view_model.RemoveUserModel
import wallet.DigitalWallet

class RemoveUserWindow : Dialog<RemoveUserModel> {
    constructor(owner: WindowOwner, model: RemoveUserModel) : super(owner, model)

    override fun createFormPanel(owner: Panel) {
        setUpWindow()
        createTitle(owner)
        createMessage(owner)
        createButtons(owner)
    }

    private fun setUpWindow() {
        setTitle("Digital Wallet - Baja de usuario")
    }

    private fun createTitle(owner: Panel) {
        Widgets.warningTitleLabel(owner, "Baja de usuario")
    }

    private fun createMessage(owner: Panel) {
        val myModel = modelObject
        Panel(owner) with {
            asHorizontal()
            Widgets.label(it, "¿Esta seguro de que quiere dar de baja a ")
            Widgets.label(it, "${myModel.fullName}").setForeground(Widgets.warningForegroundColor)
            Widgets.label(it, "?")
        }
    }

    private fun createButtons(owner: Panel) {
        val myModel = modelObject
        owner with {
            Widgets.button(it, "Si") { myModel.removeUser() ; accept() }
            Widgets.button(it, "No") { cancel() } with { setAsDefault() }
        }
    }
}