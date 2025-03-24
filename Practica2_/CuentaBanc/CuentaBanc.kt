// Descripción: Clase CuentaBancaria que gestiona el saldo y el límite de retiro.
// Autor: Daniel Casas
// Fecha creación: 23/03/2025
// Fecha última modificación: 23/03/2025

// Constructor de clase
class CuentaBancaria {
    private var saldo: Double = 0.0
    private var limiteRet: Double = 1000.0 // Establecemos un limite

    // Getter y Setter para saldo
    fun getSaldo(): Double {
        return saldo
    }

    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo // No agrega saldo, establece uno nuevo
        } else {
            println("Error: El saldo no puede ser negativo.")
        }
    }

    // Getter y Setter para límite de retiro
    fun getLimiteRet(): Double {
        return limiteRet
    }

    fun setLimiteRe(nuevoLimite: Double) {
        if (nuevoLimite >= 0) {
            limiteRet = nuevoLimite
        } else {
            println("Error: El límite de retiro no puede ser negativo.")
        }
    }

    // Metodo para realizar retiros
    fun retirar(monto: Double) {
        if (monto > limiteRet) { // Supera el limite establecido
            println("Error: El monto excede el límite de retiro.")
        } else if (monto > saldo) { // No hay fondos
            println("Error: Saldo insuficiente.")
        } else { // Retiro completo
            saldo -= monto
            println("Retiro exitoso. Saldo restante: $saldo")
        }
    }
}

// Pruebas
fun main() {
    val cuenta = CuentaBancaria()
    cuenta.setSaldo(2000.0)
    cuenta.retirar(500.0)
    cuenta.retirar(1500.0) // Esto debería fallar porque excede el limite
}