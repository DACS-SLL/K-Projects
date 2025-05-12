package com.dacs.simondiceapp.managers

import android.content.Context
import com.dacs.simondiceapp.data.PreferencesManager

// Este manager permite separar la lógica de acceso a SharedPreferences
// de la lógica de la app, lo que mejora la mantenibilidad del código.
class SettingsManager private constructor(context: Context) {

    private val preferencesManager = PreferencesManager(context)

    // Singleton companion
    companion object {
        @Volatile private var instance: SettingsManager? = null

        fun getInstance(context: Context): SettingsManager {
            return instance ?: synchronized(this) {
                instance ?: SettingsManager(context.applicationContext).also { instance = it }
            }
        }
    }

    // Funciones públicas
    fun isSoundEnabled(): Boolean {
        return preferencesManager.isVolumeEnabled()
    }

    fun setSoundEnabled(enabled: Boolean) {
        preferencesManager.setVolumeEnabled(enabled)
    }

    fun saveIfNewHighScore(score: Int) {
        preferencesManager.saveHighScore(score)
    }

    fun getHighScore(): Int {
        return preferencesManager.getHighScore()
    }
}
