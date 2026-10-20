package ru.allwdesign.firstapplication.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

// My design color
val BrandPrimary = Color(0xFFF57802)

// Чуть светлее primary — для фона контейнеров/карточек
val BrandPrimaryContainer = BrandPrimary.copy(alpha = 0.15f)

// Тёмный нейтральный — для текста и второстепенных иконок (почти чёрный, но мягче)
val BrandNeutral = Color(0xFF333333)

// Очень светлый серый — для границ, разделителей, неактивных полей
val BrandTertiary = Color(0xFFE8E8E8)

// Контрастный акцент (не из палитры primary, а отдельный цвет для важных второстепенных действий)
val BrandSecondary = Color(0xFF007AFF) // спокойный синий — классика для «Отмена», «Назад» и т.п.
