package com.leonovavika.languageappvi;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Активити для настроек приложения
public class ProfileActivity extends AppCompatActivity {

    private Button butSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    // Метод для инициализации кнопки переключения темы и установки текста
    @SuppressLint("SetTextI18n")
    private void initThemeSwitchButton() {
        butSwitch = findViewById(R.id.but_switch);
        // Проверяем, включена ли темная тема, и устанавливаем соответствующий текст кнопки
        if (isDarkModeEnabled()) {
            butSwitch.setText("Switch to Light");
        } else {
            butSwitch.setText("Switch to Dark");
        }
    }
         // Метод для проверки, включена ли темная тема
        private boolean isDarkModeEnabled() {
            return AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
        }

        // Метод для переключения между светлой и темной темой
        public void switchToDark(View v) {
            int currentNightMode = AppCompatDelegate.getDefaultNightMode();
            if (currentNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            initThemeSwitchButton();
        }


    // Метод для перехода к выбору языка
    public void changeYourMotherLanguage(View v){
        Intent intent = new Intent(ProfileActivity.this, LanguageSelectActivity.class);
        startActivity(intent);
        finish();
    }

    // Метод для перехода к выбору фото
    public void choosephoto(View v){
        setContentView(R.layout.activity_profile_photo   );
    }

    // Метод для выхода из аккаунта
    public void logOut(View v){
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


    // Метод для возврата к настройкам
    public void backProfile(View v){
        setContentView(R.layout.activity_profile);
    }

    // Метод для перехода на главный экран
    public void backScreen(View v){
        Intent intent = new Intent(ProfileActivity .this, ScreenActivity.class);
        startActivity(intent);
        finish();
    }
}
