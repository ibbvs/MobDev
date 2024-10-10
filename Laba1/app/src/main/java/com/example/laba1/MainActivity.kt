package com.example.laba1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laba1.ui.theme.Laba1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laba1Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    // Состояние, чтобы отслеживать, было ли нажатие на кнопку
    val isImageVisible = remember { mutableStateOf(false) }

    // Основное размещение с кнопкой и изображением
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Проверяем состояние и отображаем соответствующее содержимое
        if (isImageVisible.value) {
            // Устанавливаем изображение в качестве фона
            Image(
                painter = painterResource(id = R.drawable.i), // Замените на имя вашего изображения
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Text(text = "Hello, World!", color = Color.White, modifier = Modifier.align(Alignment.Center))
        } else {
            // Кнопка на весь экран
            StartButton(onClick = { isImageVisible.value = true })
        }
    }
}

@Composable
fun StartButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxSize() // Занимает всё пространство
            .padding(0.dp) // Убираем отступы
    ) {
        Text("Старт")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    Laba1Theme {
        MainScreen()
    }
}

