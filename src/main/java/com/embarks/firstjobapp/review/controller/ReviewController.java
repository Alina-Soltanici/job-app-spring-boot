package com.embarks.firstjobapp.review.controller;

import com.embarks.firstjobapp.review.model.Review;
import com.embarks.firstjobapp.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable(name = "companyId") Long companyId) {
        List<Review> reviews = reviewService.getAllReviews (companyId);
        return ResponseEntity.status (HttpStatus.OK).body (reviews);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable(name = "companyId") Long companyId, @RequestBody Review review) {
        reviewService.addReview(companyId, review);
        return ResponseEntity.status (HttpStatus.CREATED).body ("Review added successfully!");
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewByCompanyIdAndReviewId(@PathVariable(name = "companyId") Long companyId,
                                                                  @PathVariable(name = "reviewId") Long reviewId) {
        Review review =
                reviewService.getReviewByCompanyIdAndReviewId(companyId, reviewId);
        return ResponseEntity.status (HttpStatus.OK).body (review);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable(name = "companyId") Long companyId, @PathVariable(name = "reviewId") Long reviewId, @RequestBody Review review) {
        reviewService.updateReviewByCompanyIdAndReviewId(companyId, reviewId, review);
        return ResponseEntity.status (HttpStatus.OK).body ("Review has been updated successfully!");
    }

    @DeleteMapping("reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable(name = "companyId") Long companyId, @PathVariable(name = "reviewId") Long reviewId) {
        reviewService.deleteReview(companyId, reviewId);
        return ResponseEntity.status (HttpStatus.OK).body ("Review with id " + reviewId + " has been removed successfuly!");
    }


}
