package com.example.memorytestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView timeText,scoreText;
    int score;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,
    imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,
            imageView13,imageView14,imageView15,imageView16,imageView17,imageView18,imageView19,imageView20,imageView21,
            imageView26,imageView27,imageView28,imageView29,imageView30,imageView31,imageView32,
            imageView22,imageView23,imageView24,imageView25;
    ImageView[] imageArray;
    ImageView[] imageArray2;
    Random rand = new Random();
    int[] resources = {
            R.drawable.elma,R.drawable.elma,
            R.drawable.kivi,R.drawable.kivi,
            R.drawable.muz,R.drawable.muz,
            R.drawable.armut,R.drawable.armut,
            R.drawable.cilek,R.drawable.cilek,
            R.drawable.karpuz,R.drawable.karpuz,
            R.drawable.kiraz,R.drawable.kiraz,
            R.drawable.nar,R.drawable.nar,
    };
    int openedCard = 0;
    String NeededCloseCard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText=findViewById(R.id.TimeText);
        scoreText = findViewById(R.id.ScoreText);
        ImageviewHolder();
        score=0;
        fillImageview();
    }

    public void ImageviewHolder(){
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15 = findViewById(R.id.imageView15);
        imageView16 = findViewById(R.id.imageView16);
        imageView17 = findViewById(R.id.imageView17);
        imageView18 = findViewById(R.id.imageView18);
        imageView19 = findViewById(R.id.imageView19);
        imageView20 = findViewById(R.id.imageView20);
        imageView21 = findViewById(R.id.imageView21);
        imageView22 = findViewById(R.id.imageView22);
        imageView23 = findViewById(R.id.imageView23);
        imageView24 = findViewById(R.id.imageView24);
        imageView25 = findViewById(R.id.imageView25);
        imageView26 = findViewById(R.id.imageView26);
        imageView27 = findViewById(R.id.imageView27);
        imageView28 = findViewById(R.id.imageView28);
        imageView29 = findViewById(R.id.imageView29);
        imageView30 = findViewById(R.id.imageView30);
        imageView31 = findViewById(R.id.imageView31);
        imageView32 = findViewById(R.id.imageView32);

        imageArray = new ImageView[]{
                imageView1,
                imageView2,
                imageView3,
                imageView4,
                imageView5,
                imageView6,
                imageView7,
                imageView8,
                imageView9,
                imageView10,
                imageView11,
                imageView12,
                imageView13,
                imageView14,
                imageView15,
                imageView16,
        };
        imageArray2 = new ImageView[]{
                imageView17,
                imageView18,
                imageView19,
                imageView20,
                imageView21,
                imageView22,
                imageView23,
                imageView24,
                imageView25,
                imageView26,
                imageView27,
                imageView28,
                imageView29,
                imageView30,
                imageView31,
                imageView32,
        };
        for(ImageView image: imageArray2){
            image.setVisibility(View.INVISIBLE);
        }
    }


    //imageviewlere random olarak elma kivi ve muz koyalım
    //bunu 3 sn gösterelim timer 3ten geriye saysın
    public void fillImageview(){
        for(ImageView image: imageArray){
            int ResourcesLength = resources.length;
            int rndInt = rand.nextInt(ResourcesLength);
            image.setImageResource(resources[rndInt]);

            image.setTag(resources[rndInt]);
            resources = removeTheElement(resources,rndInt);
        }
        new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long l) {
                timeText.setText("Time: "+ l/1000);
            }

            @Override
            public void onFinish() {
                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);

                }
                for(ImageView image: imageArray2){
                    image.setVisibility(View.VISIBLE);
                }
            }
        }.start();
    }

    public void clicked(View view){
            view.setVisibility(view.INVISIBLE);
            openedCard++;
            String value = String.valueOf(view.getTag());
            String lastTwo = value.substring(Math.max(value.length() - 2, 0));
            int lasttwo = Integer.parseInt(lastTwo);
            int neededCloseCardLasttwo = lasttwo-16;
            if (neededCloseCardLasttwo<10){
                String s = Integer.toString(neededCloseCardLasttwo);
                NeededCloseCard = "imageView"+"0"+s;
            }else{
                String s = Integer.toString(neededCloseCardLasttwo);
                NeededCloseCard = "imageView"+s;
            }
            for (ImageView image: imageArray){
                if (image.getTag().equals(NeededCloseCard)){
                    image.setVisibility(View.VISIBLE);
                    break;
                }
            }

            cardDetails();
    }

    public void cardDetails(){
        if (openedCard==2){
            new CountDownTimer(2000,1000) {
                @Override
                public void onTick(long l) {
                    for(ImageView image: imageArray2){
                        image.setEnabled(false);
                    }
                }
                @Override
                public void onFinish() {
                    for(ImageView image: imageArray){
                        image.setVisibility(View.INVISIBLE);
                    }
                    for(ImageView image: imageArray2){
                        image.setVisibility(View.VISIBLE);
                    }
                    for(ImageView image: imageArray2){
                        image.setEnabled(true);
                    }
                    openedCard = 0;
                }
            }.start();
        }
    }

    // Function to remove the element
    public static int[] removeTheElement(int[] arr, int index)
    {
        if (arr == null || index < 0
                || index >= arr.length) {
            return arr;
        }
        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
}