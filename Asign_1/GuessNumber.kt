// Adivina el number
// Autor: Dan Casas
// Fecha creación: 16/03/2025
// Fecha última modificación: 16/03/2025
import kotlin.random.Random

fun adivinaNumero() {
    val numeroSecreto = Random.nextInt(1, 31)
    var intentos = 5

    while (intentos > 0) {
        print("Adivina el número (1-30): ")
        val intento = readLine()?.toIntOrNull() ?: continue

        when {
            intento < numeroSecreto -> println("El número es mayor")
            intento > numeroSecreto -> println("El número es menor")
            else -> {
                println("¡Felicidades! Adivinaste el número.")
                return
            }
        }
        intentos--
        println("Intentos restantes: $intentos")
    }
    println("Game Over. El número era $numeroSecreto.")
}

fun main() {
    adivinaNumero()
}
