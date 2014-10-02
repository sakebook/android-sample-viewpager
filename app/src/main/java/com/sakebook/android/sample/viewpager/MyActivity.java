package com.sakebook.android.sample.viewpager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;


public class MyActivity extends FragmentActivity {

    private HorizontalScrollView mScrollView;
    private LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this,  getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        mScrollView = (HorizontalScrollView)findViewById(R.id.scroll);
        mScrollView.setSmoothScrollingEnabled(true);
        mLayout = (LinearLayout)findViewById(R.id.linear);

        setEvent(viewPager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mScrollView.smoothScrollTo(mLayout.getChildAt(position).getLeft(), 0);
            }

            @Override
            public void onPageScrollStateChanged(int position) {
            }
        });

    }

    private void setEvent(final ViewPager viewPager) {
        for (int i = 0; i < mLayout.getChildCount(); i++) {
            mLayout.getChildAt(i).setOnClickListener(new WrapClickListener(i){
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(this.position);
                    mScrollView.smoothScrollTo(v.getLeft(), 0);
                }
            });
        }
    }

    private static class WrapClickListener implements View.OnClickListener{

        protected int position;
        public WrapClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
        }
    }
}
