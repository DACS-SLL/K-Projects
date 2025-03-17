// Evaluación Empleados
// Autor: Dan Casas
// Fecha creación: 16/03/2025
// Fecha última modificación: 16/03/2025

fun empleadoEv(salario: Double, puntuacion: Int) {
    val nivel = when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación no válida"
    }
    if (nivel != "Puntuación no válida") {
        val dinero = salario * (puntuacion / 10.0)
        println("Nivel de Rendimiento: $nivel, Cantidad de Dinero Recibido: $$dinero")
    } else {
        println("Error: La puntuación ingresada no es válida.")
    }
}

fun main() {
    println("Ingrese su salario mensual:")
    val salario = readLine()?.toDoubleOrNull() ?: return
    println("Ingrese su puntuación:")
    val puntuacion = readLine()?.toIntOrNull() ?: return
    empleadoEv(salario, puntuacion)
}