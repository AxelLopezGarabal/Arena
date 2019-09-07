package remove_user.view

import administracion.view_model.UserModel
import com.unqui_arena.Widgets
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class RemoveUserWindow : Dialog<UserModel> {
    constructor(owner: WindowOwner, model: UserModel) : super(owner, model)

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
        Widgets.label(owner, "¿Esta seguro de que quiere dar de baja a ${modelObject.fullName}?")
    }

    private fun createButtons(owner: Panel) {
        owner with {
            Widgets.button(it, "Si") { accept() }
            Widgets.button(it, "No") { cancel() }
        }
    }
}