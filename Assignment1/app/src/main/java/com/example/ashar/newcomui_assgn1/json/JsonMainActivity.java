package com.example.ashar.newcomui_assgn1.json;

/**
 * Created by ashar on 13/2/17.
 */

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.util.Log;
import android.view.View;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;
import com.example.ashar.newcomui_assgn1.R;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class JsonMainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button buttonGet;

    private ListView listView;
    List<Products> productses;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_activity_main);

        buttonGet = (Button) findViewById(R.id.buttonGet);
        buttonGet.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listView);
    }



    private void sendRequest()
    {
        final String JSON_URL = "http://stg.msupply.com/product/api/v1.0/productList";


        Map<String,String> mParams = new HashMap<String, String>();
        mParams.put("category1","Plumbing");
        mParams.put("itemsPerPage","12");
        mParams.put("page", "0");

        JsonObjectRequest strreq = new JsonObjectRequest(JSON_URL, new JSONObject(mParams), new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                Log.d("jsonmain", " response " + response);
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
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(strreq);
        }

    public void showJSON(JSONObject json)
    {
        String data = json.toString();
        Gson gson = new Gson();
        Log.e("hello",json.toString());
        Object1 responseData = gson.fromJson(data,Object1.class);
        Log.d("Test", "responseData "+responseData.getMessage().getImagePrefixURL());
        Log.d("Test", "responseData "+responseData.getMessage().getTotalCount());
        Log.d("Test", "responseData "+responseData.getMessage().getProducts().size());
        Log.d("Test", "responseData "+responseData.getMessage().getTotalPages());
       // Log.d("Test", "responseData "+ responseData.getMessage().getProducts().getProductEntity().getSearchURL());


    /*   for(int i=0;i<=responseData.getMessage().getProducts().length;i++)
        {
            Products products = responseData.getMessage().getProducts()[i];
            Log.d("productentity","searchurl"+ products.getProductEntity().getSearchURL());
        }*/

      /*  ParseJSON pj = new ParseJSON(data);
        pj.parseJSON();*/
        productses = responseData.getMessage().getProducts();
        CustomList cl = new CustomList(this, productses);
        listView.setAdapter(cl);
        //Log.d("Test", "responseData "+ responseData.getMessage().getProducts()[0].getProductEntity().getIdentifier().getSkuId());

    }

    @Override
    public void onClick(View v) {
        sendRequest();
    }
}
