/**
 * Code based on:
 * URL 1: https://blog.usejournal.com/firebase-email-and-password-authentication-for-android-e335c81a1dad
 * URL 2: https://github.com/buildbro/FirebaseEmailPasswordExample
 */

package com.ruthiandchana.travelproject2.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ruthiandchana.travelproject2.R;

public class MainEnterance extends AppCompatActivity {

    Button registerBtn, loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_enterance);

        initializeViews();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainEnterance.this, Register.class);
                startActivity(intent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainEnterance.this, Login.class);
                startActivity(intent);
            }
        });
    }

    private void initializeViews() {
        registerBtn = findViewById(R.id.register);
        loginBtn = findViewById(R.id.login);
    }
}
