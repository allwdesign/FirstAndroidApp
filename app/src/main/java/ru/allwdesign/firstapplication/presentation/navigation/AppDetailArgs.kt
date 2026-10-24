package ru.allwdesign.firstapplication.presentation.navigation

import android.os.Bundle

data class AppDetailArgs(val appId: Int) {
    companion object {
        private const val KEY_APP_ID = "appId"

        fun fromBundle(bundle: Bundle): AppDetailArgs {
            val appId = bundle.getInt(KEY_APP_ID)
            return AppDetailArgs(appId = appId)
        }
    }

    fun toBundle(): Bundle {
        return Bundle().apply {
            putInt(KEY_APP_ID, appId)
        }
    }
}
