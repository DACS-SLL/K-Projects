/**
* Fragmento que Permite seleccionar la comida en base a 3 opciones: Pizza, Hamburguesa y Ensalada
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
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.dacs.foodcenter.databinding.SelectFoodBinding

class ComidaSelect : Fragment() {
    private var _binding: SelectFoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SelectFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener("editarPedido", viewLifecycleOwner) { _, bundle ->
            bundle.getString("comida")?.let { comida ->
                when (comida) {
                    "Pizza" -> binding.radioPizza.isChecked = true
                    "Hamburguesa" -> binding.radioHamburguesa.isChecked = true
                    "Ensalada" -> binding.radioEnsalada.isChecked = true
                }
            }
        }

        binding.btnSiguienteComida.setOnClickListener {
            val selectedId = binding.radioGroupComida.checkedRadioButtonId
            if (selectedId != -1) {
                val comida = when (selectedId) {
                    R.id.radioPizza -> "Pizza"
                    R.id.radioHamburguesa -> "Hamburguesa"
                    R.id.radioEnsalada -> "Ensalada"
                    else -> ""
                }

                val bundle = bundleOf("comida" to comida)
                findNavController().navigate(
                    R.id.action_seleccionComidaFragment_to_seleccionExtrasFragment,
                    bundle
                )
            } else {
                Toast.makeText(requireContext(), "Selecciona un tipo de comida", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}