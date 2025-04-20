// Descripción: Pantalla principal para escribir una nota y enviarla a otra actividad.
// Autor: Daniel Casas Soto
// Fecha creación: 2025-04-15
// Fecha última modificación: 2025-04-20

package com.dacs.notarapida

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditAct : Activity() {
    private lateinit var etNota: EditText
    private lateinit var btnCompartir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_act)

        etNota = findViewById(R.id.etNota)
        btnCompartir = findViewById(R.id.btnCompartir)

        // Restaurar estado si existe
        savedInstanceState?.let {
            etNota.setText(it.getString("nota"))
        }

        btnCompartir.setOnClickListener {
            val nota = etNota.text.toString()
            if (nota.isNotEmpty()) {
                val intent = Intent(this, OptionsAct::class.java).apply {
                    putExtra("nota", nota)
                }
                startActivityForResult(intent, REQUEST_CODE)
            } else {
                Toast.makeText(this, R.string.error_nota_vacia, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nota", etNota.text.toString())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            val notaEditada = data?.getStringExtra("nota_editada")
            notaEditada?.let {
                etNota.setText(it)
                etNota.setSelection(it.length)
            }
        }
    }

    companion object {
        const val REQUEST_CODE = 1002
    }
}