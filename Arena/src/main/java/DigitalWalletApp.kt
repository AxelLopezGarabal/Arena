import login.view.LogInWindow
import login.view_model.LoginModel
import org.uqbar.arena.Application
import wallet.DigitalWallet

class WalletApp(val wallet: DigitalWallet) : Application() {
    override fun createMainWindow() =
        LogInWindow(this, LoginModel(wallet))
}

fun main(args: Array<String>) {
    WalletApp(TestWallets.testWalletA()).start()
}