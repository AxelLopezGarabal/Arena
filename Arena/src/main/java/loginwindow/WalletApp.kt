package loginwindow


import org.uqbar.arena.Application
import org.uqbar.commons.model.annotations.Observable

val usuariosInicial = mutableListOf(
    Usuario("nombre1", "apellido1", "email1@gmail.com"),
    Usuario("nombre2", "apellido2", "email1@gmail.com")
)

val items = mutableListOf("Regalo", "descuento")

val BeneficiosIniciales = mutableListOf(
    Beneficio("nombre1"),
    Beneficio("nombre2")
)

@Observable class Wallet(var number: Int, var totalCashIn: Int, var totalCashOut: Int,
						  var usuarios: List<Usuario>, var beneficios: List<Beneficio>, var textoParaFiltroDeBusqueda:String,
						  var types: List<String>);
@Observable class Usuario(var nombre: String, var apellido:String, var email: String);
@Observable class Beneficio(var nombre: String);


val w = Wallet(42, 3686, 470, usuariosInicial, BeneficiosIniciales, "", items);

class WalletApp : Application() {
    override fun createMainWindow() =
        LogInWindow(this, w)
}

fun main(args: Array<String>) {
    WalletApp().start()
}