package com.github.arolfes.music.musiclibraryreactive;

import org.junit.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

public class MusicLibraryReactiveWebClient {

  @Test
  public void test() {
    WebTestClient client = WebTestClient.bindToServer()
        .baseUrl("http://localhost:8090")
        .build();
    client.get()
    .uri("/albums")
    .exchange()
    .expectStatus()
        .isOk();
  }
}
