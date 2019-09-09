package transfer_money.view

import asdasdasdasd.DigitalWalletWindow
import com.unqui_arena.Widgets
import org.uqbar.arena.kotlin.extensions.asColumns
import org.uqbar.arena.kotlin.extensions.asHorizontal
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import transfer_money.model.TransferMoneyModel

class TransferMoneyWindow : DigitalWalletWindow<TransferMoneyModel> {

    override var titleText = "Transferencia de dinero"

    constructor(owner: WindowOwner, model: TransferMoneyModel) : super(owner, model)

    override fun createBody(owner: Panel)   { createInputFields(owner) }
    override fun createFooter(owner: Panel) { createButtonsPanel(owner) }

    private fun createInputFields(owner: Panel) {
        Panel(owner).asColumns(2) with {
            Widgets.labeledTextBox(it, "CVU destino:","cvuTargetAccount")
            Widgets.label(it, "Monto a transferir:")
            Widgets.numericField(it, "amount")
        }
    }

    private fun createButtonsPanel(owner: Panel) {
        Panel(owner).asHorizontal() with {
            Widgets.button(it, "Realizar transferencia") { transferMoney() }
            Widgets.button(it, "Cancelar") { close() }
        }
    }

    private fun transferMoney() {
        modelObject.transferMoney()
        close()
    }

}