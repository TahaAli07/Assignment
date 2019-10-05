package com.example.demoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber;
    EditText editTextPassword;
    Button loginBt;
    String postResponse;
    String token;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.etNumber);
        editTextPassword = findViewById(R.id.etPass);
        loginBt = findViewById(R.id.loginBtn);
        sharedPreferences = getApplicationContext().getSharedPreferences("myPref", 0);
        editor = sharedPreferences.edit();

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post(editTextNumber.getText().toString(), editTextPassword.getText().toString());
            }
        });
    }

    public void post(final String number, final String password) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.42.0.1:3000/api/m/user/login";

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                        postResponse = response;
                        handleResponse(postResponse);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                        Intent intent = new Intent(MainActivity.this, ListActivity.class);
                        intent.putExtra("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiODkiLCJlbWFpbCI6ImthcmFudGhlc3Rhcjk1QGdtYWlsLmNvbSIsInBob25lIjoiODQ0NzQwNDAwMCIsImlhdCI6MTU3MDI2MDIxMiwiZXhwIjoxNTcwODY1MDEyfQ.TVWIQDmC-BAeZhjFdQpCBDor23UcMp_9Uv8xAD8RzDo");
                        startActivity(intent);
                    }
                }

        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user_mobile", "8447404000");
                params.put("password", "12345678");

                return params;
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                if (response.statusCode == 200) {
                    //Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
                return super.parseNetworkResponse(response);
            }

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }
        };

        queue.add(postRequest);
    }

    public void handleResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.has("token")) {
                token = jsonObject.get("token").toString();
                //Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
                editor.putString("token", token);
                editor.commit();
                editor.apply();
                Intent intent = new Intent(this, ListActivity.class);
                intent.putExtra("token", token);
                startActivity(intent);

            } else {
                //token not found in JSON
            }

        } catch (JSONException e) {

            e.printStackTrace();
        }
    }
}
