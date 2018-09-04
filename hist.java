package com.skyapps.akash.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by akash on 15-01-2018.
 */

public class hist extends Activity {
    Button bclear;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.histlay);
        bclear = (Button)findViewById(R.id.buttonClear);
        DatabaseHandle db = new DatabaseHandle(getApplicationContext());
        TextView t=(TextView)findViewById(R.id.texthist);
        StringBuilder str = new StringBuilder();
        for(String item : db.getAllLabels()){
            str.append(item+"\n");
        }
        t.setText(str.toString());
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandle db = new DatabaseHandle(getApplicationContext());
                db.clear();
                Intent i = new Intent(hist.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
