package com.github.arolfes.music.musiclibraryreactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.arolfes.music.musiclibraryreactive.entities.Album;
import com.github.arolfes.music.musiclibraryreactive.repository.ReactiveAlbumRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/albums")
@Slf4j
public class AlbumController {

  @Autowired
  ReactiveAlbumRepository albumRepository;

  @GetMapping()
  public Flux<Album> getAllAlbums() {
    log.debug("get all albums");
    return albumRepository.findAll();
  }

  @GetMapping("/findByName")
  public Flux<Album> getAlbumsByName(@RequestParam String name) {
    log.debug("get all albums by name {}", name);
    return albumRepository.findByNameContaining(name);
  }


}
