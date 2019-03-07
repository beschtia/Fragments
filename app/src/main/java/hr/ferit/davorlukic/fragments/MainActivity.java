package hr.ferit.davorlukic.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ButtonClickListener {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setUpPager();
    }

    private void initViews() {
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tab);
    }

    private void setUpPager() {
        PagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }

    @Override
    public void onButtonClicked(String input) {
        MessageFragment frag = (MessageFragment) mViewPager.getAdapter().instantiateItem(mViewPager,1);
        frag.displayMessage(input);
        mViewPager.setCurrentItem(1);
    }
}
