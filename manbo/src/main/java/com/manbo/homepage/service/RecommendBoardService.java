package com.manbo.homepage.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.manbo.homepage.dto.RecommendBoardDTO;
import com.manbo.homepage.entity.RecommendBoard;
import com.manbo.homepage.repository.RecommendBoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendBoardService {

    private final RecommendBoardRepository recommendBoardRepository;

    public List<RecommendBoardDTO> getAllRecommendBoards() {
        List<RecommendBoard> recommendBoards = recommendBoardRepository.findAll();
        return recommendBoards.stream()
                .map(RecommendBoardDTO::toSaveDTO)
                .collect(Collectors.toList());
    }

    public RecommendBoardDTO getRecommendBoardById(Long rbid) {
        RecommendBoard recommendBoard = recommendBoardRepository.findById(rbid)
                .orElseThrow();
        return RecommendBoardDTO.toSaveDTO(recommendBoard);
    }

    public RecommendBoardDTO createRecommendBoard(RecommendBoardDTO recommendBoardDTO) {
        RecommendBoard recommendBoard = RecommendBoard.toSaveEntity(recommendBoardDTO);
        RecommendBoard savedRecommendBoard = recommendBoardRepository.save(recommendBoard);
        return RecommendBoardDTO.toSaveDTO(savedRecommendBoard);
    }

    public RecommendBoardDTO updateRecommendBoard(Long rbid, RecommendBoardDTO recommendBoardDTO) {
        RecommendBoard existingRecommendBoard = recommendBoardRepository.findById(rbid)
                .orElseThrow();

        RecommendBoard updatedRecommendBoard = RecommendBoard.toUpdateEntity(recommendBoardDTO);
        updatedRecommendBoard.setRbid(existingRecommendBoard.getRbid());
        RecommendBoard savedRecommendBoard = recommendBoardRepository.save(updatedRecommendBoard);
        return RecommendBoardDTO.toSaveDTO(savedRecommendBoard);
    }

    public void deleteRecommendBoard(Long rbid) {
        RecommendBoard recommendBoard = recommendBoardRepository.findById(rbid)
                .orElseThrow();
        recommendBoardRepository.delete(recommendBoard);
    }
}

