package com.dacs.simondiceapp.data

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("user_settings", Context.MODE_PRIVATE)

    fun setVolumeEnabled(enabled: Boolean) {
        prefs.edit().putBoolean("volume", enabled).apply()
    }

    fun isVolumeEnabled(): Boolean {
        return prefs.getBoolean("volume", true)
    }
}
