package com.dacs.simondiceapp.ui.game

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dacs.simondiceapp.R
import com.dacs.simondiceapp.databinding.FragmentGameBinding
import com.dacs.simondiceapp.util.SoundManager

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private val colors = listOf("ROJO", "AZUL", "VERDE", "AMARILLO")
    private val colorValues by lazy {
        mapOf(
            "ROJO" to ContextCompat.getColor(requireContext(), R.color.red),
            "AZUL" to ContextCompat.getColor(requireContext(), R.color.blue),
            "VERDE" to ContextCompat.getColor(requireContext(), R.color.green),
            "AMARILLO" to ContextCompat.getColor(requireContext(), R.color.yellow)
        )
    }

    private var currentColor = ""
    private var score = 0
    private var timeLeft = 30
    private var timer: CountDownTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startGame()
        setupButtons()
    }

    private fun startGame() {
        score = 0
        updateScore()
        startTimer()
        playMusic()
        showRandomColor()
    }

    private fun startTimer() {
        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000).toInt()
                binding.tvTime.text = getString(R.string.game_time_label, timeLeft)
            }

            override fun onFinish() {
                SoundManager.stopSound()
                val action = GameFragmentDirections.actionGameToResult(score)
                findNavController().navigate(action)
            }
        }.start()
    }

    private fun playMusic() {
        SoundManager.playSound(requireContext(), R.raw.timer_music)
    }

    private fun setupButtons() {
        binding.btnRojo.setOnClickListener { checkAnswer("ROJO") }
        binding.btnAzul.setOnClickListener { checkAnswer("AZUL") }
        binding.btnVerde.setOnClickListener { checkAnswer("VERDE") }
        binding.btnAmarillo.setOnClickListener { checkAnswer("AMARILLO") }
    }

    private fun checkAnswer(selected: String) {
        if (selected == currentColor) {
            score++
            updateScore()
            SoundManager.playSound(requireContext(), R.raw.correct)
        } else {
            SoundManager.playSound(requireContext(), R.raw.wrong)
        }
        showRandomColor()
    }

    private fun updateScore() {
        binding.tvScore.text = getString(R.string.game_score_label, score)
    }

    private fun showRandomColor() {
        val random = colors.random()
        currentColor = random
        val color = colorValues[random] ?: Color.BLACK

        binding.viewColor.setBackgroundColor(color)
        binding.viewColor.animate().scaleX(1.1f).scaleY(1.1f).setDuration(150).withEndAction {
            binding.viewColor.animate().scaleX(1f).scaleY(1f).duration = 150
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer?.cancel()
        SoundManager.stopSound()
        _binding = null
    }
}
