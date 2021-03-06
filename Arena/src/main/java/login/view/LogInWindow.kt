package login.view

import com.unqui_arena.Widgets
import com.unqui_arena.administracion.view.AdministracionWindow
import com.unqui_arena.administracion.view_model.AdministracionModel
import main_window.model.MainDigitalWalletModel
import main_window.view.MainDigitalWalletWindow
import org.uqbar.arena.kotlin.extensions.asColumns
import org.uqbar.arena.kotlin.extensions.bindImageTo
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.windows.SimpleWindow
import login.view_model.LoginModel

class LogInWindow : SimpleWindow<LoginModel> {
    constructor(owner: WindowOwner, model: LoginModel) : super(owner, model)
    override fun createFormPanel(mainPanel: Panel){}
	
	override fun addActions(mainPanel: Panel){
		Widgets.button(mainPanel, "LOG IN") {
			modelObject.validate() ;
			openMainWindow() ;
		}
	}
	
    override fun createContents(mainPanel: Panel) {
		setUpWindow();
		welcomeMessage(mainPanel);
        createInputPanel(mainPanel);
		addActions(mainPanel);
    //    createButtonsPanel(mainPanel)
    }

	private fun setUpWindow() {
        setTitle("Digital Wallet - UI")
    }
	
	private fun welcomeMessage(owner: Panel){
		Widgets.titleLabel(owner, "Welcome")
		Label(owner).bindImageTo("wellcomeImage")
	}
	
    private fun createInputPanel(owner: Panel) {
        Panel(owner) with {
            asColumns(2)
			emailField(it)
			passwordField(it)
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
/*	
    private fun createButtonsPanel(owner: Panel) {
        Panel(owner) with {
			Widgets.largeButtonDefaultColor(owner, "Login") { openAdministracionWindow() } with {
				setAsDefault()
			}
		}
    }
*/
	private fun openMainWindow() {
		close()
		MainDigitalWalletWindow(
			this,
			MainDigitalWalletModel(modelObject.loggedUser(), modelObject.wallet)
		).open()
	}
}
