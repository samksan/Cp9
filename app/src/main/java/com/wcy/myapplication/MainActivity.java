package com.wcy.myapplication;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<View> mViews = new ArrayList<View>();

    //tab
    private LinearLayout mTab0;
    private LinearLayout mTab1;
    private LinearLayout mTab2;
    private LinearLayout mTab3;

    private ImageButton mImg0;
    private ImageButton mImg1;
    private ImageButton mImg2;
    private ImageButton mImg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewPager);

        mTab0 = (LinearLayout) findViewById(R.id.id_tab_0);
        mTab1 = (LinearLayout) findViewById(R.id.id_tab_1);
        mTab2 = (LinearLayout) findViewById(R.id.id_tab_2);
        mTab3 = (LinearLayout) findViewById(R.id.id_tab_3);

        mImg0 = (ImageButton) findViewById(R.id.imageBtn0);
        mImg1 = (ImageButton) findViewById(R.id.imageBtn1);
        mImg2 = (ImageButton) findViewById(R.id.imageBtn2);
        mImg3 = (ImageButton) findViewById(R.id.imageBtn3);

        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        View tab0 = mLayoutInflater.inflate(R.layout.tab0, null);
        View tab1 = mLayoutInflater.inflate(R.layout.tab1, null);
        View tab2 = mLayoutInflater.inflate(R.layout.tab2, null);
        View tab3 = mLayoutInflater.inflate(R.layout.tab3, null);

        mViews.add(tab0);
        mViews.add(tab1);
        mViews.add(tab2);
        mViews.add(tab3);

        mPagerAdapter = new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
//                super.destroyItem(container, position, object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
//                return super.instantiateItem(container, position);
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }
        };

        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
