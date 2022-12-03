package com.uah.service;

import com.uah.domain.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioService {

    Mono<Usuario> findById(String id);

    Flux<Usuario> findAll();

    Mono<Usuario> save(Usuario usuario);

    Mono<Usuario> update(Usuario usuario);

    Mono<Long> delete(String id);
}
