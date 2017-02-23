package com.example.ashar.newcomui_assgn1;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ashar on 31/1/17.
 */

public class FragmentMain extends FragmentActivity
{
    Fragment fragment1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentmain);


    }

    public  void changeFragment(View v)
    {
        if(v == findViewById(R.id.button1) )
        {
            fragment1 = new FragmentOne();
            android.app.FragmentManager fm =getFragmentManager();
            FragmentTransaction ft =  fm.beginTransaction();
            ft.replace(R.id.fragment_common,fragment1);
            ft.addToBackStack(null);
            ft.commit();

        }
        else
        {
            fragment1 = new FragmentTwo();
            android.app.FragmentManager fm =getFragmentManager();
            FragmentTransaction ft =  fm.beginTransaction();
            ft.replace(R.id.fragment_common,fragment1);
            ft.addToBackStack(null);
            ft.commit();

        }

    }
}
