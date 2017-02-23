package com.example.ashar.newcomui_assgn1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ashar.newcomui_assgn1.json.JsonMainActivity;

public class AssignmentsList extends AppCompatActivity {
    Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentslist);
        mcontext = this;
    }
    public void assignment1(View arg)
    {
        Intent i =new Intent(mcontext,AddNewCompany.class);
        startActivity(i);
    }
    public void movetoviews(View arg)
    {
        Intent i =new Intent(mcontext,ListViewAndRecyclerView.class);
        startActivity(i);
    }

    public void assignment3 (View arg)
    {
        Intent i = new Intent(mcontext,FragmentMain.class);
        startActivity(i);
    }
    public void assignment4 (View arg)
    {
        Intent i = new Intent(mcontext,ViewPagerAndTabView.class);
        startActivity(i);
    }
    public void assignment5 (View arg)
    {
        Intent i = new Intent(mcontext,ExpandableListViewMain.class);
        startActivity(i);
    }
    public void assignment6 (View arg)
    {
        Intent i = new Intent(mcontext,ListViewFragmentMain.class);
        startActivity(i);
    }
    public void assignment7 (View arg)
    {
        Intent i = new Intent(mcontext,RecyclerViewInfiniteScrollMain.class);
        startActivity(i);
    }
    public void assignment8 (View arg)
    {
        Intent i = new Intent(mcontext,JsonMainActivity.class);
        startActivity(i);
    }
}
