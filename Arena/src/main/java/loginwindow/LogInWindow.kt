package loginwindow

import org.uqbar.arena.kotlin.extensions.asColumns
import org.uqbar.arena.kotlin.extensions.asHorizontal
import org.uqbar.arena.kotlin.extensions.asVertical
import org.uqbar.arena.kotlin.extensions.bindTo
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import newUserWindow.NewUserWindow

class LogInWindow : Window<Wallet> {
    constructor(owner: WindowOwner, wallet: Wallet) : super(owner, wallet)
    val thisWindow = owner;
	
    override fun createContents(mainPanel: Panel) {
		setUpWindow(mainPanel)
        createInputPanel(mainPanel)
        createButtonsPanel(mainPanel)
    }

	private fun setUpWindow(owner: Panel) {
        setTitle("Digital Wallet - UI")
		welcomeMessage(owner);
        setMinWidth(300)
    }
	
	private fun welcomeMessage(owner: Panel){
		Label(owner) with{
			setText("Welcome")
			setFontSize(18);
		}
	}
	
    private fun createInputPanel(owner: Panel) {
        Panel(owner) with {
            asVertical();
			emailField(owner);
			passwordField(owner);
            //Widgets.labeledTextBox(owner, "Correo electronico:", )
            //Widgets.labeledPasswordField(owner, "email", "password")
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
				onClick({ close(); NewUserWindow(thisWindow, w).open(); })
        	}
		}
    }
}
		