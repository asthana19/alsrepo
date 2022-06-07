package com.management.alscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.management.alscare.data.model.PatientInfo;


public class Membership extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner1;
    private Spinner spinner2;
    private static final String[] states = {"Assam", "Arunachal Pradesh", "Bihar"};
    private static final String[] city = {"Dispur", "Tripura", "Lucknow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        final EditText fullnameEditText = findViewById(R.id.editText);
        final EditText ageEditText = findViewById(R.id.editText3);

        final RadioGroup rg1 = findViewById(R.id.radioGroup);

        spinner1 = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String>adapter1 = new ArrayAdapter<String>(Membership.this,
                android.R.layout.simple_spinner_item,states);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);


        spinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(Membership.this,
                android.R.layout.simple_spinner_item,city);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        PatientInfo pInfo = new PatientInfo();
        pInfo.setPatientName(fullnameEditText.getText().toString());
        pInfo.setPatientAge(Integer.parseInt(ageEditText.getText().toString()));

        rg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                pInfo.setGender(((RadioButton) findViewById(rg1.getCheckedRadioButtonId())).getText().toString());
            }
        });


        Button next = findViewById(R.id.button1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(Membership.this, com.management.alscare.Membership1.class);
                intent.putExtra("Patient", pInfo);
                startActivity(intent);
                finish();
            }
        });

        Button skip = findViewById(R.id.button);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(Membership.this, com.management.alscare.Main3Activity.class);
                intent.putExtra("Patient", pInfo);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
