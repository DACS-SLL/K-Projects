// Descripción: Clase CuentaBancaria que gestiona el saldo y el límite de retiro.
// Autor: Daniel Casas
// Fecha creación: 23/03/2025
// Fecha última modificación: 23/03/2025

// Constructor de clase
class CuentaBancaria {
    private var saldo: Double = 0.0
    private var limiteRet: Double = 1000.0

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