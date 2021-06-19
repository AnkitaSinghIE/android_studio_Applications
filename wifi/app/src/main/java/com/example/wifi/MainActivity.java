package com.example.wifi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch aswitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aswitch=(Switch)findViewById(R.id.switch1);
        aswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
             ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CHANGE_WIFI_STATE},1);
                if(b==true)
                {
                    WifiManager wifiManager=(WifiManager)getSystemService(getApplicationContext().WIFI_SERVICE);
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(getApplicationContext(),"wifi on",Toast.LENGTH_LONG).show();

                }
                else
                {
                    WifiManager wifiManager=(WifiManager)getSystemService(getApplicationContext().WIFI_SERVICE);
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(getApplicationContext(),"wifi off",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}