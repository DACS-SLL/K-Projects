// Descripción: Muestra la nota recibida con opciones para compartirla o volver a editar.
// Autor: Daniel Casas Soto
// Fecha creación: 2025-04-15
// Fecha última modificación: 2025-04-20

package com.dacs.notarapida

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class OptionsAct : Activity() {
    private lateinit var tvNota: TextView
    private lateinit var btnCompartirCorreo: Button
    private lateinit var btnEditar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.options_act)

        tvNota = findViewById(R.id.tvNota)
        btnCompartirCorreo = findViewById(R.id.btnCompartirCorreo)
        btnEditar = findViewById(R.id.btnEditar)

        val nota = intent.getStringExtra("nota")
        tvNota.text = nota

        btnCompartirCorreo.setOnClickListener {
            Toast.makeText(this, R.string.mensaje_compartido, Toast.LENGTH_SHORT).show()
            // Aquí iría la lógica real para compartir por correo
            setResult(RESULT_CANCELED)
            finish()
        }

        btnEditar.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("nota_editada", nota)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}