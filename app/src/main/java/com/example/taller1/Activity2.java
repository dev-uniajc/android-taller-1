package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private TextView txtWelcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtWelcomeMessage = (TextView) findViewById(R.id.txt_username);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String welcomeMessage = "Welcome, " + username + "!";
        txtWelcomeMessage.setText(welcomeMessage);
    }

    public void goToActivity3(View view) {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Opción bloqueada", Toast.LENGTH_LONG).show();
    }
}