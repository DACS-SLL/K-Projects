// Rock, Paper and shears
// Autor: Dan Casas
// Fecha creación: 16/03/2025
// Fecha última modificación: 16/03/2025

import kotlin.random.Random

fun jugar(eleccionUs: String) {
    val opciones = listOf("rock", "paper", "shears")
    val eleccionPc = opciones[Random.nextInt(opciones.size)]
    println("Computadora eligió: $eleccionPc")

    val resultado = when {
        eleccionUs == eleccionPc -> "Empate"
        (eleccionUs == "rock" && eleccionPc == "shears") ||
                (eleccionUs == "paper" && eleccionPc == "rock") ||
                (eleccionUs == "shears" && eleccionPc == "paper") -> "Ganaste"
        else -> "Perdiste"
    }
    println(resultado)
}

fun main() {
    println("Elige rock, paper or shears:")
    val eleccionUs = readLine()?.lowercase() ?: return
    jugar(eleccionUs)
}