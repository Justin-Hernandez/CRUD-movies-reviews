-- Crea nuevo rol para el microservicio
CREATE ROLE peliculas_service WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  REPLICATION
  PASSWORD 'peliculas_service';

-- Crea nuevo schema con autorizacion para el nuevo rol creado
CREATE SCHEMA peliculas_schema
    AUTHORIZATION peliculas_service;

-- Cambia del schema publico a peliculas_schema
SET SCHEMA 'peliculas_schema';

DROP TABLE IF EXISTS peliculas_schema.reparto;
DROP TABLE IF EXISTS peliculas_schema.direccion;
DROP TABLE IF EXISTS peliculas_schema.peliculas;
DROP TABLE IF EXISTS peliculas_schema.actores;
DROP TABLE IF EXISTS peliculas_schema.directores;

CREATE TABLE actores(
    id serial PRIMARY KEY,
    nombre character varying(80),
    fecha_nacimiento date,
    pais character varying(60)
);
CREATE INDEX idx_actores_nombre ON actores (nombre);

CREATE TABLE directores(
    id serial PRIMARY KEY,
    nombre character varying(80),
    fecha_nacimiento date,
    pais character varying(60)
);
CREATE INDEX idx_directores_nombre ON directores (nombre);

CREATE TABLE peliculas(
    id serial PRIMARY KEY,
    titulo character varying(255),
    ano integer,
    duracion integer,
    pais character varying(60),
    id_director integer,
    sinopsis text,
    FOREIGN KEY (id_director) REFERENCES directores (id)
);
CREATE INDEX idx_peliculas_titulo ON peliculas (titulo);

CREATE TABLE reparto(
    id_pelicula integer,
    id_actor integer,
    PRIMARY KEY(id_actor, id_pelicula),
    FOREIGN KEY (id_actor) REFERENCES actores (id),
    FOREIGN KEY (id_pelicula) REFERENCES peliculas (id)
);

INSERT INTO directores VALUES (nextval('directores_id_seq'), 'James Francis Cameron', '1954-08-16', 'Canada');
INSERT INTO directores VALUES (nextval('directores_id_seq'), 'Joseph Kosinski', '1975-03-03', 'United States');
INSERT INTO directores VALUES (nextval('directores_id_seq'), 'Daniel Kwan', '1988-02-10', 'United States');

INSERT INTO peliculas VALUES (nextval('peliculas_id_seq'), 'Avatar: The Way of Water', 2022, 240, 'United States', 1, 'Ambientada más de una década después de los acontecimientos de la primera película, "Avatar: The Way of Water" empieza contando la historia de la familia Sully (Jake, Neytiri y sus hijos), los problemas que los persiguen, lo que tienen que hacer para mantenerse a salvo, las batallas que libran para seguir con vida y las tragedias que sufren. Secuela del éxito de taquilla Avatar (2009).');
INSERT INTO peliculas VALUES (nextval('peliculas_id_seq'), 'Top Gun: Maverick', 2022, 131, 'United States', 2, 'Después de más de treinta años de servicio como uno de los mejores aviadores de la Armada, Pete "Mavericks" Mitchel (Tom Cruise) se encuentra donde siempre quiso estar: superando los límites como un valiente piloto de pruebas y esquivando el ascenso de rango, que no le dejaría volar emplazándolo en tierra. Cuando es destinado a la academia de Top Gun con el objetivo de entrenar a los pilotos de élite para realizar una peligrosa misión en territorio enemigo, Maverick se encuentra allí con el joven teniente Bradley Bradshaw (Miles Teller), el hijo de su difunto amigo "Goose".');
INSERT INTO peliculas VALUES (nextval('peliculas_id_seq'), 'Everything Everywhere All at Once', 2022, 139, 'United States', 3, 'Cuando una ruptura interdimensional altera la realidad, Evelyn (Michelle Yeoh), una inmigrante china en Estados Unidos, se ve envuelta en una aventura salvaje en la que solo ella puede salvar el mundo. Perdida en los mundos infinitos del multiverso, esta heroína inesperada debe canalizar sus nuevos poderes para luchar contra los extraños y desconcertantes peligros del multiverso mientras el destino del mundo pende de un hilo.');

