package com.example.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.example.kotlingraphql.entity.Review
import org.springframework.stereotype.Component
import com.example.kotlingraphql.repository.ReviewRepository

@Component
class ReviewMutationResolver (private val reviewRepository: ReviewRepository): GraphQLMutationResolver {
    fun newReview(snackId: String, rating: Int, text: String): Review {
        val review = Review(snackId, rating, text)
        reviewRepository.save(review)
        return review
    }
}