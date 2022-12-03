package com.uah.service.impl;

import com.uah.domain.Director;
import com.uah.repository.DirectorRepository;
import com.uah.service.DirectorService;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    // inyeccion de dependecia desde el contructor
    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public Mono<Director> save(Director director) {

        if(director.getId() != null) { director.setId(null); }

        return directorRepository.save(director);
    }

    @Override
    public Mono<Director> update(Director director) {
        return directorRepository.update(director);
    }

    @Override
    public Flux<Director> findAll() {
        return directorRepository.findAll();
    }

    @Override
    public Mono<Long> delete(Long id) {
        return directorRepository.deleteById(id);
    }
}
