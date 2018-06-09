package com.example.pbo.jagasehat;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by M FaizinAhsan on 6/9/2018.
 */

public class MainCategotyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public MainCategotyAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new HomePage();
        }else{
            return new KontakPetugas();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
