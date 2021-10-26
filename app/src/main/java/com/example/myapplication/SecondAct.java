package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SecondAct extends AppCompatActivity {

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvData = findViewById(R.id.tvData);
        SharedPreferences result = getSharedPreferences("SaveData", Context.MODE_PRIVATE);

        String value = result.getString("Value", "Data Not found");
        tvData.setText(value);

    }
}