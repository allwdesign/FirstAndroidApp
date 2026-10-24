package ru.allwdesign.firstapplication.domain.model

import ru.allwdesign.firstapplication.R

object AppDataSource {

    val apps = listOf(
        AppData(
            id = 1,
            name = "Farm App",
            description = "Весёлая ферма",
            icon = R.drawable.farm_app_icon,
            category = "Игры"
        ),
        AppData(
            id = 2,
            name = "Bar Mail",
            description = "Лучший почтовый сервис",
            icon = R.drawable.bar_mail,
            category = "Полезное"
        ),
        AppData(
            id = 3,
            name = "Duck Hunt",
            description = "Новая версия игры",
            icon = R.drawable.duck_hunt_app_icon,
            category = "Игры"
        ),
        AppData(
            id = 4,
            name = "Space adventures",
            description = "Играй и развивайся",
            icon = R.drawable.space_adventures,
            category = "Игры"
        ),
        AppData(
            id = 5,
            name = "Cookbook",
            description = "Книга для записи рецептов",
            icon = R.drawable.cookbook,
            category = "Полезное"
        ),
        AppData(
            id = 6,
            name = "Calculator",
            description = "Калькулятор",
            icon = R.drawable.calc,
            category = "Образование"
        ),
        AppData(
            id = 7,
            name = "Sapper game",
            description = "Играй в сапера и выигрывай!",
            icon = R.drawable.sapper_game,
            category = "Игры"
        ),
        AppData(
            id = 8,
            name = "Bar Maps",
            description = "В помощь путешественнику",
            icon = R.drawable.bar_maps,
            category = "Путешествия"
        ),
        AppData(
            id = 9,
            name = "Phone Book",
            description = "Удобная телефонная книга",
            icon = R.drawable.phonebook,
            category = "Полезное"
        ),
        AppData(
            id = 10,
            name = "Bar Navigator",
            description = "Ещё больше путешествий",
            icon = R.drawable.bar_nav,
            category = "Путешествия"
        )
    )
}