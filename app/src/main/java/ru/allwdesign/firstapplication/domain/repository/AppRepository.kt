package ru.allwdesign.firstapplication.domain.repository

import ru.allwdesign.firstapplication.domain.model.AppData

interface AppRepository {

    fun getApps(): List<AppData>

    fun getAppById(appId: Int): AppData?
}