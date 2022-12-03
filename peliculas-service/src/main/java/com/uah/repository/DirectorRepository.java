package com.uah.repository;

import com.uah.domain.Director;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

@Repository
public interface DirectorRepository extends ReactorCrudRepository<Director, Long> {
}
