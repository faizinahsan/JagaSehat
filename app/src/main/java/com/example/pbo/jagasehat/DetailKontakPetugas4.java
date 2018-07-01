package com.example.pbo.jagasehat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class DetailKontakPetugas4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kontak_petugas4);
    }

    public void clickCall(View v){
        String phoneNumber = "087651293840";
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel: " + phoneNumber));
        startActivity();
    }

    private void startActivity() {
    }



}
