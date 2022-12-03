package com.uah.controller;

import com.uah.domain.Review;
import com.uah.service.ReviewService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller("/")
public class ReviewController {

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Get("/peliculas/{id}/reviews")
    public Flux<Review> getPeliculaReviews(@PathVariable Long id) {

        log.info("[GET] /peliculas/{}/reviews", id);
        return reviewService.findPeliculaReviews(id).log();
    }

    @Get("/usuarios/{id}/reviews")
    public Flux<Review> getUsuarioReviews(@PathVariable String id) {

        log.info("[GET] /usuarios/{}/reviews", id);

        if(!ObjectId.isValid(id)) {
            return Flux.just();
        }
        return reviewService.findUserReviews(id);
    }

    @Post("/reviews")
    @Validated
    public Mono<Review> insertReview(Review review) {

        log.info("[POST] /reviews: {}", review.toString());
        return reviewService.save(review);
    }

    @Delete("/reviews/{id}")
    public Mono<HttpResponse> deleteReview(@PathVariable String id) {

        log.info("[DELETE] /reviews/{}", id);
        return reviewService.delete(id).map(deleteStatus -> {
            if(deleteStatus == 1) {
                return HttpResponse.noContent();
            }else {
                return HttpResponse.badRequest();
            }
        });
    }
}
