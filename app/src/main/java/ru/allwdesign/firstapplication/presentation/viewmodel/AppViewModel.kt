package ru.allwdesign.firstapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import ru.allwdesign.firstapplication.domain.model.AppData
import ru.allwdesign.firstapplication.domain.model.AppDataSource

class AppViewModel : ViewModel() {

    // Единый источник данных для экранов
    val apps: List<AppData> = AppDataSource.apps

    // Поиск приложения по ID
    fun getAppById(appId: Int): AppData? {
        return apps.find { it.id == appId }
    }
}