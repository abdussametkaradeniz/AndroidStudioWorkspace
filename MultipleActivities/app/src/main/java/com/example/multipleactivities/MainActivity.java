package com.example.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);



    }
    public void activityChange(View view){
        String UserName = name.getText().toString();
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("UserInput",UserName);
        startActivity(intent);
    }
}