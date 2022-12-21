package com.example.drishti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModeSelection2a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection2a);

        //Back Button Code
        Button back_btn_2a = (Button)findViewById(R.id.back_btn_2a);
        back_btn_2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(ModeSelection2a.this, ModeSelection1.class);
                startActivity(myintent);
            }
        });

        //Opening Camera
        Button currency_btn = (Button)findViewById(R.id.currency_btn);
        currency_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currency_btn_intent = new Intent(ModeSelection2a.this, CameraModule.class);
                startActivity(currency_btn_intent);
            }
        });



    }
    //on create ends here

}   //end of main function
