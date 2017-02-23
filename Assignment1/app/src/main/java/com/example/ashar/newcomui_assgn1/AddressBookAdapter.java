package com.example.ashar.newcomui_assgn1;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ashar on 23/1/17.
 */

public class AddressBookAdapter extends BaseAdapter {
    ArrayList<AddressBookData> list;
    Context ctx;
    private static final String TAG = AddressBookAdapter.class.getSimpleName();



    public AddressBookAdapter(Context c, ArrayList<AddressBookData> list) {
        this.ctx = c;
        this.list = list;

        Log.d(TAG, " list " + list.size());
    }




    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.indexOf(getItem(i));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d(TAG, " getView " + position);

        AddressBookData addressBook = (AddressBookData) list.get(position);

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.addressbook_textview, null);
        }
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView address = (TextView) convertView.findViewById(R.id.address);

        name.setText(list.get(position).getNamefirst() + " " + list.get(position).getNamelast());
        address.setText(list.get(position).getAddress1() + " " + list.get(position).getAddress2());

        return convertView;
    }

  }