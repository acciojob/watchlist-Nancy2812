package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepo;

    public void addMovie(Movie movie){
        movieRepo.addmovie(movie);
    }

    public void addDirector(Director director){
        movieRepo.addDirector(director);
    }



    public List<String> findAllMovies() {
        List<String>listOfMovies= new ArrayList<>();
        List<Movie>movieList = movieRepo.getMovieList();
        for(Movie m : movieList){
            listOfMovies.add(m.getName());
        }
        return listOfMovies;
    }


    public void addMovieDirectorPair(String movie, String director) {
        movieRepo.AddPair(movie,director);
    }
    public Movie getMovieByName(String name){
        List<Movie>List = movieRepo.getMovieList();
        for(Movie m : List){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    public Director getDirectorByName(String director) {
        List<Director>list = movieRepo.getDirector();
        for(Director d : list){
            if(d.getName().equals(director)){
                return d;
            }
        }
        return null;
    }
    public List<String> getDirectorMovieByName(String director) {
        return movieRepo.getMoviesByDirector(director);

    }


}