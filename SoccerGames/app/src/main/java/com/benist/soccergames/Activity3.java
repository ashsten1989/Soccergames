package com.benist.soccergames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Activity3 extends AppCompatActivity {
    private Button buttonback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
        final EditText loginusername = (EditText) findViewById(R.id.loginusername);
        final  EditText loginpassword = (EditText) findViewById(R.id.loginpassword);

        final Button buttonlogin = (Button) findViewById(R.id.buttonlogin);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = loginusername.getText().toString();
                final String password = loginpassword.getText().toString();
                //create RESPONSE
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){
                                String field = jsonResponse.getString("field");
                                String team = jsonResponse.getString("team");
                                String rule = jsonResponse.getString("rule");
                                Integer hours = jsonResponse.getInt("hours");
                                Integer age = jsonResponse.getInt("age");

                                Intent intent = new Intent(Activity3.this, Activity2_1.class);
                                intent.putExtra("username",username);
                                intent.putExtra("field", field);
                                intent.putExtra("team", team);
                                intent.putExtra("rule", rule);
                                intent.putExtra("hours", hours);
                                intent.putExtra("age", age);

                                Activity3.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Activity3.this);
                                builder.setMessage("Login failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            AlertDialog.Builder builder = new AlertDialog.Builder(Activity3.this);
                            builder.setMessage("Login failed!!!!!!")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(username,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Activity3.this);
                queue.add(loginRequest);
            }
        });
    }
    private void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}