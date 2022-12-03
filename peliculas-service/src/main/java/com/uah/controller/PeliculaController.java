package com.uah.controller;

import com.uah.domain.Pelicula;
import com.uah.service.PeliculaService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/api/peliculas")
public class PeliculaController {

    private static final Logger log = LoggerFactory.getLogger(PeliculaController.class);

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @Get("/")
    public Flux<Pelicula> getPeliculas() {

        log.info("[GET] /peliculas");
        return peliculaService.findAll().log();
    }

    @Post("/")
    @Validated
    public Mono<Pelicula> insertPelicula(Pelicula pelicula) {

        log.info("[POST] /peliculas");
        return peliculaService.save(pelicula);
    }

    @Put("/")
    @Validated
    public Mono<Pelicula> updatePelicula(Pelicula pelicula) {

        log.info("[PUT] /peliculas");
        return peliculaService.update(pelicula);
    }

    @Delete("/{id}")
    public Mono<HttpResponse> deletePelicula(@PathVariable Long id) {

        log.info("[DELETE] /peliculas/{}", id);
        return peliculaService.delete(id).map(deleteStatus -> {
            if(deleteStatus == 1) {
                return HttpResponse.noContent();
            }else {
                return HttpResponse.badRequest();
            }
        });
    }
}
