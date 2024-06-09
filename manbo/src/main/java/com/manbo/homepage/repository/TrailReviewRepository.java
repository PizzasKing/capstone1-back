package com.manbo.homepage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manbo.homepage.entity.TrailReview;

@Repository
public interface TrailReviewRepository extends JpaRepository<TrailReview, Long> {
}
