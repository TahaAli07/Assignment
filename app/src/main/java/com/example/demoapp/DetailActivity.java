package com.example.demoapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.utils.Cuisine;
import com.example.utils.JsonParser;
import com.example.utils.MenuItemModel;
import com.example.utils.RestaurantModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {

    String id;
    SharedPreferences sharedPreferences;
    String token;
    RequestQueue queue;

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    JsonParser jsonParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recyclerView = findViewById(R.id.detailRView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        jsonParser = new JsonParser();

        id = getIntent().getStringExtra("id");

        queue = Volley.newRequestQueue(this);

        sharedPreferences = getApplicationContext().getSharedPreferences("myPref", 0);
        token = sharedPreferences.getString("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiODkiLCJlbWFpbCI6ImthcmFudGhlc3Rhcjk1QGdtYWlsLmNvbSIsInBob25lIjoiODQ0NzQwNDAwMCIsImlhdCI6MTU3MDI2MDIxMiwiZXhwIjoxNTcwODY1MDEyfQ.TVWIQDmC-BAeZhjFdQpCBDor23UcMp_9Uv8xAD8RzDo");

        get();
    }

    public void get() {
        final String url = "http://10.42.0.1:3000/api/m/menu/?restaurant_id=" + id;

        // prepare the Request
        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // display response
                        Log.d("Response", response.toString());
                        handleResponse(response.toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + token);
                return headers;
            }
        };

        // add it to the RequestQueue
        queue.add(getRequest);
    }

    public void handleResponse(String response) {

        List<MenuItemModel> list = jsonParser.parseMenu(response);

        mAdapter = new DetailAdapter(list, DetailActivity.this);
        recyclerView.setAdapter(mAdapter);
    }
}
