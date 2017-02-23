package com.example.ashar.newcomui_assgn1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ashar on 2/2/17.
 */

public class ListViewAndRecyclerView extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewandrecyclerview);
    }
    public void assignment2(View arg)
    {
        Intent i =new Intent(this,AddressBook.class);
        startActivity(i);
    }
    public void assignmentr2(View arg)
    {
        Intent i =new Intent(this,AddressBookRecycler.class);
        startActivity(i);
    }
}
