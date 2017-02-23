package com.example.ashar.newcomui_assgn1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashar on 2/2/17.
 */

public class ViewPagerMain extends AppCompatActivity
{



    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpagermain);



        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerMain.ViewPagerAdapter adapter = new ViewPagerMain.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOneViwer());
        adapter.addFragment(new FragmentTwoViwer());
        adapter.addFragment(new FragmentThreeViwer());
        adapter.addFragment(new FragmentFourViwer());
        adapter.addFragment(new FragmentFiveViwer());
        adapter.addFragment(new FragmentSixViwer());
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        //private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager)
        {
            super(manager);
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment)
        {
            mFragmentList.add(fragment);
          //  mFragmentTitleList.add(title);
        }


    }
}

