package com.example.pbo.jagasehat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class detail_kontak_petugas2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kontak_petugas2);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "087651293840";
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel: " + phoneNumber));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission
                        .CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[]
                    // permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the
                    // documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(i);
            }
        });
    }
}
