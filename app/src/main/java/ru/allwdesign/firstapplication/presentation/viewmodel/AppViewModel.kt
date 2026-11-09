package ru.allwdesign.firstapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.allwdesign.firstapplication.domain.model.AppData
import ru.allwdesign.firstapplication.domain.repository.AppRepository
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    // Единый источник данных(список приложений) для экранов
    val apps: List<AppData> = repository.getApps()

    // Поиск приложения по ID
    fun getAppById(appId: Int): AppData? {
        return apps.find { it.id == appId }
    }
}