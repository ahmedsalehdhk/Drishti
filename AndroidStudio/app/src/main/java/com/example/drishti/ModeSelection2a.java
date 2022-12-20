package com.example.drishti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ModeSelection2a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection2a);

        //moving back to ModeSelection1
        Button back_btn_2a = (Button)findViewById(R.id.back_btn_2a);
        back_btn_2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(ModeSelection2a.this, ModeSelection1.class);
                startActivity(myintent);
            }
        });

        //opening camera
        Button photoButton = (Button)findViewById(R.id.object_btn);
        ImageView imageView = findViewById(R.id.imageViewtest);











    }
}