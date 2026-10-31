package ru.allwdesign.firstapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.allwdesign.firstapplication.presentation.screen.AppDetailScreen
import ru.allwdesign.firstapplication.presentation.screen.AppsListScreen
import ru.allwdesign.firstapplication.presentation.viewmodel.AppViewModel
import ru.allwdesign.firstapplication.presentation.viewmodel.AppViewModelFactory

@Composable
fun AppNavHost(
    navController: NavHostController,
    appViewModel: AppViewModel = viewModel(
        factory = AppViewModelFactory()
    )
) {
    NavHost(
        navController = navController,
        startDestination = Routes.LIST_ROUTE
    ) {
        // Экран списка приложений
        composable(route = Routes.LIST_ROUTE) {
            AppsListScreen(
                apps = appViewModel.apps,
                onAppClick = { app ->
                    // Передаём appId через маршрут
                    navController.navigate(
                        "${Routes.DETAIL_ROUTE}/${app.id}"
                    )
                }
            )
        }

        // Экран деталей приложения
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
                appViewModel = appViewModel,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}