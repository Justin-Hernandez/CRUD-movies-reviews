package com.uah.repository;

import com.uah.domain.Actor;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

@Repository
public interface ActorRepository extends ReactorCrudRepository<Actor, Long> {
}
