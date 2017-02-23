package com.example.ashar.newcomui_assgn1;

/**
 * Created by ashar on 9/2/17.
 */
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
public class ProgressViewHolder extends /*RecyclerViewHolders*/RecyclerView.ViewHolder{
    public ProgressBar progressBar;
    public ProgressViewHolder(View itemView) {
        super(itemView);
        progressBar = (ProgressBar)itemView.findViewById(R.id.progressBar1);
    }
}