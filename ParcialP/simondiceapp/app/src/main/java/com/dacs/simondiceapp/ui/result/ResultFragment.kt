package com.dacs.simondiceapp.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dacs.simondiceapp.R
import com.dacs.simondiceapp.data.PreferencesManager
import com.dacs.simondiceapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    private val args: ResultFragmentArgs by navArgs()
    private lateinit var preferencesManager: PreferencesManager

    // Umbrales para determinar el resultado
    companion object {
        private const val WINNING_THRESHOLD = 20
        private const val HIGH_SCORE_MESSAGE = "¡Nuevo récord!"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        preferencesManager = PreferencesManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentScore = args.score
        val highScore = preferencesManager.getHighScore()

        setupUI(currentScore, highScore)
        setupClickListeners()
    }

    private fun setupUI(currentScore: Int, highScore: Int) {
        // Mostrar puntajes
        binding.tvCurrentScore.text = getString(R.string.puntaje_label, currentScore)
        binding.tvHighScore.text = getString(R.string.puntaje_alto_label, highScore)

        // Mostrar mensaje especial si es nuevo récord
        if (currentScore >= highScore) {
            binding.tvHighScoreMessage.text = HIGH_SCORE_MESSAGE
            binding.tvHighScoreMessage.visibility = View.VISIBLE
        } else {
            binding.tvHighScoreMessage.visibility = View.GONE
        }

        // Determinar mensaje de resultado
        binding.tvResultMessage.text = if (currentScore >= WINNING_THRESHOLD) {
            getString(R.string.resultado_ganaste)
        } else {
            getString(R.string.resultado_perdiste)
        }
    }

    private fun setupClickListeners() {
        binding.btnRestart.setOnClickListener {
            navigateToGame()
        }

        binding.btnMenu.setOnClickListener {
            navigateToWelcome()
        }
    }

    private fun navigateToGame() {
        findNavController().navigate(R.id.action_resultFragment_to_gameFragment)
    }

    private fun navigateToWelcome() {
        findNavController().navigate(R.id.action_resultFragment_to_welcomeFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}