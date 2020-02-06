package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button Login;
    private TextView Info;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.names);
        password = findViewById(R.id.pass);
        Login = findViewById(R.id.button);
        Info = findViewById(R.id.textView);
        Info.setText("Number of attempet remaining: 5");
        Login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                validate(name.getText().toString(), password.getText().toString());

            }
        });

    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("admin")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {
            counter--;
            Info.setText("Number of attempts remaining:" + String.valueOf(counter));
            if (counter == 0) {
                Login.setEnabled(false);
            }

        }
    }
}