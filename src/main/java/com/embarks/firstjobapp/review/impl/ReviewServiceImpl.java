package com.embarks.firstjobapp.review.impl;

import com.embarks.firstjobapp.company.model.Company;
import com.embarks.firstjobapp.company.service.CompanyService;
import com.embarks.firstjobapp.exception.ResourceNotFoundException;
import com.embarks.firstjobapp.exception.ReviewsNotFoundException;
import com.embarks.firstjobapp.review.model.Review;
import com.embarks.firstjobapp.review.repository.ReviewRepository;
import com.embarks.firstjobapp.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId (companyId)
                .orElseThrow (() -> new ReviewsNotFoundException ("No reviews found for company with ID: " + companyId));
    }

    @Override
    public void addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById (companyId);
        if (company == null) {
            throw new ResourceNotFoundException ("Company", companyId);
        }
        review.setCompany (company);
        reviewRepository.save (review);
    }

    @Override
    public Review getReviewByCompanyIdAndReviewId(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId (companyId)
                .orElseThrow (() -> new ReviewsNotFoundException ("No reviews found for company with ID: " + companyId));

// Caută și returnează recenzia dorită după reviewId
        return reviews.stream ()
                .filter (review -> review.getId ().equals (reviewId))
                .findFirst ()
                .orElseThrow (() -> new ReviewsNotFoundException ("Review with ID: " + reviewId + " not found for company with ID: " + companyId));
    }

    @Override
    public void updateReviewByCompanyIdAndReviewId(Long companyId, Long reviewId, Review review) {

        if (companyService.getCompanyById (companyId) == null) {
            throw new ResourceNotFoundException ("Company", companyId);
        }
            Review existingReview = getReviewByCompanyIdAndReviewId (companyId, reviewId);

            if (review.getTitle () != null && !review.getTitle ().isEmpty ()) {
                existingReview.setTitle (review.getTitle ());
            }

            if (review.getDescription () != null && !review.getDescription ().isEmpty ()) {
                existingReview.setDescription (review.getDescription ());
            }

            if (review.getRating () != null) {
                existingReview.setRating (review.getRating ());
            }

            reviewRepository.save (existingReview);
    }

    @Override
    public void deleteReview(Long companyId, Long reviewId) {
        Review existingReview = getReviewByCompanyIdAndReviewId (companyId, reviewId);
        reviewRepository.delete (existingReview);
    }
}