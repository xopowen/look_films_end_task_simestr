package com.example.look_films;

import java.util.ArrayList;

public class Movies {

        public Film information;
        public ArrayList<Film> names;
        public String name ;

        public Movies() {
        names = new ArrayList();
        name= "All";
        }
        public void addFilm(Film name){
                names.add(name);
        }
        
    }

