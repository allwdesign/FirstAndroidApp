package ru.allwdesign.firstapplication.data.mapper

import ru.allwdesign.firstapplication.data.dto.AppDto
import ru.allwdesign.firstapplication.domain.model.AppData

fun AppDto.toDomain(): AppData {
    return AppData(
        id = id,
        name = name,
        description = description,
        icon = icon,
        category = category
    )
}

fun List<AppDto>.toDomain(): List<AppData> {
    return map { it.toDomain() }
}