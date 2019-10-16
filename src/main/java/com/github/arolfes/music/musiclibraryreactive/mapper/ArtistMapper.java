package com.github.arolfes.music.musiclibraryreactive.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.github.arolfes.music.musiclibraryreactive.dto.ArtistDto;
import com.github.arolfes.music.musiclibraryreactive.entities.Artist;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

  @Mapping(target = "albums", ignore = true)
  ArtistDto toArtistDto(Artist artist) throws RuntimeException;

  Artist toArtist(ArtistDto artistDto) throws RuntimeException;

}
