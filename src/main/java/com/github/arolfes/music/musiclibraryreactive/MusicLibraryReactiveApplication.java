package com.github.arolfes.music.musiclibraryreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {MusicLibraryReactiveApplication.class})
public class MusicLibraryReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicLibraryReactiveApplication.class, args);
	}

}
