package com.example.pbo.jagasehat;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //Pending intent instance
    private PendingIntent pendingIntent;
    //Alarm Request Code
    private static final int ALARM_REQUEST_CODE = 133;
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        // Create an adapter that knows which fragment should be shown on each page
//        MainCategotyAdapter adapter = new MainCategotyAdapter(getSupportFragmentManager(),this);

        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcon();

        /* Retrieve a PendingIntent that will perform a broadcast */
        Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, ALARM_REQUEST_CODE, alarmIntent, 0);
        stopAlarmManager();
        LinearLayout mainActivity= (LinearLayout) findViewById(R.id.main_activity);
//        mainActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                stopAlarmManager();
//            }
//        });

    }
    //get time interval to trigger alarm manager
    private int getTimeInterval(String getInterval) {
        int interval = Integer.parseInt(getInterval);//convert string interval into integer
        return interval;

    }
    //Trigger alarm manager with entered time interval
    public void triggerAlarmManager(int alarmTriggerTime) {
        // get a Calendar object with current time
        Calendar cal = Calendar.getInstance();
        // add alarmTriggerTime seconds to the calendar object
        cal.add(Calendar.SECOND, alarmTriggerTime);

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);//get instance of alarm manager
        manager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);//set alarm manager with entered timer by converting into milliseconds

        Toast.makeText(this, "Alarm Set for " + alarmTriggerTime + " seconds.", Toast.LENGTH_SHORT).show();
    }
    //Stop/Cancel alarm manager
    public void stopAlarmManager() {

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);//cancel the alarm manager of the pending intent



        //remove the notification from notification tray
        NotificationManager notificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(AlarmNotificationService.NOTIFICATION_ID);

        Toast.makeText(this, "Alarm Canceled/Stop by User.", Toast.LENGTH_SHORT).show();
    }
    private void setupTabIcon(){
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_page);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_kontak_petugas);
    }
    private void setupViewPager(ViewPager viewPager) {
        MainCategotyAdapter adapter = new MainCategotyAdapter(getSupportFragmentManager(),this);
        adapter.addFrag(new HomePage(), "Cerita");
        adapter.addFrag(new KontakPetugas(), "Kontak");
        viewPager.setAdapter(adapter);
    }
    @Override
    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "Press once again to exit!",
                    Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
        triggerAlarmManager(getTimeInterval("10"));

    }
}
