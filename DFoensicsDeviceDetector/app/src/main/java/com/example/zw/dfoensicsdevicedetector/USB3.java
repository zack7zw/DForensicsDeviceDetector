package com.example.zw.dfoensicsdevicedetector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class USB3 extends AppCompatActivity {

    // activity elements
    ImageButton imageButton1;
    ImageButton imageButton2;
    String bpStep1, bpStep2, bpStep3, itemDetected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usb3);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            itemDetected = extras.getString("key");
            bpStep1 = extras.getString("key1");
            bpStep2 = extras.getString("key2");
        }

        // best practice suggestion btn link1
        imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bpStep3 = "3.If destructive program\n" +
                        "Remove device from computer immediately\n\n";
                Intent i = new Intent(USB3.this, ResultsPage.class);
                i.putExtra("key", itemDetected); //pass name or id
                i.putExtra("key1", bpStep1); //pass name or id
                i.putExtra("key2", bpStep2);
                i.putExtra("key3", bpStep3);
                startActivity(i);

            }
        });

        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bpStep3 = "3.If no destructive program\n" +
                        "collect all live data, starting with RAM image to other live data such as network connection state, \n" +
                        "logged on users and currently executing processes. (Can be done using forensic tools like FTK Imager, Helix3 or Wind32dd)\n\n";
                Intent i = new Intent(USB3.this, ResultsPage.class);
                i.putExtra("key", itemDetected); //pass name or id
                i.putExtra("key1", bpStep1); //pass name or id
                i.putExtra("key2", bpStep2);
                i.putExtra("key3", bpStep3);
                startActivity(i);

            }
        });
    }
}
