package com.uah.service;

import com.uah.domain.Director;
import org.hibernate.sql.Update;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DirectorService {

    Mono<Director> save(Director director);

    Mono<Director> update(Director director);

    Flux<Director> findAll();

    Mono<Long> delete(Long id);
}
