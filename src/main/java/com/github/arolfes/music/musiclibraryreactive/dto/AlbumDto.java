package com.github.arolfes.music.musiclibraryreactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto {

  private Integer id;

  private String name;

  private String releaseDate;

  private ArtistDto artist;

}
