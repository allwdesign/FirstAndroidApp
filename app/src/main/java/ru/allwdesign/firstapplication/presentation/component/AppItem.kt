package ru.allwdesign.firstapplication.presentation.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.allwdesign.firstapplication.R
import ru.allwdesign.firstapplication.domain.model.AppData
import ru.allwdesign.firstapplication.ui.theme.FirstApplicationTheme


@Composable
fun AppItem(
    app: AppData,
    onItemClick: (AppData) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                Log.d("AppItemClick", "Клик по приложению: ${app.name}")
                onItemClick(app) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Иконка приложения
        Image(
            painter = painterResource(id = app.icon),
            contentDescription = app.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Название и описание
        Column(
            modifier = Modifier
                .heightIn(min = 80.dp), // heightIn задаёт минимальную высоту
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = app.name,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = app.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Категория
            Text(
                text = app.category,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppItemPreview() {
    FirstApplicationTheme {
        AppItem(
            app = AppData(
                name = "Farm App",
                description = "Весёлая ферма с кучей животных и растений.",
                icon = R.drawable.farm_app_icon,
                category = "Игры"
            ),
            onItemClick = {}
        )
    }
}