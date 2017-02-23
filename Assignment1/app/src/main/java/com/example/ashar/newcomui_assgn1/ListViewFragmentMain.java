package com.example.ashar.newcomui_assgn1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ashar on 6/2/17.
 */

public class ListViewFragmentMain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewfragmentmain);
        FragmentOneViwer fragmentOne = new FragmentOneViwer();

        ListViewFragment listViewFragment = new ListViewFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment,listViewFragment);
        ft.commit();


    }
}
