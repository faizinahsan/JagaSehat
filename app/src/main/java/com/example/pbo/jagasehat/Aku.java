package com.example.pbo.jagasehat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Aku extends AppCompatActivity {
    Button saveText,editText;
    EditText editCerita;
    TextView isiTextCerita;
    String isiCerita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aku);
        ImageView imageIsi =  (ImageView) findViewById(R.id.imgIsi);
        imageIsi.setImageResource(R.drawable.aku);
        saveText = (Button) findViewById(R.id.saveText);
        editCerita = (EditText) findViewById(R.id.isiTextCerita);
        isiTextCerita = (TextView) findViewById(R.id.textViewCerita);
        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isiCerita= editCerita.getText().toString();
                isiTextCerita.setText(isiCerita);
                editCerita.setVisibility(View.GONE);
                isiTextCerita.setVisibility(View.VISIBLE);

            }
        });
        editText = (Button) findViewById(R.id.editText);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isiCerita = isiTextCerita.getText().toString();
                isiTextCerita.setVisibility(View.GONE);
                editCerita.setVisibility(View.VISIBLE);
                editCerita.setText(isiCerita,TextView.BufferType.EDITABLE);
            }
        });
    }
}
