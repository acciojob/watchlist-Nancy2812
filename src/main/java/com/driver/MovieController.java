package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movie;
    //1
    @PostMapping("/add_movie")
    public ResponseEntity<String>addMovie(@RequestBody() Movie ref){
        movie.addMovie(ref);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

    //2
    @GetMapping("/get_movie")
    public ResponseEntity<Movie>getMovie(@PathVariable String name){
        Movie ref=movie.getMovie(name);
        return new ResponseEntity<>(ref, HttpStatus.OK);
    }
}
