package com.uah.controller;

import com.uah.domain.Actor;
import com.uah.service.ActorService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/api/actores")
public class ActorController {

    private static final Logger log = LoggerFactory.getLogger(PeliculaController.class);
    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @Get("/")
    public Flux<Actor> getActores() {

        log.info("[GET] /actores");
        return actorService.findAll();
    }

    @Post("/")
    @Validated
    public Mono<Actor> insertActor(Actor actor) {

        log.info("[POST] /actores");
        return actorService.save(actor);
    }

    @Put("/")
    @Validated
    public Mono<Actor> updateActor(Actor actor) {

        log.info("[PUT] /actores");
        return actorService.update(actor);
    }

    @Delete("/{id}")
    public Mono<HttpResponse> deleteActor(@PathVariable Long id) {

        log.info("[DELETE] /actores/{}", id);
        return actorService.delete(id).map(deleteStatus -> {
            if(deleteStatus == 1) {
                return HttpResponse.noContent();
            }else {
                return HttpResponse.badRequest();
            }
        });
    }
}
