package com.dacs.simondiceapp.util

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Build
import android.util.Log

object SoundManager {
    private var soundPool: SoundPool? = null
    private val soundMap = mutableMapOf<Int, Int>()

    // Múltiples MediaPlayers, para muchos sonidos
    private val mediaPlayers = mutableMapOf<String, MediaPlayer>()

    init {
        initializeSoundPool()
    }

    private fun initializeSoundPool() {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(3)
            .setAudioAttributes(audioAttributes)
            .build()
    }

    fun loadSounds(context: Context, vararg soundResources: Int) {
        soundResources.forEach { resId ->
            soundMap[resId] = soundPool?.load(context, resId, 1) ?: -1
        }
    }

    fun playSoundEffect(soundRes: Int) {
        soundPool?.play(soundMap[soundRes] ?: -1, 1f, 1f, 1, 0, 1f)
    }

    fun playMusic(context: Context, key: String, musicRes: Int, loop: Boolean = true) {
        try {
            // Si ya hay un MediaPlayer con esa clave, lo detenemos
            mediaPlayers[key]?.release()

            val player = MediaPlayer.create(context, musicRes).apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build()
                )
                isLooping = loop
                setVolume(1f, 1f)
                start()
            }

            mediaPlayers[key] = player
        } catch (e: Exception) {
            Log.e("SoundManager", "Error playing music [$key]: ${e.message}")
        }
    }

    fun stopMusic(key: String) {
        mediaPlayers[key]?.let {
            if (it.isPlaying) it.stop()
            it.release()
        }
        mediaPlayers.remove(key)
    }

    fun stopAllMusic() {
        mediaPlayers.values.forEach { player ->
            if (player.isPlaying) player.stop()
            player.release()
        }
        mediaPlayers.clear()
    }

    fun release() {
        soundPool?.release()
        soundPool = null
        soundMap.clear()
        stopAllMusic()
    }
}
