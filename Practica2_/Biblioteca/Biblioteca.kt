// Descripción: Sistema de gestión de biblioteca con clases e interfaces.
// Autor: Daniel Casas
// Fecha creación: 23/03/2025
// Fecha última modificación: 23/03/2025

abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles()
}