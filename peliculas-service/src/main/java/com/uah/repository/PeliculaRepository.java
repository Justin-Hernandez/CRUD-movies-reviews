package com.uah.repository;

import com.uah.domain.Pelicula;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

@Repository
public interface PeliculaRepository extends ReactorCrudRepository<Pelicula, Long> {

}
