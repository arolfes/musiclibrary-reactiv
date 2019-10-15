package com.github.arolfes.music.musiclibraryreactive.repository;

import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.github.arolfes.music.musiclibraryreactive.entities.Album;
import reactor.core.publisher.Flux;

public interface ReactiveAlbumRepository extends ReactiveCrudRepository<Album, Integer> {

  @Query("SELECT * FROM albums WHERE name = :name")
  Flux<Album> findByNameContaining(String name);
}
