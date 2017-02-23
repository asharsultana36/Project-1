package com.example.ashar.newcomui_assgn1.json;

/**
 * Created by ashar on 13/2/17.
 */

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ashar.newcomui_assgn1.AddressBookData;
import com.example.ashar.newcomui_assgn1.R;

import java.util.ArrayList;
import java.util.List;

public class CustomList extends BaseAdapter {

    private Activity context;
    List<Products> list;

    public CustomList(Activity context, List<Products> productses) {

        this.context = context;
        this.list = productses;
      //  Log.e("adapter"," "+productses[0].getProductEntity().getSearchURL());
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position).getProductEntity().getSearchURL();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //Log.e("adapter"," "+list[position].getProductEntity().getSearchURL());
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.json_list_view_layout, null);
        }
       // View listViewItem = inflater.inflate(R.layout.json_list_view_layout, null, true);

        TextView textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);

       textViewEmail.setText(list.get(position).getProductEntity().getSearchURL());

        return convertView;
    }
}