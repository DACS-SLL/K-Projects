// Calculadora Elemental
// Autor: Dan Casas
// Fecha creación: 16/03/2025
// Fecha última modificación: 16/03/2025

fun calculadora() {
    while (true) {
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        print("Seleccione una opción: ")

        val opcion = readLine()?.toIntOrNull() ?: continue
        if (opcion == 5) break

        print("Ingrese el primer número: ")
        val num1 = readLine()?.toDoubleOrNull() ?: continue
        print("Ingrese el segundo número: ")
        val num2 = readLine()?.toDoubleOrNull() ?: continue

        val resultado = when (opcion) {
            1 -> num1 + num2
            2 -> num1 - num2
            3 -> num1 * num2
            4 -> if (num2 != 0.0) num1 / num2 else "Error: División por cero"
            else -> "Opción inválida"
        }
        println("Resultado: $resultado")
    }
}

fun main() {
    calculadora()
}