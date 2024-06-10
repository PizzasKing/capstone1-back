package com.manbo.homepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.manbo.homepage.dto.TrailDTO;
import com.manbo.homepage.service.TrailService;

@RestController
@RequestMapping("/api/trails")
public class TrailController {

    @Autowired
    private TrailService trailService;

    // 산책로 등록
    @PostMapping
    public ResponseEntity<TrailDTO> createTrail(@RequestPart("trail") TrailDTO trailDTO,
                                                @RequestPart("image") MultipartFile image) {
        TrailDTO savedTrail = trailService.saveTrail(trailDTO, image);
        return new ResponseEntity<>(savedTrail, HttpStatus.CREATED);
    }

    // 산책로 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<TrailDTO> getTrail(@PathVariable Long id) {
        TrailDTO trail = trailService.getTrail(id);
        return new ResponseEntity<>(trail, HttpStatus.OK);
    }

    // 산책로 목록 조회
    @GetMapping("/list")
    public ResponseEntity<List<TrailDTO>> getAllTrails() {
        List<TrailDTO> trails = trailService.getAllTrails();
        return new ResponseEntity<>(trails, HttpStatus.OK);
    }

    // 산책로 수정
    @PutMapping("/{id}")
    public ResponseEntity<TrailDTO> updateTrail(@PathVariable Long id,
                                                @RequestPart("trail") TrailDTO trailDTO,
                                                @RequestPart("image") MultipartFile image) {
        TrailDTO updatedTrail = trailService.updateTrail(id, trailDTO, image);
        return new ResponseEntity<>(updatedTrail, HttpStatus.OK);
    }

    // 산책로 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrail(@PathVariable Long id) {
        trailService.deleteTrail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
