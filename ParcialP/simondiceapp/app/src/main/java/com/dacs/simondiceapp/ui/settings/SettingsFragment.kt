package com.dacs.simondiceapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.dacs.simondiceapp.R
import com.dacs.simondiceapp.databinding.FragmentSettingsBinding
import com.dacs.simondiceapp.managers.SettingsManager

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var settingsManager: SettingsManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        settingsManager = SettingsManager.getInstance(requireContext())

        return binding.root
    }

    val navOptions = NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right)
        .build()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializamos el estado del switch con la preferencia actual
        binding.switchSound.isChecked = settingsManager.isSoundEnabled()

        // Guardamos el nuevo estado cuando el usuario interactúa con el switch
        binding.switchSound.setOnCheckedChangeListener { _, isChecked ->
            settingsManager.setSoundEnabled(isChecked)
        }

        // Acción al presionar "Volver"
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_welcomeFragment, null, navOptions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
