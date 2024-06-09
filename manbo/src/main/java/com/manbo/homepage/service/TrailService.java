package com.manbo.homepage.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manbo.homepage.dto.TrailDTO;
import com.manbo.homepage.entity.Trail;
import com.manbo.homepage.repository.TrailRepository;

@Service
public class TrailService {

    @Autowired
    private TrailRepository trailRepository;

    // 산책로 등록
    public TrailDTO saveTrail(TrailDTO trailDTO) {
        Trail trail = Trail.toSaveEntity(trailDTO);
        Trail savedTrail = trailRepository.save(trail);
        return TrailDTO.toSaveDTO(savedTrail);
    }

    // 산책로 상세 조회
    public TrailDTO getTrail(Long id) {
        Trail trail = trailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Trail not found"));
        return TrailDTO.toEntity(trail);
    }
    // 산책로 상세 조회
    public Trail getTrailDirect(Long id) {
        Trail trail = trailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Trail not found"));
        return trail;
    }

    // 산책로 목록 조회
    public List<TrailDTO> getAllTrails() {
        List<Trail> trails = trailRepository.findAll();
        return trails.stream()
                .map(TrailDTO::toEntity)
                .collect(Collectors.toList());
    }

    // 산책로 수정
    public TrailDTO updateTrail(Long id, TrailDTO trailDTO) {
        Trail trail = trailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Trail not found"));
        Trail updatedTrail = Trail.toUpdateEntity(trailDTO);
        Trail savedTrail = trailRepository.save(updatedTrail);
        return TrailDTO.toEntity(savedTrail);
    }

    // 산책로 삭제
    public void deleteTrail(Long id) {
        trailRepository.deleteById(id);
    }
}
