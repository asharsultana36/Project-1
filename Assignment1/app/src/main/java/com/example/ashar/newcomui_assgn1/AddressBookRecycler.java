
package com.example.ashar.newcomui_assgn1;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;




public class AddressBookRecycler extends AppCompatActivity
{
    RecyclerView recyclerView;
    AddressBookAdapterRecycler adapter;
    RecyclerView.LayoutManager layoutManager;

    String[] firstname;
    String[] lastname;
    String[] address1;
    String[] address2;

    Context context=this;

    ArrayList<AddressBookData> sr;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_book_recycler);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);

        firstname = getResources().getStringArray(R.array.Customer_first_names);
        lastname = getResources().getStringArray(R.array.Customer_last_names);
        address1 = getResources().getStringArray(R.array.customer_address1);
        address2 = getResources().getStringArray(R.array.customer_address2);



        adapter = new AddressBookAdapterRecycler(this, getAddressBookData(),context);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
       recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<AddressBookData> getAddressBookData()
    {
        sr = new ArrayList<AddressBookData>();
        AddressBookData sr1 = null;

        for (int i = 0; i < firstname.length; i++)
        {
            sr1 = new AddressBookData(firstname[i],lastname[i], address1[i],address2[i]);
            sr.add(sr1);
        }

        return sr;
    }
}








