package account_info.view

import account_info.model.AccountInfoModel
import com.unqui_arena.Widgets
import org.uqbar.arena.kotlin.extensions.asColumns
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class AccountInfoWindow : Dialog<AccountInfoModel> {

    constructor(owner: WindowOwner, model: AccountInfoModel) : super(owner, model)

    val camposMap = sortedMapOf(
            "Usuario" to "userFullName",
            "Balance" to "balance"
    )

            override fun createFormPanel(mainPanel: Panel) {
        createTitle(mainPanel)
        createInfoPanel(mainPanel)
        createButtonPanel(mainPanel)
    }

    private fun createTitle(owner: Panel) =
        Widgets.titleLabel(owner, "Informacion de cuenta")

    private fun createButtonPanel(owner: Panel) =
        Widgets.buttonDefaultColor(owner, "Aceptar") { accept() }

    private fun createInfoPanel(owner: Panel) =
        Panel(owner).asColumns(2) with {
            Widgets.label(it, "Usuario:")
            Widgets.bindedLabel(it, "userFullName")

            Widgets.label(it, "CVU:")
            Widgets.bindedLabel(it, "cvu")

            Widgets.label(it, "Balance:")
            Widgets.bindedLabel(it, "balance")
        }

}