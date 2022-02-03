package com.example.storingdata2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.textNumber);
        textView=findViewById(R.id.textAge);

        sharedPreferences = this.getSharedPreferences("com.example.storingdata2", Context.MODE_PRIVATE);
        //burada mode_private deyimi buradaki storing datanın sadece bu paket altında kullanılabileceği anlamına geliyor
        int storedAge = sharedPreferences.getInt("storedAge",0);
        if (storedAge == 0){
            textView.setText("your age = "+ 0);
        }else{
            textView.setText("your age = "+storedAge);
        }
    }
    public void save(View view){
        if (!editText.getText().toString().matches("")){
            int userAge = Integer.parseInt(editText.getText().toString());
            textView.setText("your age = "+userAge);
            sharedPreferences.edit().putInt("storedAge",userAge).apply();
            //shared preferences.edit diyerek düzenlemeye açık hale getirip
            //putint yardımıyla içerisine int bir değer koyduktan sonra apply diyerek değişikliği uyguluyoruz.
        }
    }
    public void delete(View view){
        int storedData = sharedPreferences.getInt("storedAge",0);
        if (storedData!=0){
            sharedPreferences.edit().remove("storedAge").apply();
            //vereceğim keydeki değeri varsa sil dedik
            textView.setText("your age = ");
            //texti boşalttık
        }
    }
}