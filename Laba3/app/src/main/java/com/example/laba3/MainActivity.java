package com.example.laba3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация ImageView и TextView
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        // Устанавливаем текст-рассказ
        textView.setText(getString(R.string.story_text));
    }
}
