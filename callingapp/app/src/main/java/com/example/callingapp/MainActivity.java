package com.example.callingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText te;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        te=(EditText)findViewById(R.id.TextPhone);
        iv=(ImageView)findViewById(R.id.imageView);
        iv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                String number=te.getText().toString();
                if(number.trim().length()==10)
                {
                    String dial="tel:"+number;
                    startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"enter valid number",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}