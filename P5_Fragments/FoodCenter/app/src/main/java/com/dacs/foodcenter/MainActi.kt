/**
 * Actividad princial de la aplicación, usa AppCompatActivity para poder usar el tema personalizado
 * Autor: Daniel Casas
 * Fecha creación: 23/04/2025
 * Última modificación: 24/04/2025
 */

package com.dacs.foodcenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dacs.foodcenter.databinding.ActivPrincipalBinding

class MainActi : AppCompatActivity() {
    private lateinit var binding: ActivPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}