package com.manbo.homepage.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import com.manbo.homepage.dto.TrailDTO;
import com.manbo.homepage.entity.Trail;
import com.manbo.homepage.exception.FinalException;
import com.manbo.homepage.repository.TrailRepository;

import java.io.File;
import java.sql.Timestamp;
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

	//산책로 등록
    public void save(TrailDTO trailDTO, MultipartFile trailRoute) throws Exception {
        if (!trailRoute.isEmpty()) {
            UUID uuid = UUID.randomUUID();
            String bfilename = uuid + "_" + trailRoute.getOriginalFilename(); // 원본파일
            String bfilepath = uploadDir + bfilename;

            File savedFile = new File(bfilepath);
            trailRoute.transferTo(savedFile);
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
		Optional<Trail> findtrail = trailRepository.findById(trailId);
		if (findtrail.isPresent()) {
			TrailDTO trailDTO = TrailDTO.toSaveDTO(findtrail.get());
			return trailDTO;
		} else {
			throw new FinalException("페이지를 찾을 수 없습니다.");
		}
	}

	// 산책로 수정
	public void update(TrailDTO trailDTO, MultipartFile trailFile) throws Exception {
		
		Trail trail = Trail.toUpdateEntity(trailDTO);
		trailRepository.save(trail);
	}

	// 산책로 삭제
	public void deleteById(Long trailId) {
		trailRepository.deleteById(trailId);
	}

	// 검색
	public Page<TrailDTO> search(String keyword, Pageable pageable) {
		Page<Trail> searchResults = trailRepository.findByTrailNameContainingIgnoreCaseOrStartLocationContainingIgnoreCase(keyword,
				pageable);

		// Page<trail>를 Page<trailDTO>로 변환
		return searchResults.map(TrailDTO::toSaveDTO);
	}

	// 페이징 처리
	public Page<TrailDTO> paging(Pageable pageable) {
		Page<Trail> trailPage = trailRepository.findAll(pageable);
		return trailPage.map(trail -> TrailDTO.toSaveDTO(trail));
	}

}
