package com.manbo.homepage.controller;

import com.manbo.homepage.dto.TrailReviewDTO;
import com.manbo.homepage.service.TrailReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trail-reviews")
public class TrailReviewController {

    @Autowired
    private TrailReviewService trailReviewService;

    @GetMapping("/{trailId}")
    public ResponseEntity<List<TrailReviewDTO>> getReviewsByTrailId(@PathVariable Long trailId) {
        return ResponseEntity.ok(trailReviewService.getAllReviewsByTrailId(trailId));
    }

    @PostMapping
    public ResponseEntity<TrailReviewDTO> addReview(@RequestBody TrailReviewDTO reviewDTO) {
        return ResponseEntity.ok(trailReviewService.addReview(reviewDTO));
    }
}