-- 'Avatar: The Way of Water'
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Sam Worthington', '1997-08-02', 'England');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Zoe Saldana', '1978-06-19', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Kate Winslet', '1975-10-05', 'England');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Sigourney Weaver', '1949-10-08', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Giovanni Ribisi', '1974-12-17', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Michelle Yeoh', '1962-08-06', 'Malaysia');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Oona Chaplin', '1986-06-04', 'Spain');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Stephen Lang', '1952-07-11', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Cliff Curtis', '1968-07-27', 'New Zealand');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Joel David Moore', '1977-09-25', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'CCH Pounder', '1952-12-25', 'British Guiana');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Edie Falco', '1963-07-05', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Jemaine Clement', '1974-01-10', 'New Zealand');

-- 'Top Gun: Maverick'
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Tom Cruise', '1962-07-03', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Miles Teller', '1987-02-20', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Jennifer Connelly', '1970-12-12', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Jon Hamm', '1971-03-10', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Glen Powell', '1988-10-21', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Ed Harris', '1950-11-28', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Val Kilmer', '1959-12-31', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Lewis Pullman', '1933-01-29', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Charles Parnell', '1975-03-18', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Bashir Salahuddin', '1976-07-06', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Monica Barbaro', '1990-06-18', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Jay Ellis', '1981-12-27', 'United States');

-- 'Everything Everywhere All at Once'
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Jaime Lee Curtis', '1958-11-22', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Jonathan Ke Quan', '1971-08-20', 'Vietnam');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'James Hong', '1929-02-22', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Anthony Molinari', '1974-05-09', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Audrey Wasilewski', '1967-09-25', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Stephanie Hsu', '1990-11-25', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Andy Le', '1975-03-18', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Tallie Medel', '1976-05-10', 'Alaska');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Jenny Slate', '1982-03-25', 'United States');
INSERT INTO actores VALUES (nextval('actores_id_seq'), 'Harry Shum Jr', '1982-04-28', 'Costa Rica');

INSERT INTO reparto VALUES (1,1);
INSERT INTO reparto VALUES (1,2);
INSERT INTO reparto VALUES (1,3);
INSERT INTO reparto VALUES (1,4);
INSERT INTO reparto VALUES (1,5);
INSERT INTO reparto VALUES (1,6);
INSERT INTO reparto VALUES (1,7);
INSERT INTO reparto VALUES (1,8);
INSERT INTO reparto VALUES (1,9);
INSERT INTO reparto VALUES (1,10);
INSERT INTO reparto VALUES (1,11);
INSERT INTO reparto VALUES (1,12);
INSERT INTO reparto VALUES (1,13);

INSERT INTO reparto VALUES (2,14);
INSERT INTO reparto VALUES (2,15);
INSERT INTO reparto VALUES (2,16);
INSERT INTO reparto VALUES (2,17);
INSERT INTO reparto VALUES (2,18);
INSERT INTO reparto VALUES (2,19);
INSERT INTO reparto VALUES (2,20);
INSERT INTO reparto VALUES (2,21);
INSERT INTO reparto VALUES (2,22);
INSERT INTO reparto VALUES (2,23);
INSERT INTO reparto VALUES (2,24);
INSERT INTO reparto VALUES (2,25);

INSERT INTO reparto VALUES (3,6);
INSERT INTO reparto VALUES (3,26);
INSERT INTO reparto VALUES (3,27);
INSERT INTO reparto VALUES (3,28);
INSERT INTO reparto VALUES (3,29);
INSERT INTO reparto VALUES (3,30);
INSERT INTO reparto VALUES (3,31);
INSERT INTO reparto VALUES (3,32);
INSERT INTO reparto VALUES (3,33);
INSERT INTO reparto VALUES (3,34);
INSERT INTO reparto VALUES (3,35);
