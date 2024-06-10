package com.manbo.homepage.controller;

import com.manbo.homepage.dto.RecommendBoardDTO;
import com.manbo.homepage.service.RecommendBoardService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommend-boards")
@RequiredArgsConstructor
public class RecommendBoardController {

    private final RecommendBoardService recommendBoardService;

    @GetMapping
    public ResponseEntity<List<RecommendBoardDTO>> getAllRecommendBoards() {
        List<RecommendBoardDTO> recommendBoardDTOs = recommendBoardService.getAllRecommendBoards();
        return ResponseEntity.ok(recommendBoardDTOs);
    }

    @GetMapping("/{rbid}")
    public ResponseEntity<RecommendBoardDTO> getRecommendBoardById(@PathVariable Long rbid) {
        RecommendBoardDTO recommendBoardDTO = recommendBoardService.getRecommendBoardById(rbid);
        return ResponseEntity.ok(recommendBoardDTO);
    }

    @PostMapping
    public ResponseEntity<RecommendBoardDTO> createRecommendBoard(@RequestBody RecommendBoardDTO recommendBoardDTO) {
        RecommendBoardDTO createdRecommendBoardDTO = recommendBoardService.createRecommendBoard(recommendBoardDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecommendBoardDTO);
    }

    @PutMapping("/{rbid}")
    public ResponseEntity<RecommendBoardDTO> updateRecommendBoard(@PathVariable Long rbid, @RequestBody RecommendBoardDTO recommendBoardDTO) {
        RecommendBoardDTO updatedRecommendBoardDTO = recommendBoardService.updateRecommendBoard(rbid, recommendBoardDTO);
        return ResponseEntity.ok(updatedRecommendBoardDTO);
    }

    @DeleteMapping("/{rbid}")
    public ResponseEntity<Void> deleteRecommendBoard(@PathVariable Long rbid) {
        recommendBoardService.deleteRecommendBoard(rbid);
        return ResponseEntity.noContent().build();
    }
}

