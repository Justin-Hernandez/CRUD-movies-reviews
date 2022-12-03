package com.uah.service.impl;

import com.uah.domain.Actor;
import com.uah.repository.ActorRepository;
import com.uah.service.ActorService;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Mono<Actor> save(Actor actor) {

        if(actor.getId() != null) { actor.setId(null); }

        return actorRepository.save(actor);
    }

    @Override
    public Mono<Actor> update(Actor actor) {
        return actorRepository.update(actor);
    }

    @Override
    public Flux<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Mono<Long> delete(Long id) {
        return actorRepository.deleteById(id);
    }
}
