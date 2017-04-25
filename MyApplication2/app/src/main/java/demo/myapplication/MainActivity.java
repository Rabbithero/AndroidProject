package demo.myapplication;


import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import activity.Activity1;
import activity.Activity2;
import activity.activity3;
import activity.activity4;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements OnTabSelectListener {
    private BottomBar bb_navigation;
    private ViewPager view_page;
    private SparseArray<Fragment> mSparseArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        view_page = (ViewPager) findViewById(R.id.view_page);
        bb_navigation= (BottomBar) findViewById(R.id.bb_navigation);
        bb_navigation.setOnTabSelectListener(this);

        mSparseArray = new SparseArray<>();
        mSparseArray.put(0, Fragment.instantiate(this, Activity1.class.getName()));
        mSparseArray.put(1, Fragment.instantiate(this, Activity2.class.getName()));
        mSparseArray.put(2, Fragment.instantiate(this, activity3.class.getName()));
        mSparseArray.put(3, Fragment.instantiate(this, activity4.class.getName()));
        view_page.setOffscreenPageLimit(4);
        view_page.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mSparseArray.get(position);
            }

            @Override
            public int getCount() {
                return mSparseArray.size();
            }
        });

        view_page.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bb_navigation.setDefaultTabPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        view_page.requestLayout();
    }


    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId) {
            case R.id.book:
                view_page.setCurrentItem(1,false);
                break;
            case R.id.movies:
                view_page.setCurrentItem(2,false);
                break;
            case R.id.sttring:
                view_page.setCurrentItem(3,false);
                break;
            case R.id.home:
                view_page.setCurrentItem(0, false);
                break;
        }
    }
}

