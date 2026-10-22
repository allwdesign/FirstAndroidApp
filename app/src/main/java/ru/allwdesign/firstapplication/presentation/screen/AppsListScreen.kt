package ru.allwdesign.firstapplication.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.allwdesign.firstapplication.R
import ru.allwdesign.firstapplication.domain.model.AppData
import ru.allwdesign.firstapplication.presentation.component.AppItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppsListScreen(
    onAppClick: (AppData) -> Unit
) {


    // Список приложений
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
        ),
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Список приложений",
                        style = MaterialTheme.typography.headlineLarge
                    )
                },

                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.baseline_area_chart_24
                            ),
                            contentDescription = "Список приложений",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(10.dp), // единый отступ для контента
            verticalArrangement = Arrangement.spacedBy(8.dp) // единый отступ между элементами
        ) {

            items(apps) { app ->
                AppItem(
                    app = app,
                    onItemClick = { onAppClick(app) },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

