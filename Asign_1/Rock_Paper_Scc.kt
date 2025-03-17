// Rock, Paper and shears
// Autor: Dan Casas
// Fecha creación: 16/03/2025
// Fecha última modificación: 16/03/2025

import kotlin.random.Random

fun main() {
    println("Elige rock, paper or shears:")
    val eleccion = readLine()
    print("$eleccion")

    val opciones = listOf("rock", "paper", "shears")
    val eleccionPc = opciones[Random.nextInt(opciones.size)]
    println("Computadora eligió: $eleccionPc")

}