package ru.allwdesign.firstapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import ru.allwdesign.firstapplication.ui.theme.FirstApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        onSendMessage = { text ->
                            val intent = Intent(this, SecondActivity::class.java)
                            intent.putExtra(SecondActivity.EXTRA_MESSAGE, text)
                            startActivity(intent)
                        })
                }
            }
        }
    }
}

@Composable
fun MainScreen(onSendMessage: (String) -> Unit) {
    var inputText by remember { mutableStateOf("") }
    var hasError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Отправка сообщения", style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = inputText,
            onValueChange = {
                inputText = it
                // Сбрасываем ошибку, как только пользователь начал печатать
                hasError = false
                errorMessage = null
            },
            label = { Text("Введите сообщение") },
            isError = hasError,
            supportingText = if (hasError) {
                errorMessage?.let { errMsg ->
                    {
                        Text(
                            text = errMsg, color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            } else null,
            modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Валидируем текст, при ошибке показываем пользователю текст ошибки
                when (val result = validateMessage(inputText)) {
                    is ValidationResult.Error -> {
                        hasError = true
                        errorMessage = result.message
                    }

                    ValidationResult.Success -> {
                        onSendMessage(inputText.trim())
                        inputText = ""
                    }
                }
            },
            // Кнопка ВСЕГДА активна
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Открыть вторую Activity")
        }
    }
}

@Preview(showBackground = true, name = "Light theme")
@Composable
fun MainScreenPreview() {
    FirstApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            MainScreen(onSendMessage = { text ->
                println("В превью отправлено: $text")
            })
        }
    }
}
