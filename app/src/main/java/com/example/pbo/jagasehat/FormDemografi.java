package com.example.pbo.jagasehat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class FormDemografi extends AppCompatActivity {
    Button submitBtn;
    EditText namaLengkap,usia,pekerjaan,emailLengkap;
    Spinner spinnerPendidikan,spinnerJK,spinnerPekerjaan;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("user");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_demografi);
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        // Write a message to the database
        spinnerPekerjaan = (Spinner) findViewById(R.id.pekerjaan_spinner);
        spinnerPendidikan = (Spinner) findViewById(R.id.pendidikan_spinner);
        spinnerJK = (Spinner) findViewById(R.id.jenis_kelamin_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterPen = ArrayAdapter.createFromResource(this,
                R.array.pendidikan_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterPen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerPendidikan.setAdapter(adapterPen);
        ArrayAdapter<CharSequence> adapterJK = ArrayAdapter.createFromResource(this,
                R.array.jenis_kelamin_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterJK.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerJK.setAdapter(adapterJK);
        ArrayAdapter<CharSequence> adapterPekerjaan = ArrayAdapter.createFromResource(this,
                R.array.pekerjaan_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterPekerjaan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerPekerjaan.setAdapter(adapterPekerjaan);

        //Mendapatkan Value untuk inputan
        namaLengkap = (EditText) findViewById(R.id.nama_lengkap);
        usia = (EditText) findViewById(R.id.usia);
        emailLengkap = (EditText) findViewById(R.id.email);
        submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String namaLengkapValue = namaLengkap.getText().toString();
                final String usiaValue = usia.getText().toString();
                final String pekerjaanValue = String.valueOf(spinnerPekerjaan.getSelectedItem());
                final String emailLengkapValue = emailLengkap.getText().toString();
                final String pendidikanValue = String.valueOf(spinnerPendidikan.getSelectedItem());
                final String jkValue = String.valueOf(spinnerJK.getSelectedItem());
                final String dateValue = getDate();
//                Toast.makeText(FormDemografi.this, "Nama: "+namaLengkapValue+"\nusia: " +
//                                ""+usiaValue+"\npekerjaan: "+pekerjaanValue+"\nemail: "+emailLengkapValue,
//                        Toast
//                        .LENGTH_SHORT).show();
//                Toast.makeText(FormDemografi.this, "Yang Di Pilih: "+String.valueOf(spinnerPendidikan
//                                .getSelectedItem()+" Jenis Kelamin: "+String.valueOf(spinnerJK.getSelectedItem())),
//                        Toast
//                        .LENGTH_SHORT)
//                        .show();
                writeNewUser(namaLengkapValue,usiaValue,jkValue,pendidikanValue,pekerjaanValue,
                        emailLengkapValue,dateValue);
                startActivity(new Intent(FormDemografi.this,CostumDialog.class));
                finish();
            }
        });
    }
    private void writeNewUser(String nama, String usia, String jk, String pendidikan,String
            pekerjaan, String email,String date) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        String key = myRef.push().getKey();
        User userData = new User(key,nama,usia,jk,pendidikan,pekerjaan,email,date);
        myRef.child(key).setValue(userData);
//        Map<String, Object> postValues = userData.toMap();
//
//        Map<String, Object> childUpdates = new HashMap<>();
//        childUpdates.put("/posts/" + key, postValues);
//        childUpdates.put("/user-posts/" + key + "/" + key, postValues);
//
//        myRef.updateChildren(childUpdates);
    }
    private String getDate(){
        DateFormat df = new SimpleDateFormat("EEE, d MM yyyy h:mm a");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }
}
