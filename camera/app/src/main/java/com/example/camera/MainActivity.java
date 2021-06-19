package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button camera;
    ImageView imageView;
    final int request_pic=1;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     camera=(Button)findViewById(R.id.button);
     imageView=(ImageView)findViewById(R.id.iview);
     camera.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);
             Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
             startActivityForResult(intent,request_pic);

             //ll.setBackgroundResource(photo)
         }
     });
    }
    protected void onActivityResult(int request_pic,int request_code,Intent data){
        super.onActivityResult(request_pic,request_code,data);
        Bundle bundle=data.getExtras();
        Bitmap photo=(Bitmap) bundle.get("data");
        imageView.setImageBitmap(photo);
        Drawable draw = new BitmapDrawable(getResources(),photo);
        ll.setBackground(draw);
    }
}