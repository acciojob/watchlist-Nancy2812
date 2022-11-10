package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {

    HashMap<String,List<String>>Pair = new HashMap<>();
    private List<Director> directorL = new ArrayList<>();
    private List<Movie> movieL = new ArrayList<>();

    public void addmovie(Movie movie){
        movieL.add(movie);
    }


    public void addDirector(Director director) {
        directorL.add(director);
    }
    public List<Movie> getMovieList() {
        return movieL;
    }

    public List<Director> getDirector() {
        return directorL;
    }



    public void AddPair(String x, String y) {
        if(!Pair.containsKey(y)){
            List<String> m=new ArrayList<>();
            Pair.put(y,m);
        }
        Pair.get(y).add(x);
    }

    public List<String> getMoviesByDirector(String name) {

        List<String>movies = Pair.get(name);

        return movies;
    }


}