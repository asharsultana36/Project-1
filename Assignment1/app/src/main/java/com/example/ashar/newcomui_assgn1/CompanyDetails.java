package com.example.ashar.newcomui_assgn1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CompanyDetails extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    TextView tv8;
    TextView tv9;
    TextView tv10;
    TextView tv11;
    TextView tv12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companydetails);

        CompanyData cd;


        cd = (CompanyData) getIntent().getSerializableExtra("company");


        tv1 = (TextView) findViewById(R.id.cname);
        tv2 = (TextView) findViewById(R.id.tin);
        tv3 = (TextView) findViewById(R.id.pan);
        tv4 = (TextView) findViewById(R.id.tax_no);
        tv5 = (TextView) findViewById(R.id.pro_name);
        tv6 = (TextView) findViewById(R.id.established);
        tv7 = (TextView) findViewById(R.id.address1);
        tv8 = (TextView) findViewById(R.id.address2);
        tv9 = (TextView) findViewById(R.id.state);
        tv10 = (TextView) findViewById(R.id.city);
        tv11 = (TextView) findViewById(R.id.pincode);
        tv12 = (TextView) findViewById(R.id.content);

        tv1.setText(cd.getCompanyName());
        tv2.setText(cd.getTinNumber());
        tv3.setText(cd.getPanNumber());
        tv4.setText(cd.getTaxNumber());
        tv5.setText(cd.getPropriterName());
        tv6.setText(cd.getEstDate());
        tv7.setText(cd.getAddress1());
        tv8.setText(cd.getAddress2());
        tv9.setText(cd.getState());
        tv10.setText(cd.getCity());
        tv11.setText(cd.getPincode());
        tv12.setText(cd.getContent());




    }
}

