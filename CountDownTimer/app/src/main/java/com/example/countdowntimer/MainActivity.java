package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        new CountDownTimer(10000, 1000) {
            //10000 yazan yer milisaniye cinsinden 10 dan geriye başlatır
            //1000 ise kaç snde bir ne olsun
            //ontick metodu her sn ben napıyım onu yazdığımız yer
            //onfinish ise bitince olacak şey
            @Override
            public void onTick(long l) {
                textView.setText("Left: "+l/1000);
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"done!",Toast.LENGTH_LONG).show();
                textView.setText("Finished!");
            }
        }.start();
    }
}