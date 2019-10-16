package com.github.arolfes.music.musiclibraryreactive.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.github.arolfes.music.musiclibraryreactive.dto.AlbumDto;
import com.github.arolfes.music.musiclibraryreactive.entities.Album;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

  @Mapping(source = "releaseDate", target = "releaseDate", dateFormat = "yyyy-MM-dd")
  @Mapping(source = "artistId", target = "artist", ignore = true)
  AlbumDto toAlbumDto(Album album) throws RuntimeException;

  @Mapping(source = "releaseDate", target = "releaseDate", dateFormat = "yyyy-MM-dd")
  @Mapping(source = "artist", target = "artistId", ignore = true)
  Album toAlbum(AlbumDto albumDto) throws RuntimeException;
}
