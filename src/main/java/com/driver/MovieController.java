package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService service;


    //running successfully
    //1
    @PostMapping("/add_movie")
    public ResponseEntity<String>addMovie(@RequestBody(required = true)Movie movie){
        // movies.put(movie.getName(), movie);
        service.addMovie(movie);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    //running 2
    @PostMapping("/add_director")
    public ResponseEntity<String>addDirector(@RequestBody()Director director){

        service.addDirector(director);

        return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
    }

    //3
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){

        Movie res = service.getMovieByName(name);
        return new ResponseEntity<>(res,HttpStatus.CREATED);

    }
    //4
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("moviename")String moviename,@RequestParam("directorname")String directorname){
        service.addMovieDirectorPair(moviename,directorname);
        return new ResponseEntity("SUCCESS",HttpStatus.OK);
    }


    //5
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){

        Director ref = service.getDirectorByName(name);
        return new ResponseEntity<>(ref,HttpStatus.CREATED);


    }
    //Error
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String>moviesByDirector = service.getDirectorMovieByName(director);
        return new ResponseEntity(moviesByDirector,HttpStatus.OK);
    }

    //running 7
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String>listOfMovies = service.findAllMovies();

        return new ResponseEntity<>(listOfMovies,HttpStatus.OK);

    }


    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
        service.deleteDirectorByName(name);
        return new ResponseEntity<>("SUCCESS",HttpStatus.OK );
    }

    //9
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String>  deleteAllDirectors(){
        service.DeleteAllDirectors();
        return new ResponseEntity("SUCCESS",HttpStatus.OK);
    }

}