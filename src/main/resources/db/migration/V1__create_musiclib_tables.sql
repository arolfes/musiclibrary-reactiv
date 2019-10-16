CREATE TABLE artists (
     id serial PRIMARY KEY,
     name VARCHAR(255) NOT NULL
);

CREATE TABLE albums (
     id serial PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     release_date TIMESTAMP,
     artist_id integer NOT NULL,
     CONSTRAINT fk_artist_id FOREIGN KEY (artist_id) REFERENCES artists(id) MATCH SIMPLE
);


insert into artists(name) values ('Blink-182');
insert into artists(name) values ('Foo Fighters');

insert into albums(name, release_date, artist_id) values ('Blink-182', '2003-11-18', (SELECT id FROM artists WHERE name = 'Blink-182'));
insert into albums(name, release_date, artist_id) values ('In You Honor', '2005-06-14', (SELECT id FROM artists WHERE name = 'Foo Fighters'));
insert into albums(name, release_date, artist_id) values ('Take Off Your Pants and Jacket', '2001-06-13', (SELECT id FROM artists WHERE name = 'Blink-182'));
insert into albums(name, release_date, artist_id) values ('Neighborhoods', '2011-09-23', (SELECT id FROM artists WHERE name = 'Blink-182'));
insert into albums(name, release_date, artist_id) values ('California', '2016-07-01', (SELECT id FROM artists WHERE name = 'Blink-182'));
insert into albums(name, release_date, artist_id) values ('Nine', '2019-09-20', (SELECT id FROM artists WHERE name = 'Blink-182'));
