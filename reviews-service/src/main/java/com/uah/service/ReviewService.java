package com.uah.service;

import com.uah.domain.Review;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewService {

    Flux<Review> findUserReviews(String userId);

    Flux<Review> findPeliculaReviews(Long peliculaId);

    Mono<Review> save(Review review);

    Mono<Long> delete(String id);
}
