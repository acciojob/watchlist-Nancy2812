package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movRepo;

    public void addMovie(Movie movie)
    {
        movierepo.addMovie(movie);
    }
    public Movie getMovie(String movieName)
    {
        Movie ref=movierepo.getMovie(movieName);
        return ref;
    }
}
