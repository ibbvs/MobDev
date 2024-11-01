package com.example.laba4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button jokeButton = findViewById(R.id.button_joke);

        // Переход к JokeActivity при нажатии кнопки
        jokeButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, JokeActivity.class);
            startActivity(intent);
        });
    }
}