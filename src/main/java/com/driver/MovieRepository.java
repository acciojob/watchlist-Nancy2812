package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {
   private HashMap<String,Movie> movieL=new HashMap<>();
   private  HashMap<String,Director> directorL =new HashMap<>();
   private HashMap<String, List<Movie>> pair=new HashMap<>();

   public void addMovie(Movie movie)
   {
       Movie obj=new Movie(movie.name,movie.durationInMinutes,movie.imdbRating);
       movieL.put(obj.getName(),obj);
   }
    public void addDirector(Director director)
    {
        Director obj1=new Director(director.name,director.noOfMovie,director.imdbRating);
        directorL.put(director.name,obj1);
    }
   public void PairDirMov(String dirName, Movie movie )
   {
       List<Movie> list=new ArrayList<>();
       list.add(movie);
       pair.put(dirName,list);


   }
   public Movie getMovie(String name)
   {
       Movie obj=movieL.get(name);
       return obj;
   }
    public Director getDirector(String name)
    {
        Director obj =directorL.get(name);
        return obj;
    }
    public List<Movie> getMovByDirName(String dirName)
    {
        return pair.get(dirName);
    }
    public List<Movie> getMovies()
    {
        List<Movie> listOfMov= new ArrayList<>();
        for(Movie m: movieL.values())
            listOfMov.add(m);
        return listOfMov;
    }
    public void deleteDir() {
        for (String dirName : pair.keySet()) {
            pair.remove(dirName, pair.get(dirName));
        }
    }

}
