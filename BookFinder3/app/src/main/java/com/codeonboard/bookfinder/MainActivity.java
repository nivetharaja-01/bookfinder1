package com.codeonboard.bookfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    EditText email, password;
    TextView signup;
    Button login;
    private Object String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            email = findViewById(R.id.email);
            password = findViewById(R.id.password);

            login = findViewById(R.id.login);
            signup = findViewById(R.id.signup);


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String emailInput = email.getText().toString();
                    String passwordInput = password.getText().toString();
                    String emailRegex = "([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";


                    if (emailInput.equals("")) {
                        Toast.makeText(MainActivity.this, "enter your email id", Toast.LENGTH_LONG).show();
                    } else if (!emailInput.matches(emailRegex)) {
                        Toast.makeText(MainActivity.this, " your email ID is not proper", Toast.LENGTH_LONG).show();
                    } else if (passwordInput.equals("")) {
                        Toast.makeText(MainActivity.this, "ENTER YOUR PASSWORD", Toast.LENGTH_LONG).show();
                    } else if (passwordInput.length() < 7) {
                        Toast.makeText(MainActivity.this, "Your password should exceed 7 letters", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this,"all correct",Toast.LENGTH_LONG).show();
                    }


                }
            });





    }
}