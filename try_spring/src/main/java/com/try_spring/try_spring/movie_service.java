package com.try_spring.try_spring;

import java.util.List;

public interface movie_service {
    Movie add_movie(Movie movie);
    List<Movie> get_movies();
    Movie movie_details(Long id);
    Movie delete_movie(Long id);
    Movie update_movie(Movie movie);
    void addTo_watchlist(Long id);
    List<Movie> view_watchlist(Boolean watchlist);
}
