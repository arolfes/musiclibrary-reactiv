package com.github.arolfes.music.musiclibraryreactive.repository;

import com.github.arolfes.music.musiclibraryreactive.entities.Album;
import reactor.core.publisher.Flux;

public interface MyAlbumRepo {

  Flux<Album> getAlbumWithArtist(String name);
}
