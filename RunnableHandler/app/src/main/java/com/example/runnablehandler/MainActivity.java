package com.example.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Runnable runnable;
    Handler handler;
    int number;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        button = findViewById(R.id.button);
        number=0;
    }
    public void start(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("time "+number);
                number++;
                textView.setText("time: "+number);
                handler.postDelayed(runnable,1000);
                //her sn başı bu işlemi benim için yap
            }
        };
        handler.post(runnable);
        button.setEnabled(false);//buton tıklanamaz hale geliyor bu kod sayesinde
    }
    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        number=0;
        textView.setText("time: "+number);
    }
}