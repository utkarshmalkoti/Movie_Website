package com.try_spring.try_spring;
// import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Service;

@Component
// @Service
public class movie_service_impl implements movie_service {

    @Autowired
    public Movie_Repo mRepository;


    @Override
    public List<Movie> get_movies(){
        return mRepository.findAll();
    }
    @Override
    public Movie add_movie(Movie movie) {
        return mRepository.save(movie);
    }

    @Override
    public Movie movie_details(Long id){
        Optional<Movie> m = mRepository.findById(id);
        if (m.isPresent()){
            return m.get();
        }
        throw new RuntimeException("No records found");
    }
    @Override
    public Movie delete_movie(Long id){
        Optional<Movie> m = mRepository.findById(id);
        if(m.isPresent()){
            mRepository.deleteById(id);
            return m.get(); 
        }
        throw new RuntimeException("Record does not exists for id: "+id);
    }

    @Override
    public Movie update_movie(Movie movie){
        Movie existing_movie = mRepository.findById(movie.getId()).orElseThrow(()-> new ResourceNotFoundException("Movie Not found"));
        if(!movie.getName().isEmpty()){
            existing_movie.setName(movie.getName());
        }
        if(movie.getWatchlist()!= null ){
            existing_movie.setWatchlist(movie.getWatchlist());
        }
        if(movie.getWatched()!= null){
            existing_movie.setWatched(movie.getWatchlist());
        }
        if(movie.getImdb_score()!= null){
            existing_movie.setImdb_score(movie.getImdb_score());
        }
        System.out.println(existing_movie);
        return mRepository.save(existing_movie);
    } 

    @Override
    public void addTo_watchlist(Long id){
        Optional<Movie> m = mRepository.findById(id);
        if(m.isPresent()){
            m.get().setWatchlist(true);
            mRepository.save(m.get());
        } 
        else{
            throw new RuntimeException("movie not found!!!!");
        }
    }

    @Override
    public List<Movie> view_watchlist(Boolean watchlist){
        return mRepository.get_watchlist_repo(watchlist);
    }

}

