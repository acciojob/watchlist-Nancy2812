package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {


    public MovieRepository() {

    }

   private HashMap<String,Movie> movieL=new HashMap<>();

   private  HashMap<String,Director> directorL =new HashMap<>();
   private HashMap<String, List<Movie>> pair=new HashMap<>();


  public void addMovie(Movie movie)
   {
       Movie m=new Movie(movie.name,movie.durationInMinutes,movie.imdbRating);
       movieL.put(movie.getName(), movie);
  }

    public void addDirector(Director director)
    {
         Director d=new Director(director.name,director.numberOfMovies,director.imdbRating);
        directorL.put(director.getName(),director);
    }
  /*public void addMovieDirectorPair(String dirName, String movie )
   {
       List<Movie> list=new ArrayList<>();
       for(Movie m: movieL.values())
           list.add(m);
       pair.put(dirName,list);


   } */
   public Movie getMovieByName(String name)
   {
       Movie obj=movieL.get(name);
       return obj;
   }

    public Director getDirector(String name)
    {
        Director obj =directorL.get(name);
        return obj;
    }

    /*public List<Movie> getMoviesByDirectorName(String name)
    {
        return pair.get(name);
    } */
    public List<Movie> findAllMovies(){
       List<Movie> list=new ArrayList<>();
        for(Movie ref: movieL.values())
            list.add(ref);
       return list;
    }

    public void deleteAllDirectors() {
        for (String dirName : pair.keySet()) {
            pair.remove(dirName, pair.get(dirName));
        }
    }
      /*  public void deleteDirectorByName(String name) {
            for (String dirName : pair.keySet()){
                if(dirName==name)
                {
                    pair.remove(dirName, pair.get(dirName));
                }
                }

        }  */

    }



