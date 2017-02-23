package com.example.ashar.newcomui_assgn1;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by ashar on 6/2/17.
 */

public class ListViewFragment extends Fragment
{
    ListView lv;
    String[] firstname;
    String[] lastname;
    String[] address1;
    String[] address2;
    ArrayList<AddressBookData> sr;
    AddressBookData si;

    AddressBookAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
    {
            View rootview = inflater.inflate(R.layout.listviewfragment, container, false);
        firstname = getResources().getStringArray(R.array.Customer_first_names);
        lastname = getResources().getStringArray(R.array.Customer_last_names);
        address1 = getResources().getStringArray(R.array.customer_address1);
        address2 = getResources().getStringArray(R.array.customer_address2);

        lv = (ListView) rootview.findViewById(R.id.addressbook);

        adapter = new AddressBookAdapter(getActivity(), getAddressBookData());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                if(null != adapter)
                {
                    FragmentUpdateAddressBook fragment = new FragmentUpdateAddressBook();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    si = (AddressBookData) arg0.getItemAtPosition(arg2);
                   //Toast.makeText(getActivity(),si+"",Toast.LENGTH_SHORT).show();
                    Bundle args = new Bundle();
                    args.putSerializable("Address_Book",si);
                    fragment.setArguments(args);
                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                 /*   fragmentManager.beginTransaction().replace( R.id.fragment, fragment )
                            .addToBackStack( null ).commit();

                    si = (AddressBookData) arg0.getItemAtPosition(arg2);
                    Intent intent = new Intent(getActivity(), FragmentUpdateAddressBook.class);
                    intent.putExtra("Address_Book", si);
                    startActivity(intent);*/
                }
            }
        });

      return   rootview;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

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
