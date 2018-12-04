package com.benist.soccergames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Activity4fields extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4fields);

        final Button backbutton = (Button) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        final Button buttonalianz = (Button) findViewById(R.id.buttonalianz);
        buttonalianz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    public void onResponse(String response) {
                        try {
                            JSONObject jo = new JSONObject(response);
                            JSONArray jsonArray = jo.getJSONArray("datafield");
                            int length = jsonArray.length();
                            String[] username = new String[length];
                            int[] hours = new int[length];

                            for (int i = 0; i < length; i++) {
                                JSONObject joi = jsonArray.getJSONObject(i);
                                username[i] = joi.getString("username");
                                hours[i] = Integer.parseInt(joi.getString("hours"));
                            }

                            Intent intent = new Intent(Activity4fields.this, alianzfieldactivity.class);
                            intent.putExtra("username",username);
                            intent.putExtra("hours", hours);
                            Activity4fields.this.startActivity(intent);

                        }catch (JSONException e) {
                            e.printStackTrace();
                            AlertDialog.Builder builder = new AlertDialog.Builder(Activity4fields.this);
                            builder.setMessage("enter to field is failed!!!!!!")
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();
                        }
                    }};
                Button b = (Button)v;
                String field = b.getText().toString();
                DataRequest dataRequest = new DataRequest(field,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Activity4fields.this);
                queue.add(dataRequest);
            }
        });

        final Button buttonsantiago = (Button) findViewById(R.id.buttonsantiago);
        buttonsantiago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    public void onResponse(String response) {
                        try {
                            JSONObject jo = new JSONObject(response);
                            JSONArray jsonArray = jo.getJSONArray("datafield");
                            int length = jsonArray.length();
                            String[] username = new String[length];
                            int[] hours = new int[length];

                            for (int i = 0; i < length; i++) {
                                JSONObject joi = jsonArray.getJSONObject(i);
                                username[i] = joi.getString("username");
                                hours[i] = Integer.parseInt(joi.getString("hours"));
                            }

                            Intent intent = new Intent(Activity4fields.this, santiagofieldactivty.class);
                            intent.putExtra("username",username);
                            intent.putExtra("hours", hours);
                            Activity4fields.this.startActivity(intent);

                        }catch (JSONException e) {
                            e.printStackTrace();
                            AlertDialog.Builder builder = new AlertDialog.Builder(Activity4fields.this);
                            builder.setMessage("enter to field is failed!!!!!!")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                        }
                    }};
                Button b = (Button)v;
                String field = b.getText().toString();
                DataRequest dataRequest = new DataRequest(field,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Activity4fields.this);
                queue.add(dataRequest);
            }
        });

        final Button buttontoto = (Button) findViewById(R.id.buttontoto);
        buttontoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    public void onResponse(String response) {
                        try {
                            JSONObject jo = new JSONObject(response);
                            JSONArray jsonArray = jo.getJSONArray("datafield");
                            int length = jsonArray.length();
                            String[] username = new String[length];
                            int[] hours = new int[length];

                            for (int i = 0; i < length; i++) {
                                JSONObject joi = jsonArray.getJSONObject(i);
                                username[i] = joi.getString("username");
                                hours[i] = Integer.parseInt(joi.getString("hours"));
                            }
                            Intent intent = new Intent(Activity4fields.this, terneractivity.class);
                            intent.putExtra("username",username);
                            intent.putExtra("hours", hours);
                            Activity4fields.this.startActivity(intent);

                        }catch (JSONException e) {
                            e.printStackTrace();
                            AlertDialog.Builder builder = new AlertDialog.Builder(Activity4fields.this);
                            builder.setMessage("enter to field is failed!!!!!!")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                        }
                    }};
                Button b = (Button)v;
                String field = b.getText().toString();
                DataRequest dataRequest = new DataRequest(field,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Activity4fields.this);
                queue.add(dataRequest);
            }
        });

        final Button buttonampnou = (Button) findViewById(R.id.buttoncampnou);
        buttonampnou.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Response.Listener<String> responseListener = new Response.Listener<String>(){
                public void onResponse(String response) {
                    try {
                        JSONObject jo = new JSONObject(response);
                        JSONArray jsonArray = jo.getJSONArray("datafield");
                        int length = jsonArray.length();
                        String[] username = new String[length];
                        int[] hours = new int[length];

                        for (int i = 0; i < length; i++) {
                            JSONObject joi = jsonArray.getJSONObject(i);
                            username[i] = joi.getString("username");
                            hours[i] = Integer.parseInt(joi.getString("hours"));
                        }
                        Intent intent = new Intent(Activity4fields.this, campnouactivity.class);
                        intent.putExtra("username",username);
                        intent.putExtra("hours", hours);
                        Activity4fields.this.startActivity(intent);

                    }catch (JSONException e) {
                        e.printStackTrace();
                        AlertDialog.Builder builder = new AlertDialog.Builder(Activity4fields.this);
                        builder.setMessage("enter to field is failed!!!!!!")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }
                }};
            Button b = (Button)v;
            String field = b.getText().toString();
            DataRequest dataRequest = new DataRequest(field,responseListener);
            RequestQueue queue = Volley.newRequestQueue(Activity4fields.this);
            queue.add(dataRequest);
        }
    });

    }
    private void openMain () {
        Intent intent = new Intent(this, Activity2_1.class);
        startActivity(intent);
    }
}
