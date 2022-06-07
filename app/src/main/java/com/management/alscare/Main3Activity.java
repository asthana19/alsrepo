package com.management.alscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import static android.app.PendingIntent.getActivity;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);
            }
        });

        Button aboutALS = findViewById(R.id.button1);
        aboutALS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(Main3Activity.this, com.management.alscare.AboutAlsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button diet = findViewById(R.id.button2);
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(Main3Activity.this, com.management.alscare.DietNutritionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button pranayam = findViewById(R.id.button3);
        pranayam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(Main3Activity.this, com.management.alscare.PranayamExerciseActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button speech = findViewById(R.id.button4);
        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(Main3Activity.this, com.management.alscare.SpeechExerciseActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
