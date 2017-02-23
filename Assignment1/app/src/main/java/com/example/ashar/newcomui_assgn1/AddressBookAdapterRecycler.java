package com.example.ashar.newcomui_assgn1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import utils.Constants;

import static android.R.attr.homeAsUpIndicator;
import static android.R.attr.start;

/**
 * Created by ashar on 25/1/17.
 */

public class AddressBookAdapterRecycler extends RecyclerView.Adapter<AddressBookAdapterRecycler.RecyclerViewHolder> implements RecyclerView.OnClickListener
{
    private Context context;
    private static final char[] S =null ;
    ArrayList<AddressBookData> addressBookDatalist = new ArrayList<AddressBookData>();


    public AddressBookAdapterRecycler(AddressBookRecycler addressBookRecycler, ArrayList<AddressBookData> addressBookData,Context context)
    {
        this.addressBookDatalist = addressBookData;

        this.context = context;
     //   Log.d("context value ",context + " ");
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addressbook_textview,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        Log.d("context oncreate ",context + " ");
        view.setOnClickListener(this);
        return recyclerViewHolder;


    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position)
    {

        Log.d("context onbind  ",context + " ");
       // AddressBookData addressBookData = (AddressBookData)addressBookDatalist.get(position);



       holder.name.setText( addressBookDatalist.get(position).getNamefirst()+" "+addressBookDatalist.get(position).getNamelast());

       holder.address.setText( addressBookDatalist.get(position).getAddress1()+" "+addressBookDatalist.get(position).getAddress2());

       // holder.itemView.setTag(addressBookDatalist);
        holder.itemView.setTag(addressBookDatalist.get(position));
    }

    @Override
    public int getItemCount()
    {
        return addressBookDatalist.size();
    }

    @Override
    public void onClick(View v)
    {

        AddressBookData addressBook = (AddressBookData)v.getTag();
        Log.d("addressBook ",addressBook+"");
        Toast.makeText(context,addressBook+"",Toast.LENGTH_SHORT).show();

        final Intent intent = new Intent(context,UpdateAddressBook.class);

        if(context == null)
        {
            Log.d("context value in on click null ",context + " ");
        }
        else
        {
            intent.putExtra(Constants.ADDRESS_BOOK,addressBook);
/*
            intent.putExtra("Address_Book", addressBookDatalist,);
            Log.d("get intent value",addressBookDatalist+" ");
            Log.d("context value  in on click  ",context + " ");
            Log.d("context value intent ",intent + " ");*/
            context.startActivity(intent);

        }
    }

/*
    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(CONTEXT, new RecyclerItemClickListener.OnItemClickListener() {
    @Override
    public void onItemClick(View view, int position) {
        // onClick
    }
}));
*/

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView address;

        public RecyclerViewHolder(View itemView)
        {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
        }
    }

}
/*
(AddressBookData)v.getTag()*/
