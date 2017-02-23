package com.example.ashar.newcomui_assgn1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by ashar on 7/2/17.
 */

public class FragmentUpdateAddressBook extends Fragment
{

    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;

    ArrayList<AddressBookData> list;

    AddressBookData addressBookData;

    AddressBookData sr;

    Spinner state_spinner,city_spinner,country_spinner,pincode_spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.updateaddress,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        state_spinner = (Spinner) getActivity().findViewById(R.id.state);
        ArrayAdapter<CharSequence> state_adapter = ArrayAdapter.createFromResource(getActivity(), R.array.states, android.R.layout.simple_spinner_item);
        state_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state_spinner.setAdapter(state_adapter);

        city_spinner = (Spinner) getActivity().findViewById(R.id.city);
        ArrayAdapter<CharSequence> city_adapter = ArrayAdapter.createFromResource(getActivity(), R.array.cities,android.R.layout.simple_spinner_item);
        city_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        city_spinner.setAdapter(city_adapter);


        country_spinner = (Spinner) getActivity().findViewById(R.id.Country);
        ArrayAdapter<CharSequence> country_adapter = ArrayAdapter.createFromResource(getActivity(), R.array.countries,android.R.layout.simple_spinner_item);
        city_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        country_spinner.setAdapter(country_adapter);


        pincode_spinner = (Spinner) getActivity().findViewById(R.id.pincode);
        ArrayAdapter<CharSequence> pincode_adapter = ArrayAdapter.createFromResource(getActivity(), R.array.pincode,android.R.layout.simple_spinner_item);
        city_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        pincode_spinner.setAdapter(pincode_adapter);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
             sr = (AddressBookData) bundle.getSerializable("Address_Book");
        }




        et1 = (EditText) getActivity().findViewById(R.id.First_name_et);
        et2 = (EditText) getActivity().findViewById(R.id.Street_Address1_et);
        et3 = (EditText) getActivity().findViewById(R.id.Street_Address2_et);
        et4 = (EditText) getActivity().findViewById(R.id.Last_Name_et);


        et1.setText(sr.getNamefirst());
        et4.setText(sr.getNamelast());
        et2.setText(sr.getAddress1());
        et3.setText(sr.getAddress2());



    }
}
