package com.uah.service.impl;

import com.uah.domain.Pelicula;
import com.uah.repository.PeliculaRepository;
import com.uah.service.PeliculaService;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaRepository peliculaRepository;

    // inyeccion de dependecia desde el contructor
    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public Mono<Pelicula> save(Pelicula pelicula) {

        if(pelicula.getId() != null) { pelicula.setId(null); }
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Mono<Pelicula> update(Pelicula pelicula) {
        return peliculaRepository.update(pelicula);
    }

    @Override
    public Flux<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    @Override
    public Mono<Long> delete(Long id) {
        return peliculaRepository.deleteById(id);
    }
}
