package com.leonovavika.languageappvi;
import static android.text.TextUtils.isEmpty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText mail;
    private EditText pass;
    private EditText fName;
    private EditText lName;
    private EditText newMail;
    private EditText newPass;
    private EditText confirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();
    }

    private void initializeViews() {
        mail = findViewById(R.id.emailAddress);
        pass = findViewById(R.id.password);
    }


    public void signupStep(View v){
        fName = findViewById(R.id.fName);
        lName = findViewById(R.id.lName);
        newMail = findViewById(R.id.newMail);
        if((fName.getText().length()==0) || (lName.getText().length()==0) || (newMail.getText().length()==0))
        {
            Toast.makeText(getApplicationContext(),"There shouldn't be empty fields", Toast.LENGTH_SHORT).show();
        }
        else {
            setContentView(R.layout.activity_signup_two);
        }
    }


    public void back(View v){
        setContentView(R.layout.activity_signup_one);
    }


    public void login(View v) {
        EditText pass = findViewById(R.id.password);
        EditText mail = findViewById(R.id.emailAddress);
        if(isEmpty((CharSequence) pass) || isEmpty((CharSequence) mail)) {
            Toast.makeText(getApplicationContext(), "Fill in the empty fields!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(LoginActivity.this, ScreenActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void signup_final(View v){
        newPass = findViewById(R.id.password);
        confirmPass = findViewById(R.id.pass);

        if((newPass.getText().length()==0) || (confirmPass.getText().length()==0))
        {
            Toast.makeText(getApplicationContext(),"Fill in the blanks!", Toast.LENGTH_SHORT).show();
        } else if (newPass.getText().toString().contentEquals(confirmPass.getText().toString())) {
            Intent intent = new Intent(LoginActivity.this, ScreenActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(),"Password doesn't match!", Toast.LENGTH_SHORT).show();
        }
    }
}
