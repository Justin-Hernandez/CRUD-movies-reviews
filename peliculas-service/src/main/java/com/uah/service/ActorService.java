package com.uah.service;

import com.uah.domain.Actor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ActorService {

    Mono<Actor> save(Actor actor);

    Mono<Actor> update(Actor actor);

    Flux<Actor> findAll();

    Mono<Long> delete(Long id);
}
