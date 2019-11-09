package com.example.zw.dfoensicsdevicedetector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Laptop2 extends AppCompatActivity {

    // activity elements
    ImageButton imageButton1;
    ImageButton imageButton2;
    String bpStep1, bpStep2, itemDetected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            itemDetected = extras.getString("key");
            bpStep1 = extras.getString("key1");
        }

        // best practice suggestion btn link1
        imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bpStep2 = "2.If Encrypted\n" +
                        "Check for password clues and follow steps below\n\n";
                Intent i = new Intent(Laptop2.this, Laptop3.class);
                i.putExtra("key", itemDetected); //pass name or id
                i.putExtra("key1", bpStep1); //pass name or id
                i.putExtra("key2", bpStep2);
                startActivity(i);

            }
        });

        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bpStep2 = "2.If not encrypted\n" +
                        "Device not encrypted\n\n";
                Intent i = new Intent(Laptop2.this, Laptop3.class);
                i.putExtra("key", itemDetected); //pass name or id
                i.putExtra("key1", bpStep1); //pass name or id
                i.putExtra("key2", bpStep2);
                startActivity(i);

            }
        });

    }

}
