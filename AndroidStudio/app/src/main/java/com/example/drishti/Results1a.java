package com.example.drishti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Results1a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results1a);

        TextView result = findViewById(R.id.ResultTextView);
        String Str = CameraModule.responseData;
        result.setText(Str);
        Log.v("test", Str);
    }
}