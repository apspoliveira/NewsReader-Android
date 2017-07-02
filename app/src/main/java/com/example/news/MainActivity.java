package com.example.news;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.news.R;

public class MainActivity extends AppCompatActivity  {

    String url = "https://newsapi.org/v1/articles?source=buzzfeed&sortBy=top&apiKey=756dee8e408547e68922678c21d9fcdf";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Result handling
                        tv = (TextView) findViewById(R.id.jsonData);
                        System.out.println(response);
                        tv.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("Something went wrong!");
                volleyError.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
