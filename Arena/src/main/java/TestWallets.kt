import com.unqui_arena.administracion.view_model.AdministracionModel
import wallet.Account
import wallet.DigitalWallet
import wallet.User

object TestWallets {

    fun testWalletA(): DigitalWallet {

        val wallet = DigitalWallet()

        prepare("0001", "1", "Pepe", "Gomez", "admin@admin.com", "pass", true, wallet)
        prepare("0002","2", "Juan", "Perez", "juanperez@gmail.com", "pass", false, wallet)
        prepare("0003","3", "Alvaro", "Gomez", "alvaro@hotmail.com", "pass", false, wallet)
        prepare("0004","4", "Qwerty", "Asdf", "asd@gmail.com", "pass", false, wallet)

        wallet.addGift(DigitalWallet.createGift(wallet.accountByCVU("0002"), 200.0))
        wallet.transfer("0002", "0004", 80.0)

        return wallet
    }

    fun prepare(
        cvu: String,
        idCard: String,
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        isAdmin: Boolean,
        wallet: DigitalWallet)
    {
        val user = User(idCard, firstName, lastName, email, password, isAdmin)
        wallet.register(user)
        wallet.assignAccount(user, Account(user, cvu))

    }

}