package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button btnView, btnSave, btn2;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etText);
        textView = (TextView) findViewById(R.id.tvText);

        btnSave = findViewById(R.id.btnSave);
        btnView = findViewById(R.id.btnView);
        btn2 = findViewById(R.id.btn2);

        btnSave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
            sharedpreferences = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("Value", editText.getText().toString());
            editor.apply();
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(sharedpreferences.getString("Value", "Data Not Found"));

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SecondAct.class);
                startActivity(intent);
            }
        });

    }

}