package com.github.arolfes.music.musiclibraryreactive.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDto {

  private Integer id;

  private String name;

  private List<AlbumDto> albums;
}
