package com.uah.controller;

import com.uah.domain.Director;
import com.uah.service.DirectorService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/api/directores")
public class DirectorController {

    private static final Logger log = LoggerFactory.getLogger(PeliculaController.class);
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Get("/")
    public Flux<Director> getDirectores() {

        log.info("[GET] /directores");
        return directorService.findAll();
    }

    @Post("/")
    @Validated
    public Mono<Director> insertDirector(Director director) {

        log.info("[POST] /directores");
        return directorService.save(director);
    }

    @Put("/")
    @Validated
    public Mono<Director> updateDirector(Director director) {

        log.info("[PUT] /directores");
        return directorService.update(director);
    }

    @Delete("/{id}")
    public Mono<HttpResponse> deleteDirector(@PathVariable Long id) {

        log.info("[DELETE] /directores/{}", id);
        return directorService.delete(id).map(deleteStatus -> {
            if(deleteStatus == 1) {
                return HttpResponse.noContent();
            }else {
                return HttpResponse.badRequest();
            }
        });
    }
}