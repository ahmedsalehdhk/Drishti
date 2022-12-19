package com.example.drishti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class ModeSelection1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection1);

//        Button buttonToCamera = (Button)findViewById(R.id.buttonToCamera);
//        buttonToCamera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    Intent openCamera = new Intent();
//                    openCamera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivity(openCamera);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}