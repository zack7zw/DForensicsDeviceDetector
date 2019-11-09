package com.example.zw.dfoensicsdevicedetector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Laptop4 extends AppCompatActivity {

    // activity elements
    ImageButton imageButton1;
    ImageButton imageButton2;
    String bpStep1, bpStep2, bpStep3, bpStep4, itemDetected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            itemDetected = extras.getString("key");
            bpStep1 = extras.getString("key1");
            bpStep2 = extras.getString("key2");
            bpStep3 = extras.getString("key3");
        }

        // best practice suggestion btn link1
        imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bpStep4 = "4.If charging\n" +
                        "Turn off power adapter and remove battery\n\n";
                Intent i = new Intent(Laptop4.this, ResultsPage.class);
                i.putExtra("key", itemDetected); //pass name or id
                i.putExtra("key1", bpStep1); //pass name or id
                i.putExtra("key2", bpStep2);
                i.putExtra("key3", bpStep3);
                i.putExtra("key4", bpStep4);
                startActivity(i);

            }
        });

        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bpStep4 = "4.If on battery\n" +
                        "Remove battery\n\n";
                Intent i = new Intent(Laptop4.this, ResultsPage.class);
                i.putExtra("key", itemDetected); //pass name or id
                i.putExtra("key1", bpStep1); //pass name or id
                i.putExtra("key2", bpStep2);
                i.putExtra("key3", bpStep3);
                i.putExtra("key4", bpStep4);
                startActivity(i);

            }
        });
    }
}
