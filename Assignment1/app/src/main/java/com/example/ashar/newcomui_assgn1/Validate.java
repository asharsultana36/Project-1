package com.example.ashar.newcomui_assgn1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by ashar on 20/1/17.
 */

public class Validate
{


    public  static Pattern name_Pattern = Pattern.compile("[a-zA-z]{3,15}");
    public static Pattern tin_Pattern = Pattern.compile("\\d{11}");
    public static Pattern pan_Pattern = Pattern.compile("^[\\w]{3}(p|P|c|C|h|H|f|F|a|A|t|T|b|B|l|L|j|J|g|G)[\\w][\\d]{4}[\\w]$");
    public static Pattern tax_Pattern = Pattern.compile("^[\\w]{3}(p|P|c|C|h|H|f|F|a|A|t|T|b|B|l|L|j|J|g|G)[\\w][\\d]{4}[\\w]{1}(st|sd|ST|SD)[0-9]{3}");
    public static Pattern pincode_Pattern = Pattern.compile("\\d{6}");


   private static Validate valid = null;

    private Validate(){}

    public static Validate getInstance( )
    {

        if(null == valid)
        {
            valid = new Validate( );
        }

        return valid;
    }

    public static Boolean checkEmpty( String name, String pan, String add, String pin, Context m)
    {
        return name.isEmpty() || pan.isEmpty() || add.isEmpty() || pin.isEmpty();
    }

    public static Boolean validateName(String name, Context m)
    {
       return name.matches(String.valueOf(name_Pattern));
    }
    public static Boolean validateTin(String tin, Context m)
    {
        return tin.matches(String.valueOf(tin_Pattern));
    }
    public static Boolean validatePan(String pan, Context m)
    {
        return pan.matches(String.valueOf(pan_Pattern));

    }
    public static Boolean validateTax(String tax, Context m)
    {
       return tax.matches(String.valueOf(tax_Pattern));
    }
    public static  Boolean validatePin(String pin,Context m)
    {
       return pin.matches(String.valueOf(pincode_Pattern));
    }

    public static void showError(String message, Context m)
    {
        AlertDialog.Builder builder1=new AlertDialog.Builder(m);
        builder1.setMessage(message);

        builder1.setCancelable(true);
        builder1.setNeutralButton("OK",new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

                dialog.dismiss();
            }
        });

        builder1.show();

    }

  }


 /* public static void mssg(MainActivity m,int i)
      {
        MainActivity mi =m;

            AlertDialog.Builder builder1=new AlertDialog.Builder(m);
           if(i==1)
            builder1.setMessage(" * Fields Should Not Be Empty");
          else if(i==2)
               builder1.setMessage(" Invalid Company Name... Max 15 alphabets");
          else if(i==3)
               builder1.setMessage("  Invalid Tin Number...");
          else if(i==4)
               builder1.setMessage(" Invalid Pan Number");
          else if(i==5)
               builder1.setMessage("  Invalid Service Tax Number...");
          else if(i==6)
               builder1.setMessage("Invalid Pincode... Pincode should be  6 digits ");
          builder1.show();
            builder1.setNeutralButton("OK",new DialogInterface.OnClickListener()
             {
                 @Override
                 public void onClick(DialogInterface dialog, int which)
                 {

                 }
             });

      }*/