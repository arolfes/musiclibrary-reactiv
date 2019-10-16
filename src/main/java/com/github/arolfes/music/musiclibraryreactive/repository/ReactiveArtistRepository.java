package com.github.arolfes.music.musiclibraryreactive.repository;

import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.github.arolfes.music.musiclibraryreactive.entities.Artist;
import reactor.core.publisher.Flux;

public interface ReactiveArtistRepository extends ReactiveCrudRepository<Artist, Integer> {

  @Query("SELECT * FROM artists WHERE name = :name")
  Flux<Artist> findByNameContaining(String name);

}
