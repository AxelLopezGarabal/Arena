package newUserWindow.view

import com.unqui_arena.Widgets
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.WindowOwner
import newUserWindow.view_model.NewUserModel
import org.uqbar.arena.windows.Dialog

class NewUserWindow : Dialog<NewUserModel> {

	constructor(owner: WindowOwner, model: NewUserModel) : super(owner, model)

	override fun createFormPanel(mainPanel: Panel) {
		setUpWindow(mainPanel)
		createTitle(mainPanel)
		createInputFieldasdasdasdasd(mainPanel)
    }
	
	private fun setUpWindow(owner: Panel) {
        setTitle("Digital Wallet - UI")
        setMinWidth(300)
    }

	private fun createTitle(owner: Panel) =
		Widgets.titleLabel(owner, "Registrar nuevo usuario")

	
	private fun createInputFieldasdasdasdasd(owner: Panel) =
		Panel(owner) with {
			asColumns(2)
			userFields(it)
				
			blankSpace(it)
			blankSpace(it)
						
			bottonsPanel(it)
		}
	
	private fun userFields(owner: Panel) {
		Panel(owner).asColumns(2) with {
			idCardField(it)
			nameField(it)
			lastnameField(it)
			emailField(it)
			passwordField(it)
			passwordFieldAgain(it)
			isAdminField(it)
		}
	}
	
	private fun idCardField(owner: Panel) =
		Widgets.labeledTextBox(owner, "Id card:", "idCard")

	private fun nameField(owner: Panel) =
		Widgets.labeledTextBox(owner, "Nombre:", "firstName")

	private fun lastnameField(owner: Panel) =
		Widgets.labeledTextBox(owner, "Apellido:", "lastName")

	private fun emailField(owner: Panel) =
		Widgets.labeledTextBox(owner, "E-mail", "email")

	private fun passwordField(owner: Panel) =
		Widgets.labeledPasswordField(owner, "Password:", "password")

	private fun passwordFieldAgain(owner: Panel) =
		Widgets.labeledPasswordField(owner, "Repita su password:", "passwordAgain")

	private fun isAdminField(owner: Panel) =
		Widgets.checkBoxField(owner, "Es administrador:")

	private fun blankSpace(owner: Panel) =
		Widgets.label(owner, "")

	private fun bottonsPanel(owner: Panel) =
		Panel(owner) with {
			asHorizontal()
			acceptBotton(it)
			cancelBotton(it)
		}
	
	private fun acceptBotton(owner: Panel) =
		Widgets.button(owner, "Aceptar") { accept() }
	
	private fun cancelBotton(owner: Panel) =
		Widgets.button(owner, "Cancelar") { cancel() }
}