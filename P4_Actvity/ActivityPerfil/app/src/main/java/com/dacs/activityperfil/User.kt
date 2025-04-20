// Descripción: Clase parcelable que representa un usuario.
// Autor: Daniel Casas Soto
// Fecha creación: 2025-04-15
// Fecha última modificación: 2025-04-20

package com.dacs.activityperfil

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val nombre: String,
    val edad: Int,
    val ciudad: String,
    val correo: String
) : Parcelable