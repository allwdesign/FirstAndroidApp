package ru.allwdesign.firstapplication.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

val LightColorScheme = lightColorScheme(
    primary = BrandPrimary,
    primaryContainer = BrandPrimaryContainer,
    onPrimary = Color.White,
    onPrimaryContainer = BrandNeutral,

    secondary = BrandSecondary,
    secondaryContainer = BrandSecondary.copy(alpha = 0.1f),
    onSecondary = Color.White,
    onSecondaryContainer = BrandNeutral,

    tertiary = BrandTertiary,
    tertiaryContainer = Color.White,
    onTertiary = BrandNeutral,
    onTertiaryContainer = BrandNeutral,

    background = Color.White,
    surface = Color.White,
    onBackground = BrandNeutral,
    onSurface = BrandNeutral
)

@Composable
fun FirstApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}