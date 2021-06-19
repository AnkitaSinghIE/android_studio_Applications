package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        final int request=0;

       final BluetoothAdapter bluetoothAdapter= BluetoothAdapter.getDefaultAdapter();
       if(bluetoothAdapter==null){
           Toast.makeText(getApplicationContext(),"Bluetooth not supported",Toast.LENGTH_LONG).show();
       }
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(bluetoothAdapter.isEnabled()){
                   Intent benable = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                   startActivityForResult(benable,request);

               }
           }
       });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               bluetoothAdapter.disable();
           }
       });
    }
}