package com.dacs.simondiceapp.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dacs.simondiceapp.R
import com.dacs.simondiceapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    // Obtener los argumentos enviados por SafeArgs
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val puntaje = args.score

        // Mostrar el puntaje
        binding.tvPuntaje.text = getString(R.string.game_score_label, puntaje)

        // Mostrar mensaje condicional
        binding.tvResultado.text = if (puntaje >= 20) {
            getString(R.string.resultado_ganaste)
        } else {
            getString(R.string.resultado_perdiste)
        }

        // Botón para volver al menú principal
        binding.btnVolverMenu.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_welcomeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
