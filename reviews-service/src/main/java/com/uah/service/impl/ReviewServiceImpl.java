package com.uah.service.impl;

import com.uah.domain.Review;
import com.uah.repository.ReviewRepository;
import com.uah.service.ReviewService;
import jakarta.inject.Singleton;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Flux<Review> findUserReviews(String userId) {
        return reviewRepository.findUserReviews(new ObjectId(userId));
    }

    @Override
    public Flux<Review> findPeliculaReviews(Long peliculaId) {
        return reviewRepository.findPeliculaReviews(peliculaId);
    }

    @Override
    public Mono<Review> save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Mono<Long> delete(String id) {
        return reviewRepository.deleteById(id);
    }
}
