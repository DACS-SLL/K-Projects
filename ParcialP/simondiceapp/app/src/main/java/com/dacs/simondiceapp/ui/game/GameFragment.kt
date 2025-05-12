package com.dacs.simondiceapp.ui.game

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.NavOptions
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dacs.simondiceapp.R
import com.dacs.simondiceapp.databinding.FragmentGameBinding
import com.dacs.simondiceapp.data.PreferencesManager
import com.dacs.simondiceapp.util.SoundManager

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    // Modelo para colores
    data class ColorOption(val colorRes: Int, val name: String)

    // Configuración de niveles
    private val nivel1Colores = listOf(
        ColorOption(R.color.red, "Rojo"),
        ColorOption(R.color.green, "Verde"),
        ColorOption(R.color.blue, "Azul"),
        ColorOption(R.color.yellow, "Amarillo")
    )

    private val nivel2Colores = nivel1Colores + listOf(
        ColorOption(R.color.orange, "Naranja"),
        ColorOption(R.color.purple, "Morado")
    )

    private val nivel3Colores = nivel2Colores

    // Estado del juego
    private lateinit var currentColor: ColorOption
    private lateinit var colorButtons: Map<String, Button>
    private var score = 0
    private var timeLeft = 30
    private var timer: CountDownTimer? = null
    private lateinit var preferencesManager: PreferencesManager

    //Opciones para animar la navegacion
    val navOptions = NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right)
        .build()

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        preferencesManager = PreferencesManager(requireContext())
        // Cargar sonidos
        SoundManager.loadSounds(
            requireContext(),
            R.raw.correct,
            R.raw.wrong)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeButtons()
        setupInitialButtons()
        SoundManager.playMusic(requireContext(), key = "back", musicRes = R.raw.timer_music, loop = false)
        startNewGame()
    }

    private fun setupInitialButtons() {
        // Todos los botones visibles para el nivel 1 inicialmente
        val initialColors = getColorsForLevel(1)
        initialColors.forEach { colorOption ->
            colorButtons[colorOption.name]?.let { button ->
                button.setOnClickListener {
                    animarPush(it)
                    validateAnswer(colorOption.name)
                }
            }
        }
    }

    private fun initializeButtons() {
        colorButtons = mapOf(
            "Rojo" to binding.btnRojo,
            "Azul" to binding.btnAzul,
            "Verde" to binding.btnVerde,
            "Amarillo" to binding.btnAmarillo,
            "Naranja" to binding.btnNaranja,
            "Morado" to binding.btnMorado
        )
    }

    private fun startNewGame() {
        resetGameState()
        updateUI()
        startTimer()
        generateNewColor()
    }

    private fun resetGameState() {
        score = 0
        timeLeft = 30
        timer?.cancel()
    }

    private fun updateUI() {
        binding.tvScore.text = getString(R.string.game_score_label, score)
        binding.tvTime.text = getString(R.string.game_time_label, timeLeft)
    }

    private fun startTimer() {
        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000).toInt()
                binding.tvTime.text = getString(R.string.game_time_label, timeLeft)
            }

            override fun onFinish() {
                endGame()
            }
        }.start()
    }

    private fun endGame() {
        SoundManager.release()
        saveHighScore()
        navigateToResult()
    }

    private fun saveHighScore() {
        preferencesManager.saveHighScore(score)
    }

    private fun navigateToResult() {
        val action = GameFragmentDirections.actionGameToResult(score)
        findNavController().navigate(action)
    }

    private fun setupButtonsForCurrentLevel() {
        val currentLevel = getCurrentLevel()
        val availableColors = getColorsForLevel(currentLevel)

        // Listeners para todos los botones primero
        colorButtons.forEach { (colorName, button) ->
            button.setOnClickListener {
                animarPush(it)
                validateAnswer(colorName)
            }

            // Actualizar visibilidad
            button.visibility = if (availableColors.any { it.name == colorName }) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    private fun getCurrentLevel(): Int = when {
        score >= 20 -> 3
        score >= 10 -> 2
        else -> 1
    }

    private fun getColorsForLevel(level: Int): List<ColorOption> = when (level) {
        3 -> nivel3Colores
        2 -> nivel2Colores
        else -> nivel1Colores
    }

    private fun animateBtnColor(nombreColor: String) {
        val anim = android.view.animation.AnimationUtils.loadAnimation(requireContext(), R.anim.blink)
        colorButtons[nombreColor]?.startAnimation(anim)
    }

    private fun animarPush(view: View) {
        val scaleAnim = android.view.animation.AnimationUtils.loadAnimation(requireContext(), R.anim.scaleup)
        view.startAnimation(scaleAnim)
    }

    private fun generateNewColor(): ColorOption {
        val level = getCurrentLevel()
        val colorOptions = getColorsForLevel(level)
        currentColor = colorOptions.random()
        showColorToUser()
        return currentColor
    }

    private fun showColorToUser() {
        binding.viewColor.setBackgroundResource(currentColor.colorRes)

        // Stroop effect para level 3
        if (getCurrentLevel() == 3) {
            val textColor = nivel3Colores.random()
            binding.tvColorNombre.apply {
                text = currentColor.name
                setTextColor(ContextCompat.getColor(requireContext(), textColor.colorRes))
                visibility = View.VISIBLE
            }
        } else {
            binding.tvColorNombre.visibility = View.GONE
        }
        animateBtnColor(currentColor.name)

    }

    private fun validateAnswer(selectedColor: String) {
        val isCorrect = selectedColor == currentColor.name
        playSoundEffect(isCorrect)
        updateScore(isCorrect)
        generateNewColor()
    }

    private fun playSoundEffect(isCorrect: Boolean) {
        if (isCorrect) SoundManager.playMusic(requireContext(), key = "correct", musicRes = R.raw.correct, loop = false)
        else SoundManager.playMusic(requireContext(), key = "wrong", musicRes = R.raw.wrong, loop = false)
    }

    private fun updateScore(isCorrect: Boolean) {
        if (isCorrect) score++
        binding.tvScore.text = getString(R.string.game_score_label, score)
        setupButtonsForCurrentLevel() // Actualizar botones por nivel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        SoundManager.release()
        _binding = null
    }
}