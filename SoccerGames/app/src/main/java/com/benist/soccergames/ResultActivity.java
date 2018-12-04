package com.benist.soccergames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final Button backfromresult = (Button) findViewById(R.id.backfromresult);
        backfromresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this , Activity2_1.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();

        String [] teamA_array = intent.getStringArrayExtra("teamA");
        String [] teamB_array = intent.getStringArrayExtra("teamB");
        String [] winner_array = intent.getStringArrayExtra("Winner");
        int [] goalsA = intent.getIntArrayExtra("goalsA");
        int [] goalsB = intent.getIntArrayExtra("goalsB");

        int length = teamA_array.length;
        String row = "";
        for(int i=0; i<length; i++){
            row += teamA_array[i] +
                            "   Against   " +
                         teamB_array[i] +
                                    "  :  " +
                                  goalsA[i] +
                                    " - " +
                                  goalsB[i] +"\n"+
                                    "Winner:   " +
                                 winner_array[i].toUpperCase()  + "\n\n" ;


        }
        final TextView text = (TextView)findViewById(R.id.textmultiresult);
        text.setText(row);

        int aa = 3;



    }
}
