package com.github.arolfes.music.musiclibraryreactive.repository;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import com.github.arolfes.music.musiclibraryreactive.entities.Album;
import com.github.arolfes.music.musiclibraryreactive.entities.Artist;
import io.r2dbc.spi.Row;
import reactor.core.publisher.Flux;

@Component
public class MyAlbumRepoImpl implements MyAlbumRepo {

  @Autowired
  private DatabaseClient databaseClient;

  @Override
  public Flux<Album> getAlbumWithArtist(String name) {

    // works but is susceptible adj. sql injection
    return databaseClient.execute().sql(
        "SELECT alb.*, art.name AS art_name FROM albums alb, artists art WHERE alb.artist_id = art.id AND alb.name LIKE '%"+name+"%' ORDER BY alb.name")
        .map((row, rowMetadata) -> convertRow(row))
        .all();

  }

  private static Album convertRow(Row row) {
    Integer artistId = row.get("artist_id", Integer.class);
    return Album.builder()
        .id(row.get("id", Integer.class))
        .name(row.get("name", String.class))
        .releaseDate(row.get("release_date", Date.class))
        .artistId(artistId).artist(new Artist(artistId, row.get("art_name", String.class))).build();
  }
}
