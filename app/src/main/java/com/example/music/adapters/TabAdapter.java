package com.example.music.adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.music.fragments.MenuFragment;
import com.example.music.fragments.MusicFragment;
import com.example.music.fragments.TopFragment;

public class TabAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;
    public TabAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }
    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MenuFragment homeFragment = new MenuFragment();
                return homeFragment;
            case 1:
                TopFragment topFragment = new TopFragment();
                return topFragment;
            case 2:
                MusicFragment musicFragment = new MusicFragment();
                return musicFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
