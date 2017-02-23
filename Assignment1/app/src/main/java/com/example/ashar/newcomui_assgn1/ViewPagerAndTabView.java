package com.example.ashar.newcomui_assgn1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ashar on 2/2/17.
 */

public class ViewPagerAndTabView extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpagerandtabview);
    }

    public void swipeview(View v)
    {
        Intent i = new Intent(this,ViewPagerMainSwipe.class);
        startActivity(i);
    }

    public void scrollview(View v)
    {
        Intent i = new Intent(this,ViewPagerMainScroll.class);
        startActivity(i);
    }
    public void viewpager(View v)
    {
        Intent i = new Intent(this,ViewPagerMain.class);
        startActivity(i);
    }
}
