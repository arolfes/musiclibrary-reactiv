package com.github.arolfes.music.musiclibraryreactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.arolfes.music.musiclibraryreactive.dto.ArtistDto;
import com.github.arolfes.music.musiclibraryreactive.mapper.ArtistMapper;
import com.github.arolfes.music.musiclibraryreactive.repository.ReactiveArtistRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/artists")
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class ArtistController {

  @Autowired
  private ReactiveArtistRepository artistRepo;

  @Autowired
  private ArtistMapper artistMapper;

  @GetMapping()
  public Flux<ArtistDto> getAllArtists() {
    log.debug("get all artists");
    return artistRepo.findAll().map(artistMapper::toArtistDto);
  }

  @GetMapping("/findByName")
  public Flux<ArtistDto> getArtistsByName(@RequestParam String name) {
    log.debug("get all albums by name {}", name);
    return artistRepo.findByNameContaining(name).log().map(artistMapper::toArtistDto);
  }

}
