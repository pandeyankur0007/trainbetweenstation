package com.example.ankur.trainbetweenstation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class TrainBetweenStationInfo extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_between_station_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("TrainBetweenStation");

        listView = (ListView) findViewById(R.id.listView1);

        Intent intent = getIntent();

        String result1 = intent.getStringExtra("FromCode");
        String result2 = intent.getStringExtra("ToCode");
        String dateandmonth = intent.getStringExtra("DOJ");

        String JSON_URL = "http://api.railwayapi.com/between/source/"+result1+"/dest/"+result2+"/date/"+dateandmonth+"/apikey/rigng1122/";

        sendRequest(JSON_URL);

    }

    private void sendRequest(String jsonUrl) {
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();
        StringRequest stringRequest = new StringRequest(jsonUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pDialog.hide();
                showJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TrainBetweenStationInfo.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json) {
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        CustomList cl = new CustomList(this, ParseJSON.no, ParseJSON.name, ParseJSON.number);
        listView.setAdapter(cl);
    }
}
