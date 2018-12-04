package com.benist.soccergames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Activity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Button backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        backbutton = (Button)findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        final EditText plusername = (EditText) findViewById(R.id.playerusername);
        final EditText playerpassword = (EditText) findViewById(R.id.playerpassword);
        final EditText plage = (EditText) findViewById(R.id.playerage);
        final EditText plrule = (EditText) findViewById(R.id.playerrule);
        final EditText plteam = (EditText) findViewById(R.id.playerteam);
        final EditText plhours = (EditText) findViewById(R.id.playerhours);
        final Button regbutton = (Button) findViewById(R.id.registerbutton);
        //spinner
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Fields,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = plusername.getText().toString();
                final String password = playerpassword.getText().toString();
                final int age = Integer.parseInt(plage.getText().toString());
                final String rule = plrule.getText().toString();
                final int hours = Integer.parseInt(plhours.getText().toString());
                final String team = plteam.getText().toString();
                final String field = spinner.getSelectedItem().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success){
                                Intent intent = new Intent(Activity2.this, MainActivity.class );
                                Activity2.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Activity2.this);
                                builder.setMessage("Registration failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(
                        field,
                        team,
                        rule,
                        hours,
                        age,
                        username,
                        password,responseListener
                );
                RequestQueue queue = Volley.newRequestQueue(Activity2.this);
                queue.add(registerRequest);
            }
        });
    }
    private void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
