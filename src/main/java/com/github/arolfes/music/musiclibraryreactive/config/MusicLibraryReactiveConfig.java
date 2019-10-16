package com.github.arolfes.music.musiclibraryreactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.dialect.PostgresDialect;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import com.github.arolfes.music.musiclibraryreactive.repository.ReactiveAlbumRepository;
import com.github.arolfes.music.musiclibraryreactive.repository.ReactiveArtistRepository;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class MusicLibraryReactiveConfig {

  @Bean
  public ReactiveAlbumRepository albumRepository(R2dbcRepositoryFactory factory) {
    return factory.getRepository(ReactiveAlbumRepository.class);
  }

  @Bean
  public ReactiveArtistRepository artistRepository(R2dbcRepositoryFactory factory) {
    return factory.getRepository(ReactiveArtistRepository.class);
  }

  @Bean
  public R2dbcRepositoryFactory factory(DatabaseClient client) {
    RelationalMappingContext context = new RelationalMappingContext();
    context.afterPropertiesSet();
    return new R2dbcRepositoryFactory(client, new DefaultReactiveDataAccessStrategy(PostgresDialect.INSTANCE));
  }

  @Bean
  public DatabaseClient databaseClient(ConnectionFactory factory) {
    return DatabaseClient.builder().connectionFactory(factory).build();
  }

  @Bean
  public PostgresqlConnectionFactory postgresqlConnectionFactory() {

    return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder() //
        .host("localhost") //
        .port(5432) //
        .database("reactive") //
        .username("reactive") //
        .password("reactive123") //
        .build());

  }
}
