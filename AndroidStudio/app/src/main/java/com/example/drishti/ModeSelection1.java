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

        //moving to ModeSelection2a
        Button object_currency_btn = (Button)findViewById(R.id.object_currency_btn);
        object_currency_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent1 = new Intent(ModeSelection1.this, ModeSelection2a.class);
                startActivity(myintent1);
            }
        });

        //moving to ModeSelection2b
        Button medicine_text_btn = (Button)findViewById(R.id.medicine_text_btn);
        medicine_text_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent2 = new Intent(ModeSelection1.this, ModeSelection2b.class);
                startActivity(myintent2);
            }
        });


    }
}