package com.manbo.homepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manbo.homepage.dto.TrailReviewDTO;
import com.manbo.homepage.service.TrailReviewService;

@RestController
@RequestMapping("/api/trail-reviews")
public class TrailReviewController {

    @Autowired
    private TrailReviewService trailReviewService;

    @GetMapping
    public ResponseEntity<List<TrailReviewDTO>> getAllTrailReviews() {
        List<TrailReviewDTO> reviews = trailReviewService.getAllTrailReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrailReviewDTO> getTrailReviewById(@PathVariable Long id) {
        TrailReviewDTO review = trailReviewService.getTrailReviewById(id);
        return ResponseEntity.ok(review);
    }

    @PostMapping
    public ResponseEntity<TrailReviewDTO> createTrailReview(@RequestBody TrailReviewDTO reviewDTO) {
        TrailReviewDTO createdReview = trailReviewService.createTrailReview(reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrailReviewDTO> updateTrailReview(@PathVariable Long id, @RequestBody TrailReviewDTO reviewDTO) {
        TrailReviewDTO updatedReview = trailReviewService.updateTrailReview(id, reviewDTO);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrailReview(@PathVariable Long id) {
        trailReviewService.deleteTrailReview(id);
        return ResponseEntity.noContent().build();
    }
}
