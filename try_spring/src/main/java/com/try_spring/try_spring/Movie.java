package com.try_spring.try_spring;


import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// import java.util.concurrent.atomic.AtomicLong;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "tbl_movie")
@Table(name="tbl_movie")


public class Movie {
    // private static AtomicLong id_count = new AtomicLong(0);

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private long Id=1;
    @Column(name="name")
    private String Name = new String();
    @Column(name="imdb_score")
    private Double imdb_score;
    @Column(name="is_watched")
    private Boolean watched;
    @Column(name="watchlist")
    private Boolean watchlist;
    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
}
