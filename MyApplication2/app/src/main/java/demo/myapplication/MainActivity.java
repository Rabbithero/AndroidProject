package demo.myapplication;


import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import activity.Activity1;
import activity.Activity2;
import activity.activity3;
import activity.activity4;
import demo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button book;
    private Button movies;
    private ViewPager view_page;
    private MainAdapter adapter;
     List<Fragment> mlistview= new ArrayList<>();
    private LocalActivityManager manager;
    private SparseArray<Fragment> mSparseArray;
    private Button home;
    private Button sttring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_page = (ViewPager) findViewById(R.id.view_page);
        book = (Button) findViewById(R.id.book);
        movies = (Button) findViewById(R.id.movies);
        home= (Button) findViewById(R.id.home);
         sttring = (Button) findViewById(R.id.sttring);
        book.setOnClickListener(this);
        movies.setOnClickListener(this);
        home.setOnClickListener(this);
        sttring.setOnClickListener(this);
        Activity1 view1 = new Activity1();
        Activity2 view2 = new Activity2();
        activity3 view3 = new activity3();
        activity4 view4 = new activity4();
        mlistview.add(view1);
        mlistview.add(view2);
        mlistview.add(view3);
        mlistview.add(view4);
        view_page.setCurrentItem(0);
        view_page.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position){
                    case 0:
                        home.setTextColor(Color.parseColor("#00A0D7"));
                        book.setTextColor(Color.parseColor("#000000"));
                        movies.setTextColor(Color.parseColor("#000000"));
                        sttring.setTextColor(Color.parseColor("#000000"));
                        break;
                    case 1:
                        home.setTextColor(Color.parseColor("#000000"));
                        book.setTextColor(Color.parseColor("#00A0D7"));
                        movies.setTextColor(Color.parseColor("#000000"));
                        sttring.setTextColor(Color.parseColor("#000000"));
                        break;
                    case 2:
                        home.setTextColor(Color.parseColor("#000000"));
                        book.setTextColor(Color.parseColor("#000000"));
                        movies.setTextColor(Color.parseColor("#00A0D7"));
                        sttring.setTextColor(Color.parseColor("#000000"));
                        break;
                    case 3:
                        home.setTextColor(Color.parseColor("#000000"));
                        book.setTextColor(Color.parseColor("#000000"));
                        movies.setTextColor(Color.parseColor("#000000"));
                        sttring.setTextColor(Color.parseColor("#00A0D7"));
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        adapter=new MainAdapter(getSupportFragmentManager());
        view_page.setAdapter(adapter);
        view_page.requestLayout();
    }

    private View getView(String qualityActivity1, Intent intent) {
        return manager.startActivity(qualityActivity1, intent).getDecorView();
    }

    @Override
    public void onClick(View v) {
        home.setTextColor(Color.parseColor("#000000"));
        book.setTextColor(Color.parseColor("#000000"));
        movies.setTextColor(Color.parseColor("#000000"));
        sttring.setTextColor(Color.parseColor("#000000"));
        switch (v.getId()){
            case R.id.book:
                view_page.setCurrentItem(1);
                book.setTextColor(Color.parseColor("#00A0D7"));
                break;
            case R.id.movies:
                view_page.setCurrentItem(2);
                movies.setTextColor(Color.parseColor("#00A0D7"));
                break;
            case R.id.sttring:
                view_page.setCurrentItem(3);
                sttring.setTextColor(Color.parseColor("#00A0D7"));
                break;
            case R.id.home:
                view_page.setCurrentItem(0);
                home.setTextColor(Color.parseColor("#00A0D7"));
                break;
        }
    }

    class MainAdapter extends FragmentPagerAdapter {


        public MainAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return  mlistview.get(position);
        }

        @Override
        public int getCount() {
            return mlistview.size();
        }
    }
}

