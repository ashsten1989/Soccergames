package com.benist.soccergames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Activity2_1 extends AppCompatActivity {

    private Button buttonExit;
    private Button fieldbutton;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_1);

        buttonExit = (Button)findViewById(R.id.buttonExit);
        fieldbutton = (Button) findViewById(R.id.buttonfields);
        final TextView wellcomeMessage1 = (TextView) findViewById(R.id.welcomemessage1);
        final TextView wellcomeMessage2 = (TextView) findViewById(R.id.welcomemessage2);
        final Button creategamebutton = (Button) findViewById(R.id.creategamebutton);
        final Button resultbutton = (Button)findViewById(R.id.resultbutton);

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
        fieldbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        creategamebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2_1.this, Activity5games.class);
                startActivity(intent);
            }
        });
        resultbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try{
                            JSONObject jo = new JSONObject(response);
                            JSONArray jsonArray = jo.getJSONArray("datafield");
                            int length = jsonArray.length();
                            String[] teamA = new String[length];
                            String[] teamB = new String[length];
                            int[] goalsA = new int[length];
                            int[] goalsB = new int[length];
                            String[] Winner = new String[length];
                            for (int i = 0; i < length; i++) {
                                JSONObject joi = jsonArray.getJSONObject(i);
                                teamA[i] = joi.getString("teamA");
                                teamB[i] = joi.getString("teamB");
                                goalsA[i] = Integer.parseInt(joi.getString("goalsA"));
                                goalsB[i] = Integer.parseInt(joi.getString("goalsB"));
                                Winner[i] = joi.getString("Winner");
                            }
                            Intent intent = new Intent(Activity2_1.this, ResultActivity.class);
                            intent.putExtra("teamA",teamA);
                            intent.putExtra("teamB",teamB);
                            intent.putExtra("goalsA", goalsA);
                            intent.putExtra("goalsB", goalsB);
                            intent.putExtra("Winner", Winner);
                            startActivity(intent);
                        }catch (JSONException e){
                            e.printStackTrace();
                            AlertDialog.Builder builder = new AlertDialog.Builder(Activity2_1.this);
                            builder.setMessage("Login failed!!!!!!")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                        }
                    }
                };
                ResultRequest resultRequest = new ResultRequest(responseListener);
                RequestQueue queue = Volley.newRequestQueue(Activity2_1.this);
                queue.add(resultRequest);
            }
        });

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String rule = intent.getStringExtra("rule");
        Integer hours = intent.getIntExtra("hours",-1);
        Integer age = intent.getIntExtra("age" , -1);
        String field = intent.getStringExtra("field");
        String team = intent.getStringExtra("team");
        String message1 = "Welcome: " + username + "Field is: " + field + " Team is: " + team ;
        String message2 = "Your Rule Is: " + rule + " Age: " + age + " Hours: " + hours ;
        wellcomeMessage1.setText(message1);
        wellcomeMessage2.setText(message2);
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void openActivity4() {
        Intent intent = new Intent(this, Activity4fields.class);
        startActivity(intent);
    }
}
