package com.uah.controller;

import com.uah.domain.Usuario;
import com.uah.service.UsuarioService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/usuarios")
public class UsuarioController {

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Get("/")
    public Flux<Usuario> getAllUsuarios() {

        log.info("[GET] /usuarios");
        return usuarioService.findAll();
    }

    @Post("/")
    @Validated
    public Mono<Usuario> insertUsuario(Usuario usuario) {

        log.info("[POST] /usuarios: {}", usuario.toString());
        return usuarioService.save(usuario);
    }

    @Put("/")
    @Validated
    public Mono<Usuario> updateUsuario(Usuario usuario) {

        log.info("[PUT] /usuarios: {}", usuario.toString());
        return usuarioService.update(usuario);
    }

    @Delete("/{id}")
    public Mono<HttpResponse> deleteUsuario(@PathVariable String id) {

        log.info("[DELETE] /usuarios/{}", id);
        return usuarioService.delete(id).map(deleteStatus -> {
            if(deleteStatus == 1) {
                return HttpResponse.noContent();
            }else {
                return HttpResponse.badRequest();
            }
        });
    }
}
