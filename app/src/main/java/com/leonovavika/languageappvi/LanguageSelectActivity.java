package com.leonovavika.languageappvi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class LanguageSelectActivity extends AppCompatActivity implements View.OnClickListener{

    private Button[] buttons;
    private int[] buttonIds = {R.id.but_rus, R.id.but_eng, R.id.but_chin, R.id.but_bel, R.id.but_kaz, R.id.but_choose};
    private int[] buttonColors = {R.color.orange, R.color.bg_buttons, R.color.bg_buttons, R.color.bg_buttons, R.color.bg_buttons, R.color.bg_buttons};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_language_select);

        buttons = new Button[buttonIds.length];
        for (int i = 0; i < buttonIds.length; i++) {
            buttons[i] = findViewById(buttonIds[i]);
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        int selectedColor = getResources().getColor(R.color.orange); // Цвет выбранной кнопки
        int defaultColor = getResources().getColor(R.color.bg_buttons); // Цвет остальных кнопок

        // Сброс всех кнопок к цвету по умолчанию
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundColor(defaultColor);
        }

        // Установка выбранной кнопке цвета selectedColor
        for (int i = 0; i < buttonIds.length; i++) {
            if (v.getId() == buttonIds[i]) {
                buttons[i].setBackgroundColor(selectedColor);
                if (v.getId() == R.id.but_choose) {
                    Intent intent = new Intent(LanguageSelectActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            }
        }
    }
}
