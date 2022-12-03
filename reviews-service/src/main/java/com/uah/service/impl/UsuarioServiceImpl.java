package com.uah.service.impl;

import com.uah.domain.Usuario;
import com.uah.repository.UsuarioRepository;
import com.uah.service.UsuarioService;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Mono<Usuario> findById(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Flux<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Mono<Usuario> save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Mono<Usuario> update(Usuario usuario) {
        return usuarioRepository.update(usuario);
    }

    @Override
    public Mono<Long> delete(String id) {
        return usuarioRepository.deleteById(id);
    }
}
