// Descripción: Muestra el resumen del perfil del usuario con opciones para confirmar o editar.
// Autor: Daniel Casas Soto
// Fecha creación: 2025-04-15
// Fecha última modificación: 2025-04-20

package com.dacs.activityperfil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResActi : Activity() {
    private lateinit var tvResumen: TextView
    private lateinit var btnConfirmar: Button
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.res_act)

        tvResumen = findViewById(R.id.tvResumen)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnVolver = findViewById(R.id.btnVolver)

        val usuario = intent.getParcelableExtra<User>("usuario")
        usuario?.let {
            tvResumen.text = """
                Nombre: ${it.nombre}
                Edad: ${it.edad}
                Ciudad: ${it.ciudad}
                Correo: ${it.correo}
            """.trimIndent()
        }

        btnConfirmar.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        btnVolver.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}