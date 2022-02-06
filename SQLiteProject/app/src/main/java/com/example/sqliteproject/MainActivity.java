package com.example.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //eğer veri tabanında bir şeyler değiştireceksek bunun en iyi yolu uygulamayı telefondan silmek!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            SQLiteDatabase database = this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY,name VARCHAR,age INT)");
            //burda id unique olmuyor eğer int yazarsak INTEGER yazmamız gerekiyor.

            database.execSQL("INSERT INTO musicians(name,age) VALUES ('James',50)");
            //veriyi database e ekledik şimdi alt satırda okumak için cursor oluşturacağız

            Cursor cursor = database.rawQuery("SELECT * FROM musicians",null);
            //null yazdığımız yer filtreleme istemiyoruz anlamına geliyor

            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE id = 2",null);
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name = 'James'",null);

            database.execSQL("UPDATE musicians SET name = 'ABDUSSAMET' WHERE id = 3");
            //idsi 3 olanın adını abdussamet yap

            database.execSQL("DELETE FROM musicians WHERE id = 2");
            //idsi 2 olan kullanıcıyı sil

            Cursor cursor1 = database.rawQuery("SELECT * FROM musicians WHERE Name LIKE '%S'",null);
            //s ile bitenleri verir

            Cursor cursor2 = database.rawQuery("SELECT * FROM musicians WHERE Name LIKE 'S%'",null);
            //s ile başlayanları verir

            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int IDIx = cursor.getColumnIndex("id");
            while (cursor.moveToNext()){
                System.out.println("name "+cursor.getString(nameIx));
                System.out.println("Age "+cursor.getInt(ageIx));
                System.out.println("id "+cursor.getInt(IDIx));
            }
            cursor.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}