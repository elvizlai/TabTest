package com.elvizlai.tabtest;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

/**
 * Created by Elvizlai on 14-9-10.
 */
public class My extends FragmentActivity {
    private ViewPager mViewPager;

    public final static int TAB_INDEX_TAB_1 = 0;
    public final static int TAB_INDEX_TAB_2 = 1;
    public final static int TAB_INDEX_TAB_3 = 2;
    public final static int TAB_INDEX_TAB_4 = 3;
    public final static int TAB_COUNT = 4;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);

        // 创建Tab
        setupTest1();
        setupTest2();
        setupTest3();
        setupTest4();

        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setDisplayShowHomeEnabled(false);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        getFragmentManager();

        mViewPager.setAdapter(new TestViewPagerAdapter(getSupportFragmentManager()));
        mViewPager.setOnPageChangeListener(new TestPagerListener());
        mViewPager.setCurrentItem(TAB_INDEX_TAB_2);
    }


    private void setupTest1() {
        ActionBar.Tab tab = this.getActionBar().newTab();
        tab.setText("Tab 1");
        tab.setTabListener(mTabListener);
        getActionBar().addTab(tab);
    }

    private void setupTest2() {
        ActionBar.Tab tab = this.getActionBar().newTab();
        tab.setText("Tab 2");
        tab.setTabListener(mTabListener);
        getActionBar().addTab(tab);
    }

    private void setupTest3() {
        ActionBar.Tab tab = this.getActionBar().newTab();
        tab.setText("Tab 3");
        tab.setTabListener(mTabListener);
        getActionBar().addTab(tab);
    }

    private void setupTest4() {
        ActionBar.Tab tab = this.getActionBar().newTab();
        tab.setText("Tab 4");
        tab.setTabListener(mTabListener);
        getActionBar().addTab(tab);
    }

    private final ActionBar.TabListener mTabListener = new ActionBar.TabListener() {
        private final static String TAG = "TabListener";

        @Override
        public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
            // TODO Auto-generated method stub
            Log.d(TAG, "onTabReselected");
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
            // TODO Auto-generated method stub
            Log.d(TAG, "onTabSelected()");
            if (mViewPager != null)
                mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
            // TODO Auto-generated method stub
            Log.d(TAG, "onTabUnselected()");
        }
    };


    private class TestPagerListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onPageSelected(int arg0) {
            getActionBar().selectTab(getActionBar().getTabAt(arg0));
        }
    }
}
