package com.dacs.simondiceapp.data

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("user_settings", Context.MODE_PRIVATE)

    // Métodos para gestionar el volumen
    fun setVolumeEnabled(enabled: Boolean) {
        prefs.edit().putBoolean("volume", enabled).apply()
    }

    fun isVolumeEnabled(): Boolean {
        return prefs.getBoolean("volume", true)
    }

    // Métodos para gestionar el puntaje más alto
    fun saveHighScore(score: Int) {
        val currentHighScore = prefs.getInt("high_score", 0)
        if (score > currentHighScore) {
            prefs.edit().putInt("high_score", score).apply()
        }
    }

    fun getHighScore(): Int {
        return prefs.getInt("high_score", 0)
    }
}
