package com.dacs.simondiceapp.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dacs.simondiceapp.R
import com.dacs.simondiceapp.databinding.FragmentWelcomeBinding
import com.dacs.simondiceapp.util.SoundManager

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Acción al presionar "Jugar"
        binding.btnStart.setOnClickListener {
            SoundManager.playSound(requireContext(), R.raw.start_sound)
            findNavController().navigate(R.id.action_welcome_to_game)
        }

        // Acción al presionar "Instrucciones"
        binding.btnInstructions.setOnClickListener {
            SoundManager.playSound(requireContext(), R.raw.correct)
        }

        // Acción al presionar "Configuración"
        binding.btnSettings.setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_settings)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        SoundManager.stopSound()
        _binding = null
    }
}
