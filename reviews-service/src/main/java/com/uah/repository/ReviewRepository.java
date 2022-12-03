package com.uah.repository;

import com.uah.domain.Review;
import io.micronaut.data.mongodb.annotation.MongoAggregateQuery;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;

@MongoRepository
public interface ReviewRepository extends ReactorCrudRepository<Review, String> {

    @MongoAggregateQuery("[{\n" +
            " $match: {\n" +
            "  user_id: :userId \n" +
            " }\n" +
            "}, {\n" +
            " $lookup: {\n" +
            "  from: 'usuarios',\n" +
            "  localField: 'user_id',\n" +
            "  foreignField: '_id',\n" +
            "  as: 'usuario'\n" +
            " }\n" +
            "}, {\n" +
            " $unwind: {\n" +
            "  path: '$usuario',\n" +
            "  preserveNullAndEmptyArrays: false\n" +
            " }\n" +
            "}]")
    Flux<Review> findUserReviews(ObjectId userId);

    @MongoAggregateQuery("[{\n" +
            " $match: {\n" +
            "  pelicula_id: :peliculaId\n" +
            " }\n" +
            "}, {\n" +
            " $lookup: {\n" +
            "  from: 'usuarios',\n" +
            "  localField: 'user_id',\n" +
            "  foreignField: '_id',\n" +
            "  as: 'usuario'\n" +
            " }\n" +
            "}, {\n" +
            " $unwind: {\n" +
            "  path: '$usuario',\n" +
            "  preserveNullAndEmptyArrays: false\n" +
            " }\n" +
            "}]")
    Flux<Review> findPeliculaReviews(Long peliculaId);
}
