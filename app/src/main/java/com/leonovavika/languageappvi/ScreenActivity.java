package com.leonovavika.languageappvi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class ScreenActivity extends AppCompatActivity {

    private EditText answerGuess;
    private Button fly, gardener, flower, dog, checkWord;
    public String wordPracAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_screen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goProfile(View v) {
        startActivity(new Intent(ScreenActivity.this, ProfileActivity.class));
        finish();
    }

    public void guess(View v) {
        setContentView(R.layout.activity_guess);
    }

    @SuppressLint("MissingInflatedId")
    public void checkAnswer(View v) {
        answerGuess = findViewById(R.id.answer);
        String answer = answerGuess.getText().toString().toLowerCase();
        setContentView(answer.equals("raccoon") ? R.layout.activity_guess_true : R.layout.activity_guess_false);
    }

    public void tryAgain(View v) {
        setContentView(R.layout.activity_guess);
    }

    public void getBack(View v) {
        setContentView(R.layout.activity_screen);
    }

    public void wordPractice(View v) {
        setContentView(R.layout.activity_word_practice_one);
    }

    public void game(View v) {
        Toast.makeText(getApplicationContext(), "Game is currently in development!", Toast.LENGTH_SHORT).show();
    }

    public void chooseAnswerWordPractice(View v) {
        setColorAndAnswer(v);
    }

    @SuppressLint("SetTextI18n")
    public void checkAnswerWordPractice(View v) {
        checkWord = findViewById(R.id.button_check_word);
        if (String.valueOf(checkWord.getText()).contains("Check")) {
            Button[] buttons = {fly, gardener, flower, dog};
            for (Button button : buttons) {
                if (wordPracAnswer.equalsIgnoreCase(button.getText().toString())) {
                    button.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    button.setBackgroundColor(getResources().getColor(R.color.bg_but));
                }
            }
            checkWord.setText("Next");
        } else {
            setContentView(R.layout.activity_screen);
        }
    }

    public void audioPractice(View v) {
        setContentView(R.layout.activity_listening_one);
    }

    @SuppressLint("NonConstantResourceId")
    private void setColorAndAnswer(View v) {
        fly = findViewById(R.id.button_fly);
        gardener = findViewById(R.id.button_gardener);
        flower = findViewById(R.id.button_flower);
        dog = findViewById(R.id.button_dog);

        fly.setBackgroundColor(getResources().getColor(R.color.bg_but));
        gardener.setBackgroundColor(getResources().getColor(R.color.bg_but));
        flower.setBackgroundColor(getResources().getColor(R.color.bg_but));
        dog.setBackgroundColor(getResources().getColor(R.color.bg_but));

        // Устанавливаем цвет выбранной кнопки и сохраняем выбранный ответ
        if (v.getId() == R.id.button_fly) {
            fly.setBackgroundColor(getResources().getColor(R.color.bg_button));
            wordPracAnswer = String.valueOf(fly.getText());
        } else if (v.getId() == R.id.button_gardener) {
            gardener.setBackgroundColor(getResources().getColor(R.color.bg_button));
            wordPracAnswer = String.valueOf(gardener.getText());
        } else if (v.getId() == R.id.button_flower) {
            flower.setBackgroundColor(getResources().getColor(R.color.bg_button));
            wordPracAnswer = String.valueOf(flower.getText());
        } else if (v.getId() == R.id.button_dog) {
            dog.setBackgroundColor(getResources().getColor(R.color.bg_button));
            wordPracAnswer = String.valueOf(dog.getText());
        }

    }
}

