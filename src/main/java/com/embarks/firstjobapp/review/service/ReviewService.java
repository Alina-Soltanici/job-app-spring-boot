package com.embarks.firstjobapp.review.service;

import com.embarks.firstjobapp.review.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    void addReview(Long companyId, Review review);

    Review getReviewByCompanyIdAndReviewId(Long companyId, Long reviewId);

    void updateReviewByCompanyIdAndReviewId(Long companyId, Long reviewId, Review review);

    void deleteReview(Long companyId, Long reviewId);
}
