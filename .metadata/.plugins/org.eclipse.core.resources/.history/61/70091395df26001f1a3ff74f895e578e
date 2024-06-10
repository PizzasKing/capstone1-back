package com.manbo.homepage.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manbo.homepage.dto.TrailDTO;
import com.manbo.homepage.entity.Trail;
import com.manbo.homepage.repository.TrailRepository;

@Service
public class TrailService {

    @Autowired
    private TrailRepository trailRepository;

    private final String uploadDir = "path/to/upload/directory";

    // 산책로 등록
    public TrailDTO saveTrail(TrailDTO trailDTO, MultipartFile image) {
        String imagePath = saveImage(image);
        trailDTO.setImagePath(imagePath);
        Trail trail = Trail.toSaveEntity(trailDTO);
        Trail savedTrail = trailRepository.save(trail);
        return TrailDTO.toSaveDTO(savedTrail);
    }

    // 산책로 상세 조회
    public TrailDTO getTrail(Long id) {
        Trail trail = trailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Trail not found"));
        return TrailDTO.toEntity(trail);
    }

    // 산책로 목록 조회
    public List<TrailDTO> getAllTrails() {
        List<Trail> trails = trailRepository.findAll();
        return trails.stream()
                .map(TrailDTO::toEntity)
                .collect(Collectors.toList());
    }

    // 산책로 수정
    public TrailDTO updateTrail(Long id, TrailDTO trailDTO, MultipartFile image) {
        Trail trail = trailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Trail not found"));
        String imagePath = saveImage(image);
        trailDTO.setImagePath(imagePath);
        Trail updatedTrail = Trail.toUpdateEntity(trailDTO);
        Trail savedTrail = trailRepository.save(updatedTrail);
        return TrailDTO.toEntity(savedTrail);
    }

    // 산책로 삭제
    public void deleteTrail(Long id) {
        trailRepository.deleteById(id);
    }

    private String saveImage(MultipartFile image) {
        if (image.isEmpty()) {
            return null;
        }

        try {
            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
            Path path = Paths.get(uploadDir, fileName);
            Files.copy(image.getInputStream(), path);
            return path.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store image", e);
        }
    }
}
