package com.example.drishti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeSelection2b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection2b);

        //moving back to ModeSelection1
        Button back_btn_2b = (Button)findViewById(R.id.back_btn_2b);
        back_btn_2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(ModeSelection2b.this, ModeSelection1.class);
                startActivity(myintent);
            }
        });

    }
}