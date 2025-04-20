// Descripción: Pantalla inicial con formulario de usuario.
// Autor: Daniel Casas Soto
// Fecha creación: 2025-04-15
// Fecha última modificación: 2025-04-20

package com.dacs.activityperfil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormActiv : Activity() {
    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_activity)

        // Inicializar vistas
        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)
        val btnContinuar: Button = findViewById(R.id.btnContinuar)

        // Restaurar estado si existe
        savedInstanceState?.let {
            etNombre.setText(it.getString("nombre"))
            etEdad.setText(it.getString("edad"))
            etCiudad.setText(it.getString("ciudad"))
            etCorreo.setText(it.getString("correo"))
        }

        btnContinuar.setOnClickListener {
            if (validarCampos()) {
                val usuario = User(
                    etNombre.text.toString(),
                    etEdad.text.toString().toInt(),
                    etCiudad.text.toString(),
                    etCorreo.text.toString()
                )

                val intent = Intent(this, ResActi::class.java).apply {
                    putExtra("usuario", usuario)
                }
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre", etNombre.text.toString())
        outState.putString("edad", etEdad.text.toString())
        outState.putString("ciudad", etCiudad.text.toString())
        outState.putString("correo", etCorreo.text.toString())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this, R.string.perfil_guardado, Toast.LENGTH_SHORT).show()
        }
    }

    private fun validarCampos(): Boolean {
        if (etNombre.text.isEmpty() || etEdad.text.isEmpty() ||
            etCiudad.text.isEmpty() || etCorreo.text.isEmpty()) {
            Toast.makeText(this, R.string.error_campos_obligatorios, Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    companion object {
        const val REQUEST_CODE = 1001
    }
}