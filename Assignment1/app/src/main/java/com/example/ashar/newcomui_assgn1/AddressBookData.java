package com.example.ashar.newcomui_assgn1;

import android.content.Context;
import android.content.res.Resources;

import java.io.Serializable;

/*Created by ashar on 23/1/17.*/




public class AddressBookData implements Serializable
{
    public String namefirst;
    public  String namelast;
    public String address2;
    public String address1;

    public AddressBookData(String s, String s1, String address, String s2) {
        this.namefirst=s;
        this.namelast=s1;
        this.address1=address;
        this.address2=s2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getNamefirst() {
        return namefirst;
    }

    public void setNamefirst(String namefirst) {
        this.namefirst = namefirst;
    }

    public String getNamelast() {
        return namelast;
    }

    public void setNamelast(String namelast) {
        this.namelast = namelast;
    }
}
