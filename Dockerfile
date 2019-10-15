FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
CMD java $JVM_OPTS $JAVA_OPTS -cp app:app/lib/* com.github.arolfes.music.musiclibraryreactive.MusicLibraryReactiveApplication
