package com.example.ashar.newcomui_assgn1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddNewCompany extends Activity
{

    Spinner city_spinner;
    Spinner established_spinner;
    Spinner state_spinner;

    EditText company_name;
    EditText tin_no;
    EditText pan_no;
    EditText tax_no;
    EditText pro_name;
    EditText address1;
    EditText address2;
    EditText pincode;
    EditText content;

    RadioGroup rg;

    String state_value;

    int i;
    int radio;

    Map<String, List<String>> mStateMap = new HashMap<>();

    CompanyData companyData;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnewcompany);
        mContext = this;

        company_name = (EditText) findViewById(R.id.company_name_et);
        tin_no = (EditText) findViewById(R.id.tin_et);
        pan_no = (EditText) findViewById(R.id.pan_et);
        tax_no = (EditText) findViewById(R.id.tax_et);
        pro_name = (EditText) findViewById(R.id.pro_et);
        address1 = (EditText) findViewById(R.id.address1_et);
        address2 = (EditText) findViewById(R.id.address2_et);
        pincode = (EditText) findViewById(R.id.pincode_et);
        content = (EditText) findViewById(R.id.content);


        rg = (RadioGroup) findViewById(R.id.know);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                EditText et = (EditText) findViewById(R.id.content);
                radio = checkedId;
                if (checkedId == R.id.radioyes)
                {

                    et.setEnabled(true);
                }
                else
                {
                    et.setEnabled(false);
                }
            }
        });

        ArrayList<Integer> years = new ArrayList<Integer>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        int till_year = thisYear - 15;
        for (i = till_year; i <= thisYear; i++)
        {
            years.add(i);
        }


        established_spinner = (Spinner) findViewById(R.id.established);
        ArrayAdapter<Integer> established_adapter = new ArrayAdapter(AddNewCompany.this, R.layout.support_simple_spinner_dropdown_item, years);
        established_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        established_spinner.setAdapter(established_adapter);


        state_spinner = (Spinner) findViewById(R.id.state);
        ArrayAdapter<CharSequence> state_adapter = ArrayAdapter.createFromResource(this, R.array.states, android.R.layout.simple_spinner_item);
        state_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state_spinner.setAdapter(state_adapter);

        mStateMap.put("karnataka", Arrays.asList(getResources().getStringArray(R.array.karnataka_city)));
        mStateMap.put("Andhra Pradesh", Arrays.asList(getResources().getStringArray(R.array.Andhra_city)));
        mStateMap.put("Orissa", Arrays.asList(getResources().getStringArray(R.array.Orissa_city)));
        mStateMap.put("Tamil Nadu", Arrays.asList(getResources().getStringArray(R.array.Tamil_city)));
        mStateMap.put("kerala", Arrays.asList(getResources().getStringArray(R.array.kerela_city)));

        state_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                state_value = parent.getItemAtPosition(position).toString();

                city_spinner = (Spinner) findViewById(R.id.city);
                String state_value = parent.getItemAtPosition(position).toString();
                List<String> cities = mStateMap.get(state_value);
                ArrayAdapter<String> city_adapter = new ArrayAdapter(AddNewCompany.this, R.layout.support_simple_spinner_dropdown_item, cities);
                city_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                city_spinner.setAdapter(city_adapter);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }

        });

    }


    public void onsave(View v)
    {

        String companyName = company_name.getText().toString().trim();
        String tin = tin_no.getText().toString().trim();
        String pan = pan_no.getText().toString().trim();
        String tax = tax_no.getText().toString().trim();
        String add = address1.getText().toString().trim();
        String pin = pincode.getText().toString().trim();

        if(Validate.getInstance().checkEmpty(companyName,pan,add,pin,mContext))
            Validate.getInstance().showError("* Fields Should not be empty",mContext);
        else if(!Validate.getInstance().validateName(companyName,mContext))
            Validate.getInstance().showError("Please enter valid name",mContext);
        else if(!Validate.getInstance().validateTin(tin,mContext))
            Validate.getInstance().showError("Please Enter valid Tin Number",mContext);
        else if(!Validate.getInstance().validatePan(pan,mContext))
            Validate.getInstance().showError("Please Enter valid PanCard Number",mContext);
        else if(!Validate.getInstance().validateTax(tax,mContext))
            Validate.getInstance().showError("Please Enter valid Tax Number",mContext);
        else if(!Validate.getInstance().validatePin(pin,mContext))
            Validate.getInstance().showError("Please Enter valid PanCard Number",mContext);
        else
        {
        companyData = new CompanyData();
        companyData.setCompanyName(companyName);
        companyData.setTinNumber(tin);
        companyData.setPanNumber(pan);
        companyData.setTaxNumber(tax);
        companyData.setPropriterName(pro_name.getText().toString());
        companyData.setAddress1(add);
        companyData.setAddress2(address2.getText().toString());
        companyData.setPincode(pin);
        companyData.setContent(content.getText().toString());
        companyData.setEstDate(established_spinner.getSelectedItem().toString());
        companyData.setState(state_spinner.getSelectedItem().toString());
        companyData.setCity(city_spinner.getSelectedItem().toString());
        Intent in = new Intent(AddNewCompany.this, CompanyDetails.class);
        in.putExtra("company", companyData);
        startActivity(in);
        }
    }
}




        /*String[] array1 = getResources().getStringArray(R.array.karnataka_city);
        String[] array2 = getResources().getStringArray(R.array.Andhra_city);
        String[] array3 = getResources().getStringArray(R.array.Orissa_city);
        String[] array4 = getResources().getStringArray(R.array.Tamil_city);
        String[] array5 = getResources().getStringArray(R.array.kerela_city);*/



      /*  mStateMap.put("Karnataka", Arrays.asList(array1));
        mStateMap.put("Andhra", Arrays.asList(array1));
        mStateMap.put("Orissa", Arrays.asList(array1));
        mStateMap.put("Tamil", Arrays.asList(array1));
        mStateMap.put("Kerala", Arrays.asList(array1));*/

  /* if (companyName.isEmpty() || pan.isEmpty() || add.isEmpty() || pin.isEmpty())
        {
            Toast.makeText(getApplicationContext(), " * Fields Should Not Be Empty ", Toast.LENGTH_SHORT).show();

        }

       else if (!companyName.matches(String.valueOf(name_Pattern)))
        {
            Toast.makeText(getApplicationContext(), " Invalid Company Name... Max 15 alphabets", Toast.LENGTH_SHORT).show();

        }

        else if (!tin.matches(String.valueOf(tin_Pattern)))
        {
            Toast.makeText(getApplicationContext(), " Invalid Tin Number...", Toast.LENGTH_SHORT).show();
        }

        else if (!pan.matches(String.valueOf(pan_Pattern)))
        {
            Toast.makeText(getApplicationContext(), "Invalid Pan Number" , Toast.LENGTH_SHORT).show();

        }

        else if (!tax.matches(String.valueOf(tax_Pattern)))
        {
            Toast.makeText(getApplicationContext(), " Invalid Service Tax Number...", Toast.LENGTH_SHORT).show();

        }


        else if (!pin.matches(String.valueOf(pincode_Pattern)) )
        {
            Toast.makeText(getApplicationContext(), " Invalid Pincode... Pincode should be  6 digits ", Toast.LENGTH_SHORT).show();

        }

        else
        {
            companyData = new CompanyData();

            companyData.setCompanyName(companyName);
            companyData.setTinNumber(tin);
            companyData.setPanNumber(pan);
            companyData.setTaxNumber(tax);
            companyData.setPropriterName(pro_name.getText().toString());
            companyData.setAddress1(add);
            companyData.setAddress2(address2.getText().toString());
            companyData.setPincode(pin);
            companyData.setContent(content.getText().toString());
            companyData.setEstDate(established_spinner.getSelectedItem().toString());
            companyData.setState(state_spinner.getSelectedItem().toString());
            companyData.setCity(city_spinner.getSelectedItem().toString());
            Intent in = new Intent(MainActivity.this, );
            in.putExtra("company", companyData);
            startActivity(in);
        }
*/



