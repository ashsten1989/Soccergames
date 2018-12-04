package com.benist.soccergames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class campnouactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campnouactivity);

        final Button gobackButton = (Button) findViewById(R.id.backbutton);
        gobackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(campnouactivity.this, Activity4fields.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String [] usernamearray = intent.getStringArrayExtra("username");
        int [] hoursarray = intent.getIntArrayExtra("hours");
        final TextView text1 = (TextView)findViewById(R.id.numbertext);
        final TextView text2 = (TextView)findViewById(R.id.maxtimetext);
        final TextView text3 = (TextView)findViewById(R.id.freetext);

        final TextView text4 = (TextView)findViewById(R.id.listplayers);
        if  (  (usernamearray.length ==0 ) |  (hoursarray.length ==0 )){
            text1.setText(String.valueOf(0));
            text2.setText(String.valueOf(0));
            text3.setText("YES");
            text4.setText("No Players");
        }
        else

        {
        int max = hoursarray[0];
        for (int i=1; i<hoursarray.length; i++) {
            if (hoursarray[i] > max){
                max = hoursarray[i];
            }
        }
        text1.setText(String.valueOf(usernamearray.length));

        text2.setText(String.valueOf(max));

        if (usernamearray.length < 11){
            text3.setText("YES");
        }
        else{  text3.setText("NO");    }

        String stringtoshow  = "";
        for (int i=1; i<usernamearray.length; i++){
            stringtoshow +=  i+"."  + usernamearray[i-1] +", ";
        }
        stringtoshow+= usernamearray.length + "." + usernamearray[usernamearray.length-1];

        text4.setText(stringtoshow);

        }
    }
}
