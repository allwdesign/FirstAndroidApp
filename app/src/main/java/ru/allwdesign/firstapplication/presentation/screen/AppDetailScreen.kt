package ru.allwdesign.firstapplication.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun AppDetailScreen(
    appId: Int
) {
    Text(
        text = "Экран детали приложения с ID: $appId",
        fontSize = 18.sp
    )
}
