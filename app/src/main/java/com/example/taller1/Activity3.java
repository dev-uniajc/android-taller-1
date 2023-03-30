package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Activity3 extends AppCompatActivity {
    private Spinner spinner;
    ImageView imageView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        imageView = findViewById(R.id.imageView);

        // Define el spinner con valores del strings.xml
        String[] types = {"Seleccionar una opción", "Imagen 1", "Imagen 2", "Imagen 3"};
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, types);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("spinnerLog", "onItemSelected: " + types[i]);

                switch (i) {
                    case 1:
                        url = "https://i.blogs.es/09b647/googlefotos/1366_2000.jpg";
                        break;
                    case 2:
                        url = "https://i.pinimg.com/736x/e2/a9/aa/e2a9aa11df9d7d92325ebb2c3068d7e3.jpg";
                        break;
                    case 3:
                        url = "https://www.dzoom.org.es/wp-content/uploads/2010/08/fotografias-atardecer-sol-7-810x540.jpg";
                        break;
                }

                Picasso.get().load(url).into(imageView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void gotToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Opción bloqueada", Toast.LENGTH_LONG).show();
    }
}