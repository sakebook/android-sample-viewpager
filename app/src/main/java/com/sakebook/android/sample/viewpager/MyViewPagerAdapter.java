package com.sakebook.android.sample.viewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyViewPagerAdapter extends FragmentPagerAdapter{

    private Context mContext;
    private FragmentManager mFragmentManager;

    public MyViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
        this.mFragmentManager = fm;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Fragment getItem(int i) {
        SampleFragment fragment = SampleFragment.newInstance(""+i, 10000000);
        return fragment;
    }


}
