package newUserWindow

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.kotlin.extensions.bindTo
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import loginwindow.Wallet
import org.uqbar.arena.layout.ColumnLayout

class NewUserWindow : Window<Wallet> {
    constructor(owner: WindowOwner, wallet: Wallet) : super(owner, wallet)
    val thisWindow = owner;
	
	override fun createContents(mainPanel: Panel) {
		setUpWindow(mainPanel);
		registerNewUser(mainPanel);
    }
	
	private fun setUpWindow(owner: Panel) {
        setTitle("Digital Wallet - UI")
		registerMessage(owner);
        setMinWidth(300)
    }

	private fun registerMessage(owner: Panel){
		Label(owner) with{
			setText("Register new user")
			setFontSize(18);
		}
	}
	
	private fun registerNewUser(owner: Panel){
		Panel(owner) with {
			asColumns(2); 
			userFields(it);
				
			blankSpace(it);
			blankSpace(it);
						
			bottons(it);
						
		}
	}
	
	private fun userFields(it: Panel){
		idCardField(it);
		nameField(it);
		lastnameField(it);
		emailField(it);
		passwordField(it);
		isAdminField(it);
	}
	
	private fun idCardField(owner: Panel){
		fields(owner, "idCard");
	}
	private fun nameField(owner: Panel){
		fields(owner, "name");
	}
	private fun lastnameField(owner: Panel){
		fields(owner, "lastname");
	}
	private fun emailField(owner: Panel){
		fields(owner, "e-mail");
	}
	private fun passwordField(owner: Panel){
		fields(owner, "password");
	}
	private fun isAdminField(owner: Panel){
		flagField(owner, "is admin");
	}
	
	private fun blankSpace(it: Panel){
		Label(it) with { setText(""); fontSize = 14;}
	}
		
	private fun fields(owner: Panel, relatedString: String){
		Panel(owner) with {
			asColumns(2);
			Label(it) with { setText(relatedString); fontSize = 14;}
			fieldInput(owner)
		}
	}
		
	private fun fieldInput(owner: Panel){
		TextBox(owner) with { fontSize = 14; setWidth(170);}
	}
	
	private fun flagField(owner: Panel, relatedString: String){
		Panel(owner) with {
			asColumns(2);
			Label(it) with { setText(relatedString); fontSize = 14;}
			CheckBox(it) with { }
		}
	}
	
	private fun bottons(owner: Panel){
		Panel(owner)with{
			asHorizontal();
			acceptBotton(it);
			cancelBotton(it);
		}
	}
	
	private fun acceptBotton(it: Panel){
		Button(it)with {
			setFontSize(14);
			setCaption(" aceptar ");	
			onClick({ close();})
		}
	}
	
	private fun cancelBotton(it: Panel){
		Button(it)with {
			setFontSize(14);
			setCaption(" cancelar ");	
			onClick({ close();})
		}
	}
}
