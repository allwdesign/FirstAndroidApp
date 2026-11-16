package ru.allwdesign.firstapplication.domain.repository

import ru.allwdesign.firstapplication.domain.model.AppData

interface AppRepository {

    /*
     Retrofit performs network requests asynchronously.
     The Repository must also support asynchronous calling.
     */
    suspend fun getApps(): List<AppData>

    suspend fun getAppById(appId: Int): AppData?
}