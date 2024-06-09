package com.manbo.homepage.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.manbo.homepage.dto.FreeBoardDTO;
import com.manbo.homepage.dto.RouteDTO;
import com.manbo.homepage.dto.TrailDTO;
import com.manbo.homepage.entity.FreeBoard;
import com.manbo.homepage.entity.Route;
import com.manbo.homepage.entity.Trail;
import com.manbo.homepage.repository.RouteRepository;
import com.manbo.homepage.repository.TrailRepository;

import jakarta.persistence.EntityNotFoundException;

import java.io.IOException;

@Service
@Transactional
public class TrailService {

	private final TrailRepository trailRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public TrailService(TrailRepository trailRepository, RouteRepository routeRepository) {
        this.trailRepository = trailRepository;
        this.routeRepository = routeRepository;
    }

    public void save(TrailDTO trailDTO, RouteDTO routeDTO, MultipartFile trailFile) throws IOException, Exception {
        Trail trail = Trail.toSaveEntity(trailDTO);
        // 파일 업로드 및 관련 처리 로직 추가
        
        
        trailRepository.save(trail);
    }

    public TrailDTO update(Long trailId, TrailDTO trailDTO, MultipartFile trailFile) throws IOException, Exception {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(() -> new EntityNotFoundException("Trail not found with id: " + trailId));

        // TrailDTO를 이용하여 Trail 엔티티 업데이트
        // 파일 업로드 및 관련 처리 로직 추가

        return TrailDTO.toSaveDTO(trail);
    }

    public void deleteTrail(Long trailId) {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(() -> new EntityNotFoundException("Trail not found with id: " + trailId));

        trailRepository.delete(trail);
    }

    public TrailDTO findById(Long trailId) {
        Trail trail = trailRepository.findById(trailId)
                .orElseThrow(() -> new EntityNotFoundException("Trail not found with id: " + trailId));

        return TrailDTO.toSaveDTO(trail);
    }

	public Page<TrailDTO> paging(Pageable pageable) {
		Pageable reversePageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
				Sort.by(Sort.Direction.DESC, "fbid"));
		Page<Trail> trailPage = trailRepository.findAll(reversePageable);
		return trailPage.map(TrailDTO::toSaveDTO);
	}

	public void updateTrailRating(Long trailId, double averageRating) {
		// TODO Auto-generated method stub
		
	}
	
}
