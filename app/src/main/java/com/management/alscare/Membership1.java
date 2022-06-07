package com.management.alscare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.management.alscare.R;
import com.management.alscare.data.model.PatientInfo;

public class Membership1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership1);

        final EditText dateOfEarlySymptoms = findViewById(R.id.editText4);
        final EditText dateOfDiagnosis = findViewById(R.id.editText5);
        final RadioGroup rg1 = findViewById(R.id.radioGroup1);

        Intent intent = getIntent();
        PatientInfo pInfo = intent.getParcelableExtra("Patient");

        pInfo.setFirstSymptoms(dateOfEarlySymptoms.getText().toString());
        pInfo.setDateOfDiagnosis(dateOfDiagnosis.getText().toString());

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                pInfo.setTypeOfOnset(((RadioButton) findViewById(rg1.getCheckedRadioButtonId())).getText().toString());
            }
        });

        Button next = findViewById(R.id.button1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(Membership1.this, com.management.alscare.Membership3.class);
                intent.putExtra("Patient", pInfo);
                startActivity(intent);
                finish();
            }
        });

        Button back = findViewById(R.id.button7);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(Membership1.this, com.management.alscare.Membership.class);
                intent.putExtra("Patient", pInfo);
                startActivity(intent);
                finish();
            }
        });
    }
}
