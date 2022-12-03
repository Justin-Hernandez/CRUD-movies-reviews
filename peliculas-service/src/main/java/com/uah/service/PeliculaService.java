package com.uah.service;

import com.uah.domain.Pelicula;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PeliculaService {

    Mono<Pelicula> save(Pelicula pelicula);

    Mono<Pelicula> update(Pelicula pelicula);

    Flux<Pelicula>  findAll();

    Mono<Long> delete(Long id);
}
