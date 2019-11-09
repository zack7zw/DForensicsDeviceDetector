package com.example.zw.dfoensicsdevicedetector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ResultsPage extends AppCompatActivity {

    // activity elements
    Button btnreturn;
    String bpStep1, bpStep2, bpStep3, bpStep4, finalRes, itemDetected;
    TextView lblresults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultspage);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            itemDetected = extras.getString("key");
            bpStep1 = extras.getString("key1");
            bpStep2 = extras.getString("key2");
            bpStep3 = extras.getString("key3");
            bpStep4 = extras.getString("key4");
        }

        finalRes = bpStep1 + bpStep2 + bpStep3 + bpStep4;
        //remove null
        finalRes = finalRes.replace("null","");

        if (itemDetected.equals("laptop")){
            finalRes = itemDetected + finalRes + "5.Record down the device model, serial numbers and passwords (if any).\n\n" +
                    "6.Clone the hard disk/ssd using cloning software with the help of a forensic imager or write blocker to prevent any writing to the original data. (Could be done using the dd command in Kali Linux)\n\n" +
                    "7.Check the hash value of the original data to the cloned image and ensure that their hashed value is the same. (Run sha256sum command in Kali Linux on the original data as well as the cloned image. The value returned should be the same.)\n\n" +
                    "8.Never work on the original data to maintain forensic soundness.\n\n" +
                    "9.Package the data storage equipment away using anti-static evidence bags.\n\n" +
                    "10.Document all the steps used during the seizure.\n\n";
        }
        else if (itemDetected.equals("smartphone")){
            finalRes = itemDetected + finalRes + "3.Do a manual extraction using tools like EDEC Eclipse, Fernico ZRT and Project-A-Phone\n\n" +
                    "4.Upon finishing, do a hex dump using Cellebrite or Pandora’s box\n\n";
        }
        else if (itemDetected.equals("thumb drive")){
            finalRes = itemDetected + finalRes + "4.Clone an image using a forensic imager or write blocker (Could be done using the dd command in Kali Linux).\n\n" +
                    "5.Ensure that the cloned image and the original data hashed value matches each other. (Run sha256sum command in Kali Linux on the original data as well as the cloned image. The value returned should be the same.)\n\n" +
                    "6.Label the original data hashed value and never work on the original data to maintain forensic soundness.\n\n" +
                    "7.Package the storage media away using anti-static evidence bags.\n\n" +
                    "8.Document all the steps used during the seizure.\n\n";
        }
        else if (itemDetected.equals("ram sticks")){
            finalRes = itemDetected + finalRes + "1.Creating a RAM Memory Image could be done using free software like DumpIT\n\n" +
                    "2.The image can be analyzed using open source tools like Volatility which is already present in Kali Linux.\n\n" +
                    "3.Using Volatility -f command, user will be able to see Operating System information, running processes and network connections.\n\n" +
                    "4.With the dumpregistry plug-in, registry files can be extracted.\n\n" +
                    "5.With certain software like Registry Report, a general report with all the information found in the registry files could be generated.\n\n";
        }
        else if (itemDetected.equals("hard disk")){
            finalRes = itemDetected + finalRes + "1.Record down the device model, serial numbers and passwords (if any).\n\n" +
                    "2.Clone the hard disk/ssd using cloning software with the help of a forensic imager or write blocker to prevent any writing to the original data. (Could be done using the dd command in Kali Linux)\n\n" +
                    "3.Check the hash value of the original data to the cloned image and ensure that their hashed value is the same. (Run sha256sum command in Kali Linux on the original data as well as the cloned image. The value returned should be the same.)\n\n" +
                    "4.Never work on the original data to maintain forensic soundness.\n\n" +
                    "5.Package the data storage equipment away using anti-static evidence bags.\n\n" +
                    "6.Document all the steps used during the seizure.\n\n";
        }
        else if (itemDetected.equals("solid state drive")){
            finalRes = itemDetected + finalRes + "1.Record down the device model, serial numbers and passwords (if any).\n\n" +
                    "2.Clone the hard disk/ssd using cloning software with the help of a forensic imager or write blocker to prevent any writing to the original data. (Could be done using the dd command in Kali Linux)\n\n" +
                    "3.Check the hash value of the original data to the cloned image and ensure that their hashed value is the same. (Run sha256sum command in Kali Linux on the original data as well as the cloned image. The value returned should be the same.)\n\n" +
                    "4.Never work on the original data to maintain forensic soundness.\n\n" +
                    "5.Package the data storage equipment away using anti-static evidence bags.\n\n" +
                    "6.Document all the steps used during the seizure.\n\n";
        }
        else if (itemDetected.equals("drone")){
            finalRes = itemDetected + finalRes + "1.Turn off drone and isolate the device from any outside connections.\n\n" +
                    "2.Document the teardown of the drone.\n\n" +
                    "3.Identify where is the data storage placed in.\n\n" +
                    "4.Check the serial number of the drone in case it could be traced back to the buyer.\n\n" +
                    "5.Image the storage content and review it.\n\n" +
                    "6.Use Forensic Toolkit like FTK to extract data from the storage.\n\n" +
                    "a.Some drones could be controlled using smartphones or tablets. Therefore, some of the data stored inside the storage might contain the user accounts, drone manufacturer’s cloud, flight log files, images and videos. \n\n" +
                    "b.Using ‘Oxygen Forensic Detective’, not only digital evidence could be extracted, it can also allow decoding, parsing and presenting the data in a readable form. \n\n";
        }
        else {finalRes = itemDetected + "\n\n Item does not contain any storage capability, do package the item into a evidence bag for further collection of evidence such as finger print";}

        lblresults = (TextView) findViewById(R.id.lblResults);
        lblresults.setText(finalRes);
        // best practice suggestion btn link1
        btnreturn = (Button) findViewById(R.id.btnReturn);
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultsPage.this, LoadModel.class);
                startActivity(i);

            }
        });

    }
}
