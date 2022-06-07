package com.management.alscare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.management.alscare.data.model.PatientInfo;

public class Membership3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership3);

        final CheckBox cb1 = findViewById(R.id.checkBox1);
        final CheckBox cb2 = findViewById(R.id.checkBox2);
        final CheckBox cb3 = findViewById(R.id.checkBox3);
        final CheckBox cb4 = findViewById(R.id.checkBox4);

        String currentSymptoms = cb1.getText().toString() + cb2.getText().toString() + cb3.getText().toString() + cb4.getText().toString();

        Intent intent = getIntent();
        PatientInfo pInfo = intent.getParcelableExtra("Patient");

        pInfo.setCurrentCondition(currentSymptoms);


        Button next = findViewById(R.id.button1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(Membership3.this, Membership2.class);
                intent.putExtra("Patient", pInfo);
                startActivity(intent);
                finish();
            }
        });

        Button back = findViewById(R.id.button5);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(Membership3.this, Membership1.class);
                intent.putExtra("Patient", pInfo);
                startActivity(intent);
                finish();
            }
        });
    }
}
