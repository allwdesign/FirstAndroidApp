package ru.allwdesign.firstapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.allwdesign.firstapplication.domain.model.AppDataSource
import ru.allwdesign.firstapplication.presentation.screen.AppDetailScreen
import ru.allwdesign.firstapplication.presentation.screen.AppsListScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    val apps = AppDataSource.apps

    NavHost(
        navController = navController,
        startDestination = Routes.LIST_ROUTE
    ) {
        // ЭКРАН СПИСКА
        composable(route = Routes.LIST_ROUTE) {
            AppsListScreen(
                onAppClick = { app ->
                    // Передаём appId через маршрут
                    navController.navigate(
                        "${Routes.DETAIL_ROUTE}/${app.id}"
                    )
                }
            )
        }

        // ЭКРАН ДЕТАЛЕЙ
        composable(
            route = "${Routes.DETAIL_ROUTE}/{appId}",
            arguments = listOf(
                navArgument("appId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            // Получаем appId с проверкой типа
            val appId = requireNotNull(
                backStackEntry.arguments?.getInt("appId")
            ) {
                "Missing appId argument"
            }

            AppDetailScreen(
                appId = appId,
                apps = apps,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}