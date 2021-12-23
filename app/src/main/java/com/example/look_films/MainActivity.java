package com.example.look_films;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText name,category,date,after,cost_tiket;
    Movies m;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = 0;

        name = findViewById(R.id.name);
        category = findViewById(R.id.category);
        date = findViewById(R.id.date);
        after = findViewById(R.id.after);
        cost_tiket = findViewById(R.id.cost_tiket);


        Movies films = new Movies();
        films.addFilm(new Film("Film1","ужасы","1999","NAN","1515"));
        films.addFilm(new Film("Film2","ужасы","2000","NAN","1515"));
        films.addFilm(new Film("Film3","ужасы","2001","NAN","1515"));
        films.addFilm(new Film("Film4","ужасы","2002","NAN","1515"));


        InputStreamReader reader;
        Gson gson = new Gson();
        FileWriter f ;
        //записали данные в файл надеюсь
        Log.i("GSON_WRIT", String.valueOf(gson.toJson(films)));



        //читаем из файла
        try (InputStream stream = getAssets().open("movies.json")) {
            reader = new InputStreamReader(stream);
            m = gson.fromJson(reader, Movies.class);
            Log.i("GSONRED", String.valueOf(m));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showMove(View view){
        if(i< m.names.size()){
        Film film = m.names.get(i);
        name.setText(film.name);
        category.setText(film.category);
        date.setText(film.date);
        after.setText(film.after);
        cost_tiket.setText(film.cost_tiket);
        i++;
        }else{
            name.setText("Это был последний");
        }
    }


}