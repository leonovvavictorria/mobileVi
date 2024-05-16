package com.leonovavika.languageappvi;

import static com.leonovavika.languageappvi.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layout.activity_main);
        EdgeToEdge.enable(this); // Переместили сюда

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, OnboardingOneActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}

