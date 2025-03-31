package com.dacs.nweapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false
    private var currentSongIndex = 0

    // Lista de canciones en res/raw
    private val songs = listOf(
        R.raw.bad_liar,
        R.raw.meilleure
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI Elements
        val imgDemo = findViewById<ImageView>(R.id.imgDemo)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnStop = findViewById<Button>(R.id.btnStop)
        val btnNext = findViewById<Button>(R.id.btnNext)  // Nuevo botón para cambiar canción

        // Inicializar MediaPlayer con la primera canción
        mediaPlayer = MediaPlayer.create(this, songs[currentSongIndex])

        // Toast al hacer clic en la imagen
        imgDemo.setOnClickListener {
            Toast.makeText(this, "Miau Miau", Toast.LENGTH_SHORT).show()
        }

        // Reproducir audio
        btnPlay.setOnClickListener {
            if (mediaPlayer?.isPlaying == false) {
                mediaPlayer?.start()
                isPlaying = true
            }
        }

        // Pausar audio
        btnPause.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
                isPlaying = false
            }
        }

        // Detener audio
        btnStop.setOnClickListener {
            stopMusic()
        }

        // Cambiar a la siguiente canción
        btnNext.setOnClickListener {
            nextSong()
        }
    }

    private fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        isPlaying = false
    }

    private fun nextSong() {
        stopMusic()
        currentSongIndex = (currentSongIndex + 1) % songs.size  // Siguiente canción
        mediaPlayer = MediaPlayer.create(this, songs[currentSongIndex])
        mediaPlayer?.start()
        isPlaying = true
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()  // Libera recursos cuando la app se cierra
    }
}
