package com.elvizlai.tabtest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Elvizlai on 14-9-10.
 */
public class TestViewPagerAdapter extends FragmentPagerAdapter {

    public TestViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0){
        switch (arg0) {
            case My.TAB_INDEX_TAB_1:
                return new Tab1Fragment();

            case My.TAB_INDEX_TAB_2:
                return new Tab2Fragment();

            case My.TAB_INDEX_TAB_3:
                return new Tab3Fragment();

            case My.TAB_INDEX_TAB_4:
                return new Tab4Fragment();
        }

        throw new IllegalStateException("No fragment at position " + arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return My.TAB_COUNT;
    }
}
