package com.example.ashar.newcomui_assgn1;

/**
 * Created by ashar on 9/2/17.
 */


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ashar.newcomui_assgn1.json.CustomList;
import com.example.ashar.newcomui_assgn1.json.Object1;
import com.example.ashar.newcomui_assgn1.json.Products;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewInfiniteScrollMain extends AppCompatActivity
{

    private static final String TAG = RecyclerViewInfiniteScrollMain.class.getSimpleName();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<Products> adapterData;
    private Handler handler;  public String result1;
    int pagenumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.infinitescroll_recyclerview);

        handler = new Handler();
        linearLayoutManager = new LinearLayoutManager(RecyclerViewInfiniteScrollMain.this);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        sendRequest();
    }
    private void sendRequest()
    {
        final String JSON_URL = "http://stg.msupply.com/product/api/v1.0/productList";
        Map<String,String> mParams = new HashMap<String, String>();
        mParams.put("category1","Plumbing");
        mParams.put("itemsPerPage","12");
        mParams.put("page", String.valueOf(pagenumber));
        Log.d("sendrequest outside1",""+JSON_URL);
        RequestQueue requestQueue = Volley.newRequestQueue(this);


        JsonObjectRequest strreq = new JsonObjectRequest(JSON_URL, new JSONObject(mParams), new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {

                Log.d("sendrequest", " response " + response);
                showJSON(response);
            }
        },new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError e)
            {
                e.printStackTrace();
            }
        });
        Log.d("sendrequest outside2",""+JSON_URL);
        requestQueue.add(strreq);
        Log.d("sendrequest outside3",""+JSON_URL);
    }
    public void showJSON(JSONObject json)
    {
        String data = json.toString();
        Gson gson = new Gson();
        Log.d("showjason",json.toString());
         Object1 responseData= gson.fromJson(data,Object1.class);
        adapterData = responseData.getMessage().getProducts();

        if(recyclerViewAdapter == null)
        {
            Log.d("if recyclerViewAdapter",""+ recyclerViewAdapter);
            recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), adapterData, recyclerView);
            recyclerView.setAdapter(recyclerViewAdapter);
        }
        else
        {
            Log.d("else",""+recyclerViewAdapter);
            recyclerViewAdapter.appendList(adapterData);
            recyclerViewAdapter.notifyDataSetChanged();
        }

        recyclerViewAdapter.setOnLoadMoreListener(new RecyclerViewAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore()
            {
                Log.d("OnLoadMore",""+recyclerViewAdapter);


             //   adapterData.add(pagenumber,null).getProductEntity().getSearchURL().add(pagenumber,null);
               //recyclerViewAdapter.notifyItemInserted(adapterData.size() - 1);
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Log.d("run",""+pagenumber);
                     // adapterData.remove(adapterData.size() - 1);
                       // recyclerViewAdapter.notifyItemRemoved(adapterData.size());
                        pagenumber++;

                        recyclerViewAdapter.setLoaded();
                        sendRequest();
                    }
                }, 3000);
            }
        });
    }

    /*adapterData.remove(adapterData.size() - 1);
    recyclerViewAdapter.notifyItemRemoved(adapterData.size());
    for (int i = 0; i < 15; i++) {
    adapterData.add("Item" + (adapterData.size() + 1));
    recyclerViewAdapter.notifyItemInserted(adapterData.size());
}
    recyclerViewAdapter.setLoaded();*/
  /*  public void getString(final VolleyCallback callback) {
        final String JSON_URL = "http://stg.msupply.com/product/api/v1.0/productList";
        Map<String, String> mParams = new HashMap<String, String>();
        mParams.put("category1", "Plumbing");
        mParams.put("itemsPerPage", "12");
        for(int i=0;i<=560;i++)
        mParams.put("page"," "+i);
        Log.e("getstring",""+ result1);


        JsonObjectRequest strreq = new JsonObjectRequest(JSON_URL, new JSONObject(mParams), new Response.Listener<JSONObject>() {
            public JSONObject response1;
            String data;

            @Override
            public void onResponse(JSONObject response)
            {
                Log.e("onresponse",""+ result1);

                this.data = response.toString();

                callback.onSuccess(data);

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError e)
            {
                e.printStackTrace();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(strreq);
    }*/


    /*public void onResume()
    {
        Log.e("onresume11",""+ result1);
        super.onResume();
        getString(new VolleyCallback(){
            Object1 responseData;

            @Override
            public void onSuccess(String result)
            {
                result1 = result;
                Gson gson = new Gson();
                 responseData = gson.fromJson(result1, Object1.class);
                recyclerViewAdapter = new RecyclerViewAdapter(RecyclerViewInfiniteScrollMain.this,responseData.getMessage().getProducts(), recyclerView);
                recyclerView.setAdapter(recyclerViewAdapter);

                recyclerViewAdapter.setOnLoadMoreListener(new RecyclerViewAdapter.OnLoadMoreListener() {
                    @Override
                    public void onLoadMore()
                    {
                       // responseData.getMessage().getProducts().add(null);
                        recyclerViewAdapter.notifyItemInserted(responseData.getMessage().getProducts().length - 1);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                responseData.getMessage().getProducts().remove(responseData.getMessage().getProducts().length - 1);
                                recyclerViewAdapter.notifyItemRemoved(responseData.getMessage().getProducts().length);
                                for (int i = 0; i < 15; i++) {
                                    responseData.getMessage().getProducts().add("Item" + (responseData.getMessage().getProducts().length + 1));
                                    recyclerViewAdapter.notifyItemInserted(responseData.getMessage().getProducts().length);
                                }
                                recyclerViewAdapter.setLoaded();
                            }
                        }, 5000);
                    }

                });

            }
            }

        });



}*/
}
