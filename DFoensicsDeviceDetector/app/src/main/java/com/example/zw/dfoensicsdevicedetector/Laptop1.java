package com.example.zw.dfoensicsdevicedetector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Laptop1 extends AppCompatActivity {

    // activity elements
    ImageButton imageButton1;
    ImageButton imageButton2;
    String bpStep1, itemDetected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            itemDetected = extras.getString("key");
        }

        // best practice suggestion btn link1
        imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bpStep1 = "\n\n1.Check for password clues and follow steps below\n\n";
                Intent i = new Intent(Laptop1.this, Laptop2.class);
                i.putExtra("key", itemDetected); //pass name or id
                i.putExtra("key1", bpStep1); //pass name or id
                startActivity(i);

            }
        });

        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bpStep1 = "\n\n1.Device not locked\n\n";
                Intent i = new Intent(Laptop1.this, Laptop2.class);
                i.putExtra("key", itemDetected); //pass name or id
                i.putExtra("key1", bpStep1); //pass name or id
                startActivity(i);

            }
        });
    }
}
