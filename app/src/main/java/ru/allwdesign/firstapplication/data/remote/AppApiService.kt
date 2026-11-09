package ru.allwdesign.firstapplication.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import ru.allwdesign.firstapplication.data.dto.AppDto

interface AppApiService {

    @GET("catalog")
    suspend fun getApps(): List<AppDto>

    @GET("catalog/{id}")
    suspend fun getAppById(
        @Path("id") id: Int
    ): AppDto
}