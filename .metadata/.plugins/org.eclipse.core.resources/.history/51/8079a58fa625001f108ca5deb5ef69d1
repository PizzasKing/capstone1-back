package com.manbo.homepage.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manbo.homepage.dto.TrailDTO;
import com.manbo.homepage.entity.Trail;
import com.manbo.homepage.exception.FinalException;
import com.manbo.homepage.repository.TrailRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TrailService {
    private final TrailRepository trailRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    // 산책로 등록
    public void save(TrailDTO trailDTO, MultipartFile trailRoute) throws Exception {
        if (!trailRoute.isEmpty()) {
            UUID uuid = UUID.randomUUID();
            String filename = uuid + "_" + trailRoute.getOriginalFilename();
            String filepath = uploadDir + filename;

            File savedFile = new File(filepath);
            trailRoute.transferTo(savedFile);

            trailDTO.setTrailRoutePath(filepath);
        }
        Trail trail = Trail.toSaveEntity(trailDTO);
        trailRepository.save(trail);
    }

    // 산책로 리스트
    public List<TrailDTO> findAll() {
        List<Trail> trailList = trailRepository.findAll();
        List<TrailDTO> trailDTOList = new ArrayList<>();

        for (Trail trail : trailList) {
            TrailDTO trailDTO = TrailDTO.toSaveDTO(trail);
            trailDTOList.add(trailDTO);
        }
        return trailDTOList;
    }

    // 산책로 상세보기
    public TrailDTO findById(Long trailId) {
        Optional<Trail> findTrail = trailRepository.findById(trailId);
        if (findTrail.isPresent()) {
            TrailDTO trailDTO = TrailDTO.toSaveDTO(findTrail.get());
            return trailDTO;
        } else {
            throw new FinalException("페이지를 찾을 수 없습니다.");
        }
    }

    // 산책로 수정
    public void update(TrailDTO trailDTO, MultipartFile trailRoute) throws Exception {
        if (!trailRoute.isEmpty()) {
            UUID uuid = UUID.randomUUID();
            String filename = uuid + "_" + trailRoute.getOriginalFilename();
            String filepath = uploadDir + filename;

            File savedFile = new File(filepath);
            trailRoute.transferTo(savedFile);

            trailDTO.setTrailRoutePath(filepath);
        }

        Trail trail = Trail.toUpdateEntity(trailDTO);
        trailRepository.save(trail);
    }

    // 산책로 삭제
    public void deleteById(Long trailId) {
        trailRepository.deleteById(trailId);
    }

    // 검색
    public Page<TrailDTO> search(String keyword, Pageable pageable) {
        Page<Trail> searchResults = trailRepository.findByTrailNameContainingIgnoreCaseOrStartLocationContainingIgnoreCase(keyword, pageable);

        // Page<Trail>를 Page<TrailDTO>로 변환
        return searchResults.map(TrailDTO::toSaveDTO);
    }

    // 페이징 처리
    public Page<TrailDTO> paging(Pageable pageable) {
        Page<Trail> trailPage = trailRepository.findAll(pageable);
        return trailPage.map(TrailDTO::toSaveDTO);
    }
}
