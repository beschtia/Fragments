package hr.ferit.davorlukic.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Locale;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 4;
    private static final String BASE_NAME = "Tab #%d";

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return InputFragment.newInstance();
            case 1:
                return MessageFragment.newInstance();
            case 2:
                return ModularFragment.newInstance(false);
            default:
                return ModularFragment.newInstance(true);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return String.format(Locale.getDefault(), BASE_NAME, position+1);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
