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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    EditText name, email, password, cpassword, dob;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email2);
        password = findViewById(R.id.password2);
        cpassword = findViewById(R.id.cpassword);
        dob = findViewById(R.id.dob);

        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameinput = name.getText().toString();
                String emailinput = email.getText().toString();
                String passwordinput = password.getText().toString();
                String cpasswordinput = cpassword.getText().toString();
                String dobinput = dob.getText().toString();
                String emailRegex = "([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
                String dobRegex = "(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";


                if (nameinput.equals("")) {
                    Toast.makeText(SignIn.this, "Please enter your name", Toast.LENGTH_LONG).show();
                } else if (!emailinput.matches(emailRegex)) {
                    Toast.makeText(SignIn.this, " your email ID is not proper", Toast.LENGTH_LONG).show();
                } else if (emailinput.equals("")) {
                    Toast.makeText(SignIn.this, "please enter your email ID", Toast.LENGTH_LONG).show();
                } else if (passwordinput.equals("")) {
                    Toast.makeText(SignIn.this, "enter the password", Toast.LENGTH_LONG).show();
                } else if (passwordinput.length() < 7) {
                    Toast.makeText(SignIn.this, "your password should exceed 7 letters", Toast.LENGTH_LONG).show();
                } else if (cpasswordinput.equals("")) {
                    Toast.makeText(SignIn.this, "confirm the password", Toast.LENGTH_LONG).show();
                } else if (cpasswordinput.length() < 7) {
                    Toast.makeText(SignIn.this, "confirm password should exceed 7 letters", Toast.LENGTH_LONG).show();
                } else if (!passwordinput.equals(cpasswordinput)) {
                    Toast.makeText(SignIn.this, "your password and confirm password are not same", Toast.LENGTH_LONG).show();
                } else if (!dobinput.matches(dobRegex)) {
                    Toast.makeText(SignIn.this, "your date of birth is not in format", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SignIn.this,"all correct ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}