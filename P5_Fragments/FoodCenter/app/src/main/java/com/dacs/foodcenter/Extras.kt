/**
 * Fragmento que Permite seleccionar los extras en base a 3 opciones: Bebida, Papas y Postre
 * Autor: Daniel Casas
 * Fecha creación: 23/04/2025
 * Última modificación: 24/04/2025
 */

package com.dacs.foodcenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dacs.foodcenter.databinding.ExtrasBinding

class Extras : Fragment() {
    private var _binding: ExtrasBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<ExtrasArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ExtrasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSiguienteExtras.setOnClickListener {
            val extras = mutableListOf<String>().apply {
                if (binding.checkBebida.isChecked) add("Bebida")
                if (binding.checkPapas.isChecked) add("Papas")
                if (binding.checkPostre.isChecked) add("Postre")
            }

            val bundle = bundleOf(
                "comida" to args.comida,
                "extras" to extras.joinToString(", ")
            )

            findNavController().navigate(
                R.id.action_seleccionExtrasFragment_to_resumenPedidoFragment,
                bundle
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}