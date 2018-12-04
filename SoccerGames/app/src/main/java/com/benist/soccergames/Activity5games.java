package com.benist.soccergames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Random;

public class Activity5games extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity5games);
        final ArrayList<String> teamslist = new ArrayList<String>();
        final Spinner spinnerA = (Spinner) findViewById(R.id.teamAspinner);
        final Spinner spinnerB = (Spinner) findViewById(R.id.teamBspinner);
        final Button back2 = (Button) findViewById(R.id.back2);
        final Button generateresults = (Button) findViewById(R.id.generateresults);
        final Button buttonisdone = (Button) findViewById(R.id.buttonisdone);
        final TextView text1 = (TextView)findViewById(R.id.num1);
        final TextView text2 = (TextView)findViewById(R.id.num2);
        final TextView text3 = (TextView)findViewById(R.id.winner);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity5games.this , Activity2_1.class);
                startActivity(intent);
            }
        });

        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,teamslist);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerA.setAdapter(dataAdapter);
        spinnerB.setAdapter(dataAdapter);

        spinnerA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Activity5games.this,teamslist.get(i), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {      }
        });
        spinnerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(Activity5games.this, teamslist.get(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {   }
        });

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    int length = response.length();
                    String temp = "";
                    teamslist.add("Choose Team");
                    for (int i=0; i<length-2; i++) {
                        while ((response.charAt(i) == ',') || response.charAt(i) =='\n' || response.charAt(i) =='\r' ) {
                            i++;
                        }
                        while ((response.charAt(i) != ',') && (i < length-3) ) {
                            temp +=  response.charAt(i);
                            i++;
                        }
                        if (!(teamslist.contains(temp))){
                            teamslist.add(temp);
                        }
                        temp = "";
                        if (i > length-3)
                        {
                            int a =5;
                            break;
                        }
                    }
                    //teamslist.remove(0);
                    dataAdapter.notifyDataSetChanged();
                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Activity5games.this);
                    builder.setMessage("teams from database failed")
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();
                }
            }
        };
        teamsrequest tr = new teamsrequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(Activity5games.this);
        queue.add(tr);

        generateresults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int min = 0;
                int max = 6;
                int result1 = new Random().nextInt((max - min) + 1) + min;
                int result2 = new Random().nextInt((max - min) + 1) + min;
                text1.setText(String.valueOf(result1));
                text2.setText(String.valueOf(result2));
                final String winner;
                if (result1 > result2) {winner = spinnerA.getSelectedItem().toString();}
              else  if (result2 > result1) {winner = spinnerB.getSelectedItem().toString();}
                else {winner = "TIE";}
                text3.setText(winner);

            }
        });
        buttonisdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String teamA = spinnerA.getSelectedItem().toString();
                final String teamB = spinnerB.getSelectedItem().toString();
                final int goalsA = Integer.parseInt(text1.getText().toString());
                final int goalsB = Integer.parseInt(text2.getText().toString());
                final String Winner;

                if (goalsA > goalsB) {Winner = teamA;}
                else  if (goalsB > goalsA) {Winner = teamB;}
                else {Winner = "TIE";}

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{
                            Intent intent = new Intent(Activity5games.this,Activity2_1.class);
                            startActivity(intent);

                        }catch (Exception e){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Activity5games.this);
                            builder.setMessage("taaa failed")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                        }
                    }
                };
                teamsrequest teamreq = new teamsrequest(teamA,teamB,goalsA,goalsB,Winner,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Activity5games.this);
                queue.add(teamreq);
            }
        });






    }
}

