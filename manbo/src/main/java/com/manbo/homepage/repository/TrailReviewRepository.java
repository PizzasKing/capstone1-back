package com.manbo.homepage.repository;

import com.manbo.homepage.entity.TrailReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrailReviewRepository extends JpaRepository<TrailReview, Long> {

    List<TrailReview> findAllByTrail_TrailId(Long trailId);

    @Query("SELECT AVG(tr.rating) FROM TrailReview tr WHERE tr.trail.trailId = :trailId")
    double findAverageRatingByTrailId(@Param("trailId") Long trailId);
}
