package com.manbo.homepage.service;

import com.manbo.homepage.dto.TrailReviewDTO;
import com.manbo.homepage.entity.TrailReview;
import com.manbo.homepage.repository.TrailReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrailReviewService {

    @Autowired
    private TrailReviewRepository trailReviewRepository;

    @Autowired
    private TrailService trailService;

    public List<TrailReviewDTO> getAllReviewsByTrailId(Long trailId) {
        return trailReviewRepository.findAllByTrail_TrailId(trailId).stream()
                .map(TrailReviewDTO::toSaveDTO)
                .collect(Collectors.toList());
    }

    public TrailReviewDTO addReview(TrailReviewDTO reviewDTO) {
        TrailReview review = TrailReview.toSaveEntity(reviewDTO);
        review = trailReviewRepository.save(review);
        
        return TrailReviewDTO.toSaveDTO(review);
    }

  
}
