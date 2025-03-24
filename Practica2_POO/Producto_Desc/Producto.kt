// Descripción: Clase Producto que gestiona el precio y el descuento aplicable.
// Autor: Daniel Casas
// Fecha creación: 23/03/2025
// Fecha última modificación: 23/03/2025

class Producto {
    private var pres: Double = 0.0
    private var descuento: Double = 0.0

    // Getter y Setter para precio
    fun getPrecio(): Double {
        return pres
    }

    fun setPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio >= 0) {
            pres = nuevoPrecio  // Asignacion de precio
        } else {
            println("Error: El precio no puede ser negativo.")
        }
    }

    // Getter y Setter para descuento
    fun getDescuento(): Double {
        return descuento
    }

    fun setDescuento(nuevoDescuento: Double) {
        if (nuevoDescuento in 0.0..100.0) { // Verificacion para que no salga de 100% de dsc
            descuento = nuevoDescuento
        } else {
            println("Error: El descuento debe estar entre 0 y 100.")
        }
    }

    // Metodo para calcular el precio final
    fun calcularPrecioFinal(): Double {
        return pres * (1 - descuento / 100)
    }
}

// Pruebas
fun main() {
    val producto = Producto()
    producto.setPrecio(100.0)
    producto.setDescuento(20.0)
    println("Precio final: ${producto.calcularPrecioFinal()}")
}