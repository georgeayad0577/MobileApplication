package com.example.healthcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.healthcare.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textNewUser);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String Username= edUsername.getText().toString();
                String Password= edPassword.getText().toString();
                Database db = new Database(getApplicationContext(),"HealthCare",null,1);
                if(Username.length()==0 || Password.length()==0){
                    Toast.makeText(getApplicationContext(),"Please Fill All Details", Toast.LENGTH_SHORT).show();
                }else {
                    if (db.login(Username,Password)==1){
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",Username);
                        // to save our date with key and value.
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}