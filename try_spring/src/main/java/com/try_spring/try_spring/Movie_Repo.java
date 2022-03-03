package com.try_spring.try_spring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Movie_Repo extends JpaRepository<Movie, Long> {
    @Query(value="SELECT * from tbl_movie where watchlist=true",nativeQuery =true)
    public List<Movie> get_watchlist_repo(Boolean watchlist);
}
