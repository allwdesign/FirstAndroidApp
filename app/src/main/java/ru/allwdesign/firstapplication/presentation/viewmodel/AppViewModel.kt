package ru.allwdesign.firstapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.allwdesign.firstapplication.domain.model.AppData
import ru.allwdesign.firstapplication.domain.repository.AppRepository
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _apps = MutableStateFlow<List<AppData>>(emptyList())
    // Хранит список приложений
    val apps: StateFlow<List<AppData>> = _apps.asStateFlow()

    private val _selectedApp = MutableStateFlow<AppData?>(null)
    // Хранит выбранное приложение
    val selectedApp: StateFlow<AppData?> = _selectedApp.asStateFlow()

    // Состояние загрузки
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadApps()
    }

    // Загрузка каталога приложений
    fun loadApps() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                _apps.value = repository.getApps()
            } catch (e: Exception) {
                _error.value = e.message ?: "Ошибка загрузки каталога"
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Загрузка приложения по ID
    fun loadAppById(appId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                _selectedApp.value = repository.getAppById(appId)

                if (_selectedApp.value == null) {
                    _error.value = "Приложение не найдено"
                }
            } catch (e: Exception) {
                _error.value = e.message ?: "Ошибка загрузки приложения"
            } finally {
                _isLoading.value = false
            }
        }
    }
}