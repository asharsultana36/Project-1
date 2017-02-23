package com.example.ashar.newcomui_assgn1;

/**
 * Created by ashar on 9/2/17.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ashar.newcomui_assgn1.json.Products;

import java.util.List;
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private List<String> itemList;
    protected Context context;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private OnLoadMoreListener onLoadMoreListener;
    List<Products> productses;
    static int count=0;


    public RecyclerViewAdapter(Context context, List<Products> productses, RecyclerView recyclerView)
    {
        this.productses = productses;

        this.itemList = itemList;
        this.context = context;

        if(recyclerView.getLayoutManager() instanceof LinearLayoutManager)
        {

            Log.d("if onscroll1",""+productses);
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @SuppressLint("LongLogTag")
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy)
                {
                    count++;
                    Log.d("if on scrolled2",""+count);
                    super.onScrolled(recyclerView, dx, dy);
                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if(!loading && totalItemCount <= (lastVisibleItem + visibleThreshold))
                    {

                        if(onLoadMoreListener != null)
                        {
                            Log.d("if onscroll onloadmorelistener3",""+onLoadMoreListener);
                            onLoadMoreListener.onLoadMore();
                        }
                        Log.d("out of if4",""+loading);
                        loading = true;
                    }
                }
            });
        }
    }
    @Override
    public int getItemViewType(int position)
    {
        Log.d("getItemViewType",""+position);
        return productses.get(position).getProductEntity().getSearchURL() != null ? 1 : 0;
        //Log.d("getItemViewType",""+position);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Log.d(" onCreateViewHolder",""+viewType);
        RecyclerView.ViewHolder viewHolder = null;
        if(viewType == 1)
        {
            Log.d(" if view type onCreateViewHolder",""+parent);

            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.infinitescroll_listitems, parent, false);
            viewHolder = new RecyclerViewHolders(layoutView);
        }
        else
        {
            Log.d(" else view type onCreateViewHolder progressbar",""+parent);
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.infinitescroll_progressbar, parent, false);
            viewHolder = new ProgressViewHolder(layoutView);
        }
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        Log.d(" onBindViewHolder",""+position);
        if(/*getItemViewType(position) == 1*/holder instanceof RecyclerViewHolders)
        {
            Log.d(" if onBindViewHolder",""+holder);
            ((RecyclerViewHolders)holder).textTitle.setText(productses.get(position).getProductEntity().getSearchURL());
        }
        else
        {
            Log.d(" else onBindViewHolder",""+holder);
            ((ProgressViewHolder)holder).progressBar.setIndeterminate(true);
        }
    }
    public void setLoad()
    {
        Log.d(" setload",""+loading);
        loading = false;
    }
    @Override
    public int getItemCount()
    {
        Log.d(" getItemCount",""+productses.size());
        return productses.size();
    }
    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener)
    {
        Log.d(" setOnLoadMoreListener",""+onLoadMoreListener);
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public void appendList(List<Products> adapterData)
    {
        Log.d(" appendList",""+adapterData);
        productses.addAll(adapterData);
    }

    public interface OnLoadMoreListener
    {

        void onLoadMore();
    }
    public void setLoaded()
    {
        Log.d(" setLoaded",""+loading);

        loading = false;
    }
}
