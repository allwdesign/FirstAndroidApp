package ru.allwdesign.firstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import ru.allwdesign.firstapplication.presentation.navigation.AppNavHost
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
                //AppsListScreen()
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}