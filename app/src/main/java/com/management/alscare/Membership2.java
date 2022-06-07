package com.management.alscare;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.management.alscare.data.model.PatientInfo;
import com.management.alscare.db.PatientDBHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Membership2 extends AppCompatActivity {

    PatientDBHelper patientDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership2);

        final RadioGroup rg1 = findViewById(R.id.radioGroup);
        final RadioGroup rg2 = findViewById(R.id.radioGroup2);


        Intent intent = getIntent();
        PatientInfo pInfo = intent.getParcelableExtra("Patient");

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                pInfo.setCaregiver(((RadioButton) findViewById(rg1.getCheckedRadioButtonId())).getText().toString());
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                pInfo.setMedico(((RadioButton) findViewById(rg2.getCheckedRadioButtonId())).getText().toString());
            }
        });


        // Write a message to the database
        // FirebaseDatabase database = FirebaseDatabase.getInstance("0");
        //DatabaseReference dbRef = database.getReference("alscare-default-rtdb");
        //DatabaseReference dbRef = database.getReference();

        //userRef.setValue("Hello, World!");
        //dbRef.child("patients").child(pInfo.getPatientId()).setValue(pInfo);
        //dbRef.child("patients").setValue(pInfo);
        //dbRef.setValue(pInfo);
        //System.out.println( "Patient Info " + pInfo.toString());

        patientDBHelper = new PatientDBHelper(this);
        patientDBHelper.insertPerson(pInfo.getPatientName(),pInfo.getGender(),pInfo.getPatientAge());
        Button next = findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                String fName = "Demo.txt"; //gives file name
                String Data = "Hello!!"; //define data
                String path = getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + fName;
                File file = new File(path);
                Log.i(" Path to file " , path);
                FileOutputStream fileobj = null;
                //if (!file.exists()) {
                try {
                    fileobj = getApplicationContext().openFileOutput(fName, MODE_APPEND);
                    byte[] ByteArray = Data.getBytes(); //Converts into bytes stream
                    fileobj.write(ByteArray); //writing to file
                    fileobj.close(); //File closed

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //}
                startActivity(new Intent(Membership2.this, com.management.alscare.Main3Activity.class));

                finish();
            }
        });

        Button back = findViewById(R.id.button6);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(Membership2.this, Membership3.class);
                intent.putExtra("Patient", pInfo);
                startActivity(intent);
                finish();
            }
        });
    }
}
