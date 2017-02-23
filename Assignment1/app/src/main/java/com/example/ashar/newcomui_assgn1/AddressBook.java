package com.example.ashar.newcomui_assgn1;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AddressBook extends AppCompatActivity
{

    ListView lv;
    Context context = this;
    String[] firstname;
    String[] lastname;
    String[] address1;
    String[] address2;
    ArrayList<AddressBookData> sr;
    AddressBookData si;

    //private static final String TAG = AddressBook.class.getSimpleName();

    AddressBookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addressbook);

        Resources res = context.getResources();
        firstname = res.getStringArray(R.array.Customer_first_names);
        lastname = res.getStringArray(R.array.Customer_last_names);
        address1 = res.getStringArray(R.array.customer_address1);
        address2 = res.getStringArray(R.array.customer_address2);


        lv = (ListView) findViewById(R.id.Address_list);


         adapter = new AddressBookAdapter(this, getAddressBookData());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((AdapterView.OnItemClickListener) new ListClickHandler());



    }


    private ArrayList<AddressBookData> getAddressBookData()
    {
         sr = new ArrayList<AddressBookData>();
        AddressBookData sr1 = null;

//        Log.d(TAG, "name.length  size " + name.length + "");
//        Log.d(TAG, "address.length  size " + address.length + "");

        for (int i = 0; i < firstname.length; i++)
        {
            sr1 = new AddressBookData(firstname[i],lastname[i], address1[i],address2[i]);
            sr.add(sr1);
        }

        return sr;
    }

    public class ListClickHandler implements AdapterView.OnItemClickListener
    {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3)
        {

            if(null != adapter)
            {

                si = (AddressBookData) adapter.getItemAtPosition(position);
                Intent intent = new Intent(AddressBook.this, UpdateAddressBook.class);
                intent.putExtra("Address_Book", si);
                startActivity(intent);
            }

        }
    }
}
