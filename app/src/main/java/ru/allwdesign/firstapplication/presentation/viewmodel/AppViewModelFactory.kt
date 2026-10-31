package ru.allwdesign.firstapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.allwdesign.firstapplication.data.repository.AppRepositoryImpl

class AppViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
            val repository = AppRepositoryImpl()

            @Suppress("UNCHECKED_CAST")
            return AppViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class: ${modelClass.name}"
        )
    }
}