package ru.allwdesign.firstapplication.data.repository

import ru.allwdesign.firstapplication.data.mapper.toDomain
import ru.allwdesign.firstapplication.data.remote.AppApiService
import ru.allwdesign.firstapplication.domain.model.AppData
import ru.allwdesign.firstapplication.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val apiService: AppApiService
) : AppRepository {

    override suspend fun getApps(): List<AppData> {
        return apiService.getApps().toDomain()
    }

    override suspend fun getAppById(appId: Int): AppData? {
        return try {
            apiService.getAppById(appId).toDomain()
        } catch (e: retrofit2.HttpException) {
            if (e.code() == 404) null else throw e

        }
    }
}