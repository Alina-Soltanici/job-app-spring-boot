package com.embarks.firstjobapp.review.repository;
import com.embarks.firstjobapp.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

   Optional<List<Review>> findByCompanyId(Long companyId);
}
