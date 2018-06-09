package com.example.pbo.jagasehat;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        // Create an adapter that knows which fragment should be shown on each page
        MainCategotyAdapter adapter = new MainCategotyAdapter(getSupportFragmentManager(),this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
         tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcon();

    }
    private void setupTabIcon(){
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_page);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_kontak_petugas);
    }
}
