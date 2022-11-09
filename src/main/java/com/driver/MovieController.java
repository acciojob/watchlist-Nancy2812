package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movie;
    //1
    @PostMapping("/movies/add_movie")
    public ResponseEntity<String>addMovie(@RequestBody() Movie ref){
        movie.addMovie(ref);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

    //2
    @PostMapping("/movies/add_director")
    public ResponseEntity<String>addDirector(@RequestBody() Director ref){
        movie.addDirector(ref);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }
    //2
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie>getMovieByName(@PathVariable String name){
        Movie ref=movie.getMovieByName(name);
        return new ResponseEntity<>(ref, HttpStatus.OK);
    }


    /*@GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director>getDirector(@PathVariable String name){
        Director ref=movie.getDirector(name);
        return new ResponseEntity<>(ref, HttpStatus.OK);
    }*/

   /* @GetMapping("/get_movie_director/{director}")
    public ResponseEntity<List<String>>getMoviesByDirectorName(@PathVariable String director) {
        List<String> m = movie.getMoviesByDirectorName(director);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @GetMapping("movies/get-all-movies")
    public ResponseEntity<List<String>>getMoviesByDirectorName(@PathVariable String director) {
        List<String> m = movie.findAllMovies();
        return new ResponseEntity<>(m, HttpStatus.OK);
    } */
}
