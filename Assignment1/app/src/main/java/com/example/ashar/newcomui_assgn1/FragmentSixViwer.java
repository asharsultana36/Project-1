package com.example.ashar.newcomui_assgn1; /**
 * Created by ashar on 2/2/17.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashar.newcomui_assgn1.R;


public class FragmentSixViwer extends Fragment
{

    public FragmentSixViwer()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragmentsixviwer, container, false);
    }

}