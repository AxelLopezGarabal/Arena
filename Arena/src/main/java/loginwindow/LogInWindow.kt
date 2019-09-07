package loginwindow

import com.unqui_arena.Widgets
import com.unqui_arena.administracion.view.AdministracionWindow
import com.unqui_arena.administracion.view_model.AdministracionModel
import loginwindow.view_model.LoginModel
import org.uqbar.arena.kotlin.extensions.asHorizontal
import org.uqbar.arena.kotlin.extensions.asVertical
import org.uqbar.arena.kotlin.extensions.with
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
        setMinWidth(300)
    }
	
	private fun welcomeMessage(owner: Panel){
		Widgets.titleLabel(owner, "Welcome")
	}
	
    private fun createInputPanel(owner: Panel) {
        Panel(owner) with {
            asVertical();
			emailField(owner);
			passwordField(owner);
        }
    }

	private fun emailField(owner: Panel){
		Panel(owner)with{
			asHorizontal();
			Label(it)with {setText("E-mail       "); setFontSize(14);}
			TextBox(it) with {fontSize = 14; setWidth(170);}
		}
	}
	
	private fun passwordField(owner: Panel){
		Panel(owner)with{
			asHorizontal();
			Label(it)with {setText("Password "); setFontSize(14);}
			PasswordField(it) with {fontSize = 14; setWidth(170);}
		}
	}
	
    private fun createButtonsPanel(owner: Panel) {
        Panel(owner) with {
        	Button(owner)with {
				setFontSize(14);
        		setCaption(" Log In");
				onClick { openAdministracionWindow() }
        	}
		}
    }

	private fun openAdministracionWindow() {
		close()
		AdministracionWindow(thisWindow, AdministracionModel(modelObject.wallet)).open()
	}
}
		