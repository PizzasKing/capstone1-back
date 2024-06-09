package com.manbo.homepage.controller;

import com.manbo.homepage.config.SecurityUser;
import com.manbo.homepage.dto.TrailDTO;
import com.manbo.homepage.dto.MemberDTO;
import com.manbo.homepage.dto.RouteDTO;
import com.manbo.homepage.dto.TrailDTO;
import com.manbo.homepage.entity.FreeBoard;
import com.manbo.homepage.service.FreeBoardService;
import com.manbo.homepage.service.MemberService;
import com.manbo.homepage.service.RouteService;
import com.manbo.homepage.service.TrailService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trail")
public class TrailController {
	private final TrailService trailService;
	private final RouteService routeService;

	@GetMapping("/list")
	public Page<TrailDTO> pagelist(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "searchOption", required = false) String searchOption,
			@RequestParam(value = "keyword", required = false) String keyword,
			@AuthenticationPrincipal SecurityUser principal) {

		Pageable pageable = PageRequest.of(page, size);

		Page<TrailDTO> trailPage;

		trailPage = trailService.paging(pageable);

		return trailPage;
	}

	@GetMapping("/{trailId}")
	public TrailDTO getDetail(@PathVariable Long trailId) {
		return trailService.findById(trailId);
	}

//	@PostMapping("/register")
//	public void write(@RequestBody TrailDTO trailDTO,
//			@RequestParam(value = "routeFile", required = false) MultipartFile routeFile)
//			throws IOException, Exception {
//		RouteDTO routeDTO = routeService.findByRouteIdDirect(trailDTO.getRouteId());
//		trailService.save(trailDTO, routeDTO, routeFile);
//	}

	@PutMapping("/update/{trailId}")
	public TrailDTO update(@PathVariable Long trailId, @RequestBody TrailDTO trailDTO,
			@RequestParam(value = "routeFile", required = false) MultipartFile routeFile)
			throws IOException, Exception {
		return trailService.update(trailId, trailDTO, routeFile);
	}

	@DeleteMapping("/delete/{trailId}")
	public void deleteTrail(@PathVariable Long trailId) {
		trailService.deleteTrail(trailId);
	}
}
