import com.unqui_arena.administracion.view_model.AdministracionModel
import wallet.Account
import wallet.DigitalWallet
import wallet.User

object TestWallets {

    fun testWalletA(): DigitalWallet {
        val pepeAdmin = User("1", "Pepe", "Gomez", "bbb@gmail.com", "pass123", true)
        val juan      = User("2", "Juan", "Perez", "aaa@gmail.com", "pass123", false)
        val alvaro    = User("3", "Alvaro", "Gomez", "ccc@hotmail.com", "pass123", false)

        val juanAccount = Account(juan, "123")
        juanAccount.balance = 1.0

        val wallet = DigitalWallet()
        wallet.register(pepeAdmin)
        wallet.register(juan)
        wallet.register(alvaro)

        wallet.assignAccount(juan, juanAccount)

        return wallet
    }

}