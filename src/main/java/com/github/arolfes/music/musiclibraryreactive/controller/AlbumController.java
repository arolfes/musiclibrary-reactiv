package com.github.arolfes.music.musiclibraryreactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.arolfes.music.musiclibraryreactive.dto.AlbumDto;
import com.github.arolfes.music.musiclibraryreactive.mapper.AlbumMapper;
import com.github.arolfes.music.musiclibraryreactive.repository.MyAlbumRepo;
import com.github.arolfes.music.musiclibraryreactive.repository.ReactiveAlbumRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/albums")
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class AlbumController {

  @Autowired
  private ReactiveAlbumRepository albumRepository;

  @Autowired
  private MyAlbumRepo myAlbumRepo;

  @Autowired
  private AlbumMapper albumMapper;

  @GetMapping()
  public Flux<AlbumDto> getAllAlbums() {
    log.debug("get all albums");
    return albumRepository.findAll().log().map(albumMapper::toAlbumDto).log();
  }

  @GetMapping("/findByName")
  public Flux<AlbumDto> getAlbumsByName(@RequestParam String name) {
    log.debug("get all albums by name {}", name);
    return albumRepository.findByNameContaining(name).log().map(albumMapper::toAlbumDto).log();
  }

  @GetMapping("/findByNameWithArtists")
  public Flux<AlbumDto> getAlbumsByNameWithArtists(@RequestParam String name) {
    log.debug("get all albums by name {}", name);
    return myAlbumRepo.getAlbumWithArtist(name).log().map(albumMapper::toAlbumDto).log();
  }

}
