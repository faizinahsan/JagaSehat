package com.example.pbo.jagasehat;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by M FaizinAhsan on 7/2/2018.
 */

public class CostumDialog extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] HALAMAN= {R.drawable.pengenalan1,R.drawable.pengenalan2,R.drawable
            .pengenalan3,R.drawable.pengenalan4};
    private ArrayList<Integer> HALAMANArray = new ArrayList<Integer>();
    private static final Integer[] HALAMANLanscape= {R.drawable.pengenalan1lanscape,R.drawable
            .pengenalan2lanscape,R
            .drawable
            .pengenalan3lanscape,R.drawable.pengenalan4lanscape};
    private ArrayList<Integer> HALAMANArrayLanscape = new ArrayList<Integer>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costum_dialog);
        Drawable d = getResources().getDrawable(R.drawable.pengenalan1);
        int h = d.getIntrinsicHeight();
        int w = d.getIntrinsicWidth();
        Button mNext= (Button) findViewById(R.id.nextButton);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(CostumDialog.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        init();
    }

    public void init() {
        for (int l = 0; l < HALAMAN.length; l++){
            HALAMANArray.add(HALAMAN[l]);
            HALAMANArrayLanscape.add(HALAMANLanscape[l]);
        }
        mPager = (ViewPager) findViewById(R.id.dialog_fragment_viewpager);
        mPager.setAdapter(new DialogAdapter(CostumDialog.this,HALAMANArray));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout_pengenalan);
        tabLayout.setupWithViewPager(mPager, true);


        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == HALAMAN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            mPager.setAdapter(new DialogAdapter(CostumDialog.this,HALAMANArrayLanscape));
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
            mPager.setAdapter(new DialogAdapter(CostumDialog.this,HALAMANArray));
        }
    }
}

