package com.example.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsername;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recupera valores de los input y los asigna a variables
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
    }

    public void login(View view) {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (username.equals("admin") && password.equals("12")) {
            Toast.makeText(this, "Ingreso exitoso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("username", username);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Opción bloqueada", Toast.LENGTH_LONG).show();
    }
}