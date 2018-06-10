package com.example.pbo.jagasehat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class FormDemografi extends AppCompatActivity {
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_demografi);
        final Spinner spinnerPendidikan = (Spinner) findViewById(R.id.pendidikan_spinner);
        final Spinner spinnerJK = (Spinner) findViewById(R.id.jenis_kelamin_spinner);
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
        submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(FormDemografi.this, "Yang Di Pilih: "+String.valueOf(spinnerPendidikan
//                                .getSelectedItem()+" Jenis Kelamin: "+String.valueOf(spinnerJK.getSelectedItem())),
//                        Toast
//                        .LENGTH_SHORT)
//                        .show();
                startActivity(new Intent(FormDemografi.this,MainActivity.class));
                finish();
            }
        });
    }
}
