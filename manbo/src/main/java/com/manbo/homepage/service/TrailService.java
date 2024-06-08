package com.manbo.homepage.service;

import com.manbo.homepage.dto.TrailDTO;
import com.manbo.homepage.entity.Trail;
import com.manbo.homepage.repository.TrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrailService {

    @Autowired
    private TrailRepository trailRepository;

    public TrailDTO getTrailById(Long trailId) {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(() -> new RuntimeException("Trail not found"));
        return TrailDTO.toSaveDTO(trail);
    }

    public List<TrailDTO> getAllTrails() {
        return trailRepository.findAll().stream()
                .map(TrailDTO::toSaveDTO)
                .collect(Collectors.toList());
    }

    public TrailDTO addTrail(TrailDTO trailDTO) {
        Trail trail = Trail.toSaveEntity(trailDTO);
        trail = trailRepository.save(trail);
        return TrailDTO.toSaveDTO(trail);
    }

    public void removeTrail(Long trailId) {
        trailRepository.deleteById(trailId);
    }

    public void updateTrailRating(Long trailId, double averageRating) {
        Trail trail = trailRepository.findById(trailId).orElseThrow(() -> new IllegalArgumentException("Invalid trail ID"));
        trail.setRating(averageRating);
        trailRepository.save(trail);
    }
}
