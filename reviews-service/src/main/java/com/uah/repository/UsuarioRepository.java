package com.uah.repository;

import com.uah.domain.Usuario;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

@MongoRepository
public interface UsuarioRepository extends ReactorCrudRepository<Usuario, String> {
}
