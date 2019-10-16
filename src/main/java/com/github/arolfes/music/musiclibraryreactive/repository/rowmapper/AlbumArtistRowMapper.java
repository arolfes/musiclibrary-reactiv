package com.github.arolfes.music.musiclibraryreactive.repository.rowmapper;

import java.util.Date;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import com.github.arolfes.music.musiclibraryreactive.entities.Album;
import com.github.arolfes.music.musiclibraryreactive.entities.Artist;
import io.r2dbc.spi.Row;

@ReadingConverter
public class AlbumArtistRowMapper implements Converter<Row, Album> {

  @Override
  public Album convert(Row source) {
    Integer artistId = source.get("artist_id", Integer.class);
    return Album.builder()
        .id(source.get("id", Integer.class))
        .name(source.get("name", String.class))
        .releaseDate(source.get("release_date", Date.class))
        .artistId(artistId).artist(new Artist(artistId, source.get("art_name", String.class))).build();
  }

}
