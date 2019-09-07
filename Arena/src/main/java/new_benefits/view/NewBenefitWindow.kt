package new_benefits.view

import org.uqbar.arena.kotlin.extensions.asColumns
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import wallet.DigitalWallet

class NewUserWindow : Window<DigitalWallet> {
    constructor(owner: WindowOwner, wallet: DigitalWallet) : super(owner, wallet)
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
			setText("Create a new benefit")
			setFontSize(18)
		}
	}
	
	private fun registerNewUser(owner: Panel){
		Panel(owner) with {
			asColumns(2); 
			
			flagField(it, "new Gift");
			flagField(it, "new discount")
			
			blankSpace(it);
			blankSpace(it);
			
			benefitsFields(it);
			blankSpace(it);
			blankSpace(it);
			
		}
	}
	
	private fun blankSpace(it: Panel){
		Label(it) with { setText(""); fontSize = 14;}
	}
	
	private fun flagField(owner: Panel, relatedString: String){
		Panel(owner) with {
			asColumns(2);
			Label(it) with { setText(relatedString); fontSize = 14;}
			CheckBox(it) with { }
		}
	}
	
	private fun benefitsFields(it: Panel){
		nameField(it, "nombre");
		dateField(it, "fecha desde");
		dateField(it, "fecha hasta");
		
		Selector<String>(it) with {
			bindItemsToProperty("types");
		}
	}
	
	private fun nameField(it: Panel, string: String){}
	private fun dateField(it: Panel, string: String){}
	
}
