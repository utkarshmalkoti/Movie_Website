package com.try_spring.try_spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tryspring_controller {
    private static final String MOVIES = "/movies";

    @Autowired
    private movie_service_impl mService = new movie_service_impl();
    // @Value("${app.name}")
    // private String appname;

    // @Value("${app.version}")
    // private String appversion;
    
    // @GetMapping(MOVIES+"/version")
    // public String app_details(){
    //     return "Application Name: " + appname + "\n" + " Application Version: " + appversion;
    // }
    @GetMapping(MOVIES)
    public String movie(){
        mService.get_movies();
        return "HERE ARE THE MOVIES";
    }
    @GetMapping(MOVIES+"/{id}")
    public Movie movie(@PathVariable("id") Long id){
        return mService.movie_details(id);
    }
    // @GetMapping(MOVIES+"/view_watchlist")
    // public List<Movie> get_watchlist(){
    //     return mService.view_watchlist(true);
    // }

    @PostMapping(MOVIES)
    public Movie save_movie(@RequestBody Movie movie){
        return mService.add_movie(movie);
    }
    @DeleteMapping(MOVIES)
    public String delete_movie(@RequestParam("id") Long id){
        return "Movie"+mService.delete_movie(id).getName()+" is deleted";
    }
    @PutMapping(MOVIES)
    public String update_movie(@RequestParam("id") Long id, @RequestBody Movie movie){
        movie.setId(id);
        return "Details have been updated for movie: " + mService.update_movie(movie).getName();
    }
    @PutMapping(MOVIES+"/AddToWatchlist")
    public String addTo_watchlist(@RequestParam("id") Long id){
        mService.addTo_watchlist(id);
        return "Movie has been added to Watchlist.";
    }
}
