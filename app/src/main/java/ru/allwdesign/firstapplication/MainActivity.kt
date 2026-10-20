package ru.allwdesign.firstapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import ru.allwdesign.firstapplication.ui.theme.FirstApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // Настраиваем цвет системных значков
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)

        // false = белые значки статус-бара
        windowInsetsController.isAppearanceLightStatusBars = false

        // false = белые значки навигационной панели
        windowInsetsController.isAppearanceLightNavigationBars = false

        setContent {
            FirstApplicationTheme {
                AppsListScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppsListScreen() {

    // Список приложений
    val apps = listOf(
        AppData(
            name = "Farm App",
            description = "Весёлая ферма",
            icon = R.drawable.farm_app_icon,
            category = "Игры"

        ),
        AppData(
            name = "Bar Mail",
            description = "Лучший почтовый сервис",
            icon = R.drawable.bar_mail,
            category = "Полезное"
        ),
        AppData(
            name = "Duck Hunt",
            description = "Новая версия игры",
            icon = R.drawable.duck_hunt_app_icon,
            category = "Игры"
        ),
        AppData(
            name = "Space adventures",
            description = "Играй и развивайся",
            icon = R.drawable.space_adventures,
            category = "Игры"
        ),
        AppData(
            name = "Cookbook",
            description = "Книга для записи рецептов",
            icon = R.drawable.cookbook,
            category = "Полезное"
        ),
        AppData(
            name = "Calculator",
            description = "Калькулятор",
            icon = R.drawable.calc,
            category = "Образование"
        ),
        AppData(
            name = "Sapper game",
            description = "Играй в сапера и выигрывай!",
            icon = R.drawable.sapper_game,
            category = "Игры"
        ),
        AppData(
            name = "Bar Maps",
            description = "В помощь путешественнику",
            icon = R.drawable.bar_maps,
            category = "Путешествия"
        ),
        AppData(
            name = "Phone Book",
            description = "Удобная телефонная книга",
            icon = R.drawable.phonebook,
            category = "Полезное"
        ),
        AppData(
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
                .padding(horizontal = 16.dp)
                .padding(innerPadding)
        ) {

            items(apps) { app ->
                AppItem(
                    name = app.name,
                    description = app.description,
                    icon = app.icon,
                    category = app.category,
                    modifier = Modifier.padding(vertical = 8.dp) // единый отступ
                )
            }
        }
    }
}

// Модель данных приложения
data class AppData(
    val name: String,
    val description: String,
    val icon: Int,
    val category: String
)

@Composable
fun AppItem(
    name: String,
    description: String,
    icon: Int,
    category: String,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier.fillMaxWidth()) {

        // Иконка приложения
        Image(
            painter = painterResource(id = icon),
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Название и описание
        Column(modifier = Modifier.height(80.dp)) {

            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Категория
            Text(
                text = category,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun MainScreenPreview() {
    FirstApplicationTheme {
        AppsListScreen()
    }
}

@Preview(
    name = "Dark Theme",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true,
    showBackground = true
)
@Composable
fun MyScreenPreviewDark() {
    FirstApplicationTheme {
        AppsListScreen()
    }
}
