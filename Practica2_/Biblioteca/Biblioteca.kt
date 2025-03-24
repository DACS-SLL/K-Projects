// Descripción: Sistema de gestión de biblioteca con clases e interfaces.
// Autor: Daniel Casas
// Fecha creación: 23/03/2025
// Fecha última modificación: 23/03/2025

abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles()
}

class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numPaginas: Int) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numPaginas")
    }
}

class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int, val editorial: String) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo(usuario: Usuario, material: Material)
    fun devolucion(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        usuarios[usuario] = mutableListOf()
        println("Usuario: ${usuario.nombre} , registrado con éxito.")
    }

    override fun prestamo(usuario: Usuario, material: Material) {
        if (material in materialesDisponibles) {
            materialesDisponibles.remove(material)
            usuarios[usuario]?.add(material)
            println("Préstamo realizado con éxito.")
        } else {
            println("Error: Material no disponible.")
        }
    }

    override fun devolucion(usuario: Usuario, material: Material) {
        if (usuarios[usuario]?.contains(material) == true) {
            usuarios[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Devolución realizada con éxito.")
        } else {
            println("Error: Material no prestado por este usuario.")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre}:")
        usuarios[usuario]?.forEach { it.mostrarDetalles() }
    }
}

//Pruebas
fun main() {
    val biblioteca = Biblioteca()

    val libro1 = Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Novela", 432)
    val revista1 = Revista("National Geographic", "Varios", 2021, "1234-5678", 240, 3, "National Geographic Society")

    val usuario1 = Usuario("Daniel", "Casas", 23)

    biblioteca.registrarMaterial(libro1)   //Registro de libro
    biblioteca.registrarMaterial(revista1) //Registro de revista
    biblioteca.registrarUsuario(usuario1)  //Resgistro de usuario

    biblioteca.mostrarMaterialesDisponibles() //Libros disponibles

    biblioteca.prestamo(usuario1, libro1)                         // Prestamo
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)    // Libros reservados

    biblioteca.devolucion(usuario1, libro1)      // Devolucion
    biblioteca.mostrarMaterialesDisponibles()    // Libros disponibles
}