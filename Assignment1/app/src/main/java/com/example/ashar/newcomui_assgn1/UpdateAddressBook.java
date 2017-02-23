package com.example.ashar.newcomui_assgn1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.id.empty;

public class UpdateAddressBook extends AppCompatActivity
{
   EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;

    ArrayList<AddressBookData> list;

    AddressBookData addressBookData;

    Spinner state_spinner,city_spinner,country_spinner,pincode_spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateaddress);

        state_spinner = (Spinner) findViewById(R.id.state);
        ArrayAdapter<CharSequence> state_adapter = ArrayAdapter.createFromResource(this, R.array.states, android.R.layout.simple_spinner_item);
        state_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state_spinner.setAdapter(state_adapter);

        city_spinner = (Spinner) findViewById(R.id.city);
        ArrayAdapter<CharSequence> city_adapter = ArrayAdapter.createFromResource(this, R.array.cities,android.R.layout.simple_spinner_item);
        city_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        city_spinner.setAdapter(city_adapter);


        country_spinner = (Spinner) findViewById(R.id.Country);
        ArrayAdapter<CharSequence> country_adapter = ArrayAdapter.createFromResource(this, R.array.countries,android.R.layout.simple_spinner_item);
        city_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        country_spinner.setAdapter(country_adapter);


        pincode_spinner = (Spinner) findViewById(R.id.pincode);
        ArrayAdapter<CharSequence> pincode_adapter = ArrayAdapter.createFromResource(this, R.array.pincode,android.R.layout.simple_spinner_item);
        city_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        pincode_spinner.setAdapter(pincode_adapter);


        AddressBookData sr = (AddressBookData) getIntent().getSerializableExtra("Address_Book");
        //ArrayList myList = (ArrayList<AddressBookData>) getIntent().getSerializableExtra("Address_Book");



       /* if(sr==null)
        {
            Log.d("sr",sr+" ");
        }*/



        et1 = (EditText) findViewById(R.id.First_name_et);
        et2 = (EditText) findViewById(R.id.Street_Address1_et);
        et3 = (EditText) findViewById(R.id.Street_Address2_et);
        et4 = (EditText) findViewById(R.id.Last_Name_et);

        et1.setText(sr.getNamefirst());
        et4.setText(sr.getNamelast());
        et2.setText(sr.getAddress1());
        et3.setText(sr.getAddress2());
       /* et1.setText(String.valueOf(myList.get(1)).toString());
        et1.setText(myList.);*/
       /* et2.setText(addressBookData.getNamelast());
        et3.setText(addressBookData.getAddress1());
        et4.setText(addressBookData.getAddress2());
*/
       /* for(int i=0;i<myList.size();i++)
        {
            Toast.makeText(this, (String) myList.get(i), Toast.LENGTH_LONG); // here if you have value in array then it will display in toast one by one.
            //Log.d("mylist",myList[i]+" ");
        }*/

    }
}




