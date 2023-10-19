package com.example.provappdm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SessionActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sessao);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(SessionActivity.this);
        SharedPreferences.Editor edit = pref.edit();

        Button btnSubmit = findViewById(R.id.submitSession);
        EditText userTxt = findViewById(R.id.userTxt);
        EditText passwordTxt=findViewById(R.id.passwordTxt);

        if(!pref.getString("KEY_USER", "").equals("") || !pref.getString("KEY_PASSWORD", "").equals("")){
            startActivity(new Intent(SessionActivity.this, MainActivity.class));
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(userTxt.getText().toString().isEmpty()) {
                        userTxt.setError("User cannot be empty");
                    } else if (passwordTxt.getText().toString().isEmpty()) {
                        passwordTxt.setError("Password cannot be empty");
                    } else {
                        if (userTxt.getText().toString().equals("Administrador") && passwordTxt.getText().toString().equals("Administrador")
                                || userTxt.getText().toString().equals("Adm") && passwordTxt.getText().toString().equals("Adm123")
                                || userTxt.getText().toString().equals("Administrator") && passwordTxt.getText().toString().equals("Que3B1eng4ElT0r0")
                                || userTxt.getText().toString().equals("Root") && passwordTxt.getText().toString().equals("pr0m1uscu0")) {

                            edit.putString("KEY_USER", userTxt.getText().toString()).apply();
                            edit.putString("KEY_PASSWORD", passwordTxt.getText().toString()).apply();
                            startActivity(new Intent(SessionActivity.this, MainActivity.class));
                        } else {
                            Toast.makeText(SessionActivity.this, "Login error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        });
    }
}
