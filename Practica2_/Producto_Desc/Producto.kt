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