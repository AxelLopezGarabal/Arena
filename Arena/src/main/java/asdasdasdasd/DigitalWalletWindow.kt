package asdasdasdasd

import com.unqui_arena.Widgets
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner

abstract class DigitalWalletWindow<T> : Window<T> {
    constructor(owner: WindowOwner, model: T) : super(owner, model)

    open var appName = "Digital Wallet"
    abstract var titleText: String

    override fun createContents(mainPanel: Panel)
    {
        setUpWindow()
        createTitle(mainPanel)
        createHeader(mainPanel)
        createBody(mainPanel)
        createFooter(mainPanel)
    }

    private fun setUpWindow() {
        setTitle("$appName - $titleText")
    }

    open protected fun createTitle(owner: Panel) { Widgets.titleLabel(owner, titleText) }
    open protected fun createHeader(owner: Panel) {}
    open protected fun createBody(owner: Panel) {}
    open protected fun createFooter(owner: Panel) {}

}
