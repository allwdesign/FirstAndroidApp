package ru.allwdesign.firstapplication.data.repository

import ru.allwdesign.firstapplication.data.mapper.toDomain
import ru.allwdesign.firstapplication.data.source.AppDataSource
import ru.allwdesign.firstapplication.domain.model.AppData
import ru.allwdesign.firstapplication.domain.repository.AppRepository

class AppRepositoryImpl : AppRepository {

    override fun getApps(): List<AppData> {
        return AppDataSource.apps.toDomain()
    }

    override fun getAppById(appId: Int): AppData? {
        return AppDataSource.apps
            .find { it.id == appId }
            ?.toDomain()
    }
}