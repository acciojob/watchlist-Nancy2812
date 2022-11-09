package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepo;

    public void addMovie(Movie movie) {
        movieRepo.addMovie(movie);
    }

    public Movie getMovieByName(String movieName) {
        Movie ref = movieRepo.getMovieByName(movieName);
        return ref;
    }

    public void addDirector(Director director) {
        movieRepo.addDirector(director);
    }

    public Director getDirector(String name) {
        Director ref = movieRepo.getDirector(name);
        return ref;
    }

    /*public void addMovieDirectorPair(String name, String name1) {
        movieRepo.addMovieDirectorPair(name, name1);
    } */

    /*public List<Movie> getMoviesByDirectorName(String name) {
        List<Movie> ref = movieRepo.getMoviesByDirectorName(name);
        return ref;
    }*/

    public List<Movie> findAllMovies() {
        List<Movie> ref = movieRepo.findAllMovies();
        return ref;
    }

    public void deleteAllDirectors() {
        movieRepo.deleteAllDirectors();
    }

    /*public void deleteDirectorByName(String name) {
        movieRepo.deleteDirectorByName(name);
    }*/
}