package modify_user.view

import com.unqui_arena.Widgets
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import modify_user.view_model.ModifyUserModel
import org.uqbar.arena.kotlin.extensions.asColumns
import org.uqbar.arena.kotlin.extensions.asHorizontal

class ModifyUserWindow : Dialog<ModifyUserModel> {
    constructor(owner: WindowOwner, model: ModifyUserModel) : super(owner, model)

    override fun createFormPanel(mainPanel: Panel) {
        setUpWindow()
        createTitle(mainPanel)
        createUserDataPanel(mainPanel)
        createButtonsPanel(mainPanel)
    }

    private fun setUpWindow() {
        setTitle("Datos de usuario")
    }

    private fun createTitle(owner: Panel) =
        Widgets.titleLabel(owner, "Datos de ${modelObject.fullName}")

    private fun createUserDataPanel(owner: Panel) =
        Panel(owner) with {
            asColumns(2)
            createFistNameField(it)
            createLastNameField(it)
            createEmailField(it)
            //createEstadoField(it)
            createCVUField(it)
            createBalanceField(it)
        }

    private fun createFistNameField(owner: Panel) {
        createField(owner, "Nombre:", "firstName")
    }

    private fun createLastNameField(owner: Panel) {
        createField(owner, "Apellido:", "lastName")
    }

    private fun createEmailField(owner: Panel) {
        Widgets.labeledTextBox(owner, "Email:", "email")
    }

    private fun createCVUField(owner: Panel) {
        createField(owner, "CVU:", "cvu")
    }

    private fun createBalanceField(owner: Panel) {
        createField(owner, "Balance:", "balance")
    }

    private fun createButtonsPanel(owner: Panel) {
        Panel(owner) with {
            asHorizontal()
            Widgets.largeButton(it, "Aceptar")  { accept() }
            Widgets.largeButton(it, "Cancelar") { cancel() }
        }
    }

    private fun createField(owner: Panel, fieldName: String, propertyName: String) {
        Widgets.label(owner, fieldName)
        Widgets.bindedLabel(owner, propertyName)
    }

}