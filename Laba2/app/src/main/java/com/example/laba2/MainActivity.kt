package com.example.laba2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalConfiguration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val profileSize = screenWidth / 2

    var selectedBlock by remember { mutableStateOf<Block?>(null) }

    // Основной контейнер с фоном
    Box(modifier = Modifier.fillMaxSize()) {
        // Фоновое изображение
        Image(
            painter = painterResource(id = R.drawable.theme), // Замените на ваш ресурс
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Растягиваем изображение, чтобы заполнить весь экран
        )

        // Контент
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            // Фото профиля
            Image(
                painter = painterResource(id = R.drawable.i), // Замените на ваш ресурс
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(profileSize) // Фиксированный размер
                    .align(Alignment.CenterHorizontally) // Центрируем фото
            )

            // Персональные данные
            Column(
                modifier = Modifier.align(Alignment.Start)
            ) {
                Text("Имя: Александр Сабиров", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text("Возраст: 25 лет", fontSize = 16.sp)
                Text("Профиль: Разработчик", fontSize = 16.sp)
            }

            // Кнопки для отображения блоков
            Button(
                onClick = { selectedBlock = if (selectedBlock == Block.PHOTOS) null else Block.PHOTOS },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Фотографии")
            }
            Button(
                onClick = { selectedBlock = if (selectedBlock == Block.ACHIEVEMENTS) null else Block.ACHIEVEMENTS },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Достижения")
            }
            Button(
                onClick = { selectedBlock = if (selectedBlock == Block.PROJECTS) null else Block.PROJECTS },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Проекты")
            }

            // Отображение выбранного блока
            when (selectedBlock) {
                Block.PHOTOS -> PhotoBlock()
                Block.ACHIEVEMENTS -> AchievementsBlock()
                Block.PROJECTS -> ProjectsBlock()
                null -> {} // Ничего не отображаем
            }
        }
    }
}

enum class Block {
    PHOTOS,
    ACHIEVEMENTS,
    PROJECTS
}

@Composable
fun PhotoBlock() {
    val photos = listOf(
        R.drawable.i, // Замените на свои ресурсы
        R.drawable.i,
        R.drawable.i,
        R.drawable.i,
        R.drawable.i,
        R.drawable.i
    ) // Добавьте свои фотографии

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Блок с фотографиями", fontWeight = FontWeight.Bold)

        LazyVerticalGrid(
            columns = GridCells.Fixed(3), // 3 столбца
            contentPadding = PaddingValues(4.dp)
        ) {
            items(photos) { photo ->
                var expanded by remember { mutableStateOf(false) }

                Image(
                    painter = painterResource(id = photo),
                    contentDescription = "Photo",
                    modifier = Modifier
                        .padding(4.dp)
                        .size(if (expanded) 200.dp else 100.dp) // Увеличиваем размер при нажатии
                        .clickable { expanded = !expanded }
                )
            }
        }
    }
}

@Composable
fun AchievementsBlock() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Блок с достижениями", fontWeight = FontWeight.Bold)
        Text("1. Завершил курс по Android-разработке.", fontSize = 16.sp)
        Text("2. Разработал приложение для учета расходов.", fontSize = 16.sp)
        Text("3. Участвовал в хакатоне и занял 2 место.", fontSize = 16.sp)
    }
}

@Composable
fun ProjectsBlock() {
    val projects = listOf(
        Project("Приложение для трекинга фитнеса", R.drawable.i, "Написал приложение, которое позволяет отслеживать физическую активность пользователя."),
        Project("Приложение для изучения языков", R.drawable.i, "Участвовал в создании приложения для помощи в изучении новых языков."),
        Project("Веб-сайт для онлайн-курсов", R.drawable.i, "Разрабатывал платформу для онлайн-обучения.")
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Блок с проектами", fontWeight = FontWeight.Bold)

        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 2 столбца
            contentPadding = PaddingValues(4.dp)
        ) {
            items(projects) { project ->
                ProjectItem(project)
            }
        }
    }
}

@Composable
fun ProjectItem(project: Project) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(4.dp)) {
        Image(
            painter = painterResource(id = project.imageRes),
            contentDescription = project.name,
            modifier = Modifier
                .size(150.dp)
                .clickable { expanded = !expanded }
        )
        if (expanded) {
            Text(project.description, modifier = Modifier.padding(top = 4.dp))
        }
    }
}

data class Project(val name: String, val imageRes: Int, val description: String)
