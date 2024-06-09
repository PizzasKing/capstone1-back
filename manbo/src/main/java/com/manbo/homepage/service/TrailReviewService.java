package com.manbo.homepage.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manbo.homepage.dto.TrailReviewDTO;
import com.manbo.homepage.entity.TrailReview;
import com.manbo.homepage.repository.TrailReviewRepository;

@Service
public class TrailReviewService {

    @Autowired
    private TrailReviewRepository trailReviewRepository;

    public List<TrailReviewDTO> getAllTrailReviews() {
        List<TrailReview> reviews = trailReviewRepository.findAll();
        return reviews.stream()
                .map(TrailReviewDTO::toSaveDTO)
                .collect(Collectors.toList());
    }

    public TrailReviewDTO getTrailReviewById(Long id) {
        TrailReview review = trailReviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trail review not found"));
        return TrailReviewDTO.toSaveDTO(review);
    }

    public TrailReviewDTO createTrailReview(TrailReviewDTO reviewDTO) {
        TrailReview review = TrailReview.toSaveEntity(reviewDTO);
        TrailReview savedReview = trailReviewRepository.save(review);
        return TrailReviewDTO.toSaveDTO(savedReview);
    }

    public TrailReviewDTO updateTrailReview(Long id, TrailReviewDTO reviewDTO) {
        TrailReview review = trailReviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trail review not found"));
        review.setReviewRank(reviewDTO.getReviewRank());
        review.setReviewContent(reviewDTO.getReviewContent());
        review.setTrail(reviewDTO.getTrail());
        review.setMember(reviewDTO.getMember());
        TrailReview updatedReview = trailReviewRepository.save(review);
        return TrailReviewDTO.toSaveDTO(updatedReview);
    }

    public void deleteTrailReview(Long id) {
        trailReviewRepository.deleteById(id);
    }
}
