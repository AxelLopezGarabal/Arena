package new_benefits.view

import com.unqui_arena.Widgets
import org.uqbar.arena.kotlin.extensions.asColumns
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import wallet.DigitalWallet

class NewUserWindow : Window<DigitalWallet> {
    constructor(owner: WindowOwner, model: DigitalWallet) : super(owner, model)

	val titulo = "Generar nuevo beneficio"

	override fun createContents(mainPanel: Panel) {
		setUpWindow(mainPanel)
		createTitle(mainPanel)
		registerNewUser(mainPanel)
    }
	
	private fun setUpWindow(owner: Panel) {
        setTitle("Digital Wallet - $titulo")
    }

	private fun createTitle(owner: Panel) =
		Widgets.titleLabel(owner, titulo)
	
	private fun registerNewUser(owner: Panel){
		Panel(owner) with {
			asColumns(2); 
			
			flagField(it, "new Gift");
			flagField(it, "new discount")
			
			blankSpace(it)
			blankSpace(it)
			
			benefitsFields(it)
			blankSpace(it)
			blankSpace(it)
			
		}
	}
	
	private fun blankSpace(owner: Panel){
		Widgets.label(owner, "")
	}
	
	private fun flagField(owner: Panel, texto: String){
		Panel(owner) with {
			asColumns(2)
			Widgets.label(it, texto)
			CheckBox(it) with { }
		}
	}
	
	private fun benefitsFields(owner: Panel){
		nameField(owner, "nombre")
		dateField(owner, "fecha desde")
		dateField(owner, "fecha hasta")
		
		Selector<String>(owner) with {
			bindItemsToProperty("types")
		}
	}
	
	private fun nameField(owner: Panel, text: String){}
	private fun dateField(owner: Panel, text: String){}
	
}
