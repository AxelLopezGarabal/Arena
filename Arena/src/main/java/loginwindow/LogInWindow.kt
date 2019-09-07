package loginwindow

import com.unqui_arena.Widgets
import com.unqui_arena.administracion.view.AdministracionWindow
import com.unqui_arena.administracion.view_model.AdministracionModel
import loginwindow.view_model.LoginModel
import org.uqbar.arena.kotlin.extensions.asColumns
import org.uqbar.arena.kotlin.extensions.asHorizontal
import org.uqbar.arena.kotlin.extensions.asVertical
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner

class LogInWindow : Window<LoginModel> {
    constructor(owner: WindowOwner, model: LoginModel) : super(owner, model)

	val thisWindow = this

    override fun createContents(mainPanel: Panel) {
		setUpWindow(mainPanel)
		welcomeMessage(mainPanel)
        createInputPanel(mainPanel)
        createButtonsPanel(mainPanel)
    }

	private fun setUpWindow(owner: Panel) {
        setTitle("Digital Wallet - UI")
    }
	
	private fun welcomeMessage(owner: Panel){
		Widgets.titleLabel(owner, "Welcome")
	}
	
    private fun createInputPanel(owner: Panel) {
        Panel(owner) with {
            asColumns(2)
			emailField(owner)
			passwordField(owner)
        }
    }

	private fun emailField(owner: Panel){
		Widgets.mediumLabel(owner, "E-mail:")
		Widgets.mediumTextBox(owner, "email")
	}

	private fun passwordField(owner: Panel){
		Widgets.mediumLabel(owner, "Password:")
		Widgets.mediumPasswordField(owner, "password")
	}
	
    private fun createButtonsPanel(owner: Panel) {
        Panel(owner) with {
			Widgets.largeButton(owner, "Login") { openAdministracionWindow() }
		}
    }

	private fun openAdministracionWindow() {
		close()
		AdministracionWindow(thisWindow, AdministracionModel(modelObject.wallet)).open()
	}
}
