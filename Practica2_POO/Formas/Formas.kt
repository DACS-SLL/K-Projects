// Descripción: Clase abstracta Shape y subclases para calcular área y perímetro.
// Autor: Daniel Casas
// Fecha creación: 23/03/2025
// Fecha última modificación: 23/03/2025

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double
    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}


class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}

class Circulo(private val radio: Double) : Shape() {
    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}

class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {
    override fun calcularArea(): Double {
        return largo * ancho
    }

    override fun calcularPerimetro(): Double {
        return 2 * (largo + ancho)
    }
}

//Pruebas
fun main() {
    val cuadrado = Cuadrado(5.0)
    println("Calculando Cuadrado...")
    cuadrado.imprimirResultados()

    val circulo = Circulo(3.0)
    println("Calculando Circulo...")
    circulo.imprimirResultados()

    val rectangulo = Rectangulo(4.0, 6.0)
    println("Calculando Rectangulo...")
    rectangulo.imprimirResultados()
}
}