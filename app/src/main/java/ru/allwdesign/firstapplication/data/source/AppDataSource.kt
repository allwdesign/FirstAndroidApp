package ru.allwdesign.firstapplication.data.source

import ru.allwdesign.firstapplication.R
import ru.allwdesign.firstapplication.data.dto.AppDto

object AppDataSource {

    val apps = listOf(
        AppDto(
            id = 1,
            name = "Farm App",
            description = "Весёлая ферма",
            icon = R.drawable.farm_app_icon,
            category = "Игры"
        ),
        AppDto(
            id = 2,
            name = "Bar Mail",
            description = "Лучший почтовый сервис",
            icon = R.drawable.bar_mail,
            category = "Полезное"
        ),
        AppDto(
            id = 3,
            name = "Duck Hunt",
            description = "Новая версия игры",
            icon = R.drawable.duck_hunt_app_icon,
            category = "Игры"
        ),
        AppDto(
            id = 4,
            name = "Space adventures",
            description = "Играй и развивайся",
            icon = R.drawable.space_adventures,
            category = "Игры"
        ),
        AppDto(
            id = 5,
            name = "Cookbook",
            description = "Книга для записи рецептов",
            icon = R.drawable.cookbook,
            category = "Полезное"
        ),
        AppDto(
            id = 6,
            name = "Calculator",
            description = "Калькулятор",
            icon = R.drawable.calc,
            category = "Образование"
        ),
        AppDto(
            id = 7,
            name = "Sapper game",
            description = "Играй в сапера и выигрывай!",
            icon = R.drawable.sapper_game,
            category = "Игры"
        ),
        AppDto(
            id = 8,
            name = "Bar Maps",
            description = "В помощь путешественнику",
            icon = R.drawable.bar_maps,
            category = "Путешествия"
        ),
        AppDto(
            id = 9,
            name = "Phone Book",
            description = "Удобная телефонная книга",
            icon = R.drawable.phonebook,
            category = "Полезное"
        ),
        AppDto(
            id = 10,
            name = "Bar Navigator",
            description = "Ещё больше путешествий",
            icon = R.drawable.bar_nav,
            category = "Путешествия"
        )
    )
}