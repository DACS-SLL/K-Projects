package com.dacs.simondiceapp.util

import android.content.Context
import android.media.MediaPlayer

object SoundManager {
    private var mediaPlayer: MediaPlayer? = null

    /**
     * Reproduce un sonido desde raw y libera el recurso al finalizar
     */
    fun playSound(context: Context, resId: Int, onComplete: (() -> Unit)? = null) {
        stopSound()
        mediaPlayer = MediaPlayer.create(context, resId)
        mediaPlayer?.setOnCompletionListener {
            stopSound()
            onComplete?.invoke()
        }
        mediaPlayer?.start()
    }

    /**
     * Detiene y libera el sonido actual
     */
    fun stopSound() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
