/**
 * Fragmento que inicializa la aplicación y permite al usuario crear un nuevo pedido
 * Autor: Daniel Casas
 * Fecha creación: 23/04/2025
 * Última modificación: 24/04/2025
 */

package com.dacs.foodcenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dacs.foodcenter.databinding.InitFragBinding

class FragPrincipal : Fragment() {
    private var _binding: InitFragBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = InitFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNuevoPedido.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_seleccionComidaFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}