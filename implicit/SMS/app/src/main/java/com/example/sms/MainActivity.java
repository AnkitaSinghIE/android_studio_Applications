package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     TextView tv1;
     EditText sms ,phone;
     Button BUTTON;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.tv1);
        BUTTON=(Button)findViewById(R.id.button);
        phone=(EditText)findViewById(R.id.editTextTextPersonName);
        sms=(EditText)findViewById(R.id.editTextTextPersonName2);
        BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);

                if (phone.getText().toString().isEmpty() || sms.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter valid number or sms", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        SmsManager smgr = SmsManager.getDefault();
                        smgr.sendDataMessage(phone.getText().toString(), null, Short.parseShort(sms.getText().toString()), null, null, null);
                        Toast.makeText(MainActivity.this, "sms send successfully", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "sms not send successfully", Toast.LENGTH_LONG).show();
                    }
                }
            }
            });
        }
    }