/**
 * Fragmento que muestra el resumen del pedido y permite al usuario confirmar o editar el pedido
 * Autor: Daniel Casas
 * Fecha creación: 23/04/2025
 * Última modificación: 24/04/2025
 */

package com.dacs.foodcenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dacs.foodcenter.databinding.ResPedidoBinding

class ResPedido : Fragment() {
    private var _binding: ResPedidoBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<ResPedidoArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ResPedidoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvComida.text = "Comida: ${args.comida}"
        binding.tvExtras.text = "Extras: ${args.extras}"

        binding.btnConfirmar.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Pedido de ${args.comida} confirmado!",
                Toast.LENGTH_LONG
            ).show()

            findNavController().navigate(R.id.action_resumenPedidoFragment_to_inicioFragment)
        }

        binding.btnEditar.setOnClickListener {
            val result = bundleOf(
                "comida" to args.comida,
                "extras" to args.extras
            )
            setFragmentResult("editarPedido", result)
            findNavController().popBackStack(R.id.seleccionComidaFragment, false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}