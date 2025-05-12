package com.dacs.simondiceapp.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.dacs.simondiceapp.R
import com.dacs.simondiceapp.databinding.FragmentWelcomeBinding
import com.dacs.simondiceapp.util.SoundManager

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    val navOptions = NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right)
        .build()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        SoundManager.playMusic(requireContext(), key = "start", musicRes = R.raw.fondo, loop = true)
        // Acción al presionar "Jugar"
        binding.btnStart.setOnClickListener {
            SoundManager.playMusic(requireContext(), key = "boton", musicRes = R.raw.start_sound, loop = false)
            findNavController().navigate(R.id.action_welcome_to_game, null, navOptions)
        }

        // Acción al presionar "Configuración"
        binding.btnSettings.setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_settings, null, navOptions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        SoundManager.release()
        _binding = null
    }
}
