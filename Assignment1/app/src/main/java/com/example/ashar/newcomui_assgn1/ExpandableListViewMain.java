package com.example.ashar.newcomui_assgn1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ashar on 2/2/17.
 */

public class ExpandableListViewMain extends AppCompatActivity
{
    List<String> listhead;
    HashMap<String,List<String>> listchild;
    ExpandableListdataAdapter adapter;
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandablelistviewmain);


     expandableListView = (ExpandableListView) findViewById(R.id.expandables);

        listdata();

        adapter = new ExpandableListdataAdapter(this,listhead,listchild);
        expandableListView.setAdapter(adapter);

    }
public void listdata() {
    listhead = new ArrayList<String>();
    listchild = new HashMap<String, List<String>>();

    listhead.add("Friction Novels");
    listhead.add("Suspense Novels");
    listhead.add("Comics");

    List<String> frictionnovels = new ArrayList<String>();
    frictionnovels.add(" The Rocks by Peter Nichols");
    frictionnovels.add("Seveneves by Neal Stephenson");
    frictionnovels.add("Girl at War by Sara Novi?");
    frictionnovels.add("Golden Son by Pierce Brown");
    frictionnovels.add(" The Unnoticeables by Robert Brockway");

    List<String> suspensenovels = new ArrayList<String>();
    suspensenovels.add("The Girl on the Train by Paula Hawkins");
    suspensenovels.add("Before I Go To Sleep by S.J. Watson");
    suspensenovels.add("Bird Box by Josh Malerman");
    suspensenovels.add("An Untamed State by Roxane Gay");

    List<String> comics = new ArrayList<String>();
    comics.add("Kevin Matchstick ");
    comics.add("Archie Andrews ");
    comics.add("Emma Frost ");

    listchild.put(listhead.get(0), frictionnovels);
    listchild.put(listhead.get(1), suspensenovels);
    listchild.put(listhead.get(2), comics);
}
}


