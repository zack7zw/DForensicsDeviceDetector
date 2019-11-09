package com.example.zw.dfoensicsdevicedetector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class USB1 extends AppCompatActivity {

    // activity elements
    ImageButton imageButton1;
    ImageButton imageButton2;
    String bpStep1, itemDetected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubs1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            itemDetected = extras.getString("key");
        }

        // best practice suggestion btn link1
        imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bpStep1 = "\n\n1.Check if it is running a suspicious process\n\n";
                Intent i = new Intent(USB1.this, USB2.class);
                i.putExtra("key", itemDetected); //pass name or id
                i.putExtra("key1", bpStep1); //pass name or id
                startActivity(i);

            }
        });

        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bpStep1 = "\n\n1.Device is plugged out\n\n";
                Intent i = new Intent(USB1.this, USB2.class);
                i.putExtra("key", itemDetected); //pass name or id
                i.putExtra("key1", bpStep1); //pass name or id
                startActivity(i);

            }
        });
    }
}
