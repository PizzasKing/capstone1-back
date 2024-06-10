package com.manbo.homepage.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.manbo.homepage.config.SecurityUser;
import com.manbo.homepage.dto.FreeBoardDTO;
import com.manbo.homepage.dto.MemberDTO;
import com.manbo.homepage.entity.FreeBoard;
import com.manbo.homepage.service.FreeBoardService;
import com.manbo.homepage.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/freeboard")
public class FreeBoardController {
	private final FreeBoardService freeBoardService;
    private final MemberService memberService;
	@GetMapping("/list")
	public Page<FreeBoardDTO> pagelist(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "searchOption", required = false) String searchOption,
			@RequestParam(value = "keyword", required = false) String keyword,
			@AuthenticationPrincipal SecurityUser principal) {

		Pageable pageable = PageRequest.of(page, size);

		Page<FreeBoardDTO> freeBoardPage;

		if (searchOption != null && keyword != null) {
			if ("title".equals(searchOption)) {
				freeBoardPage = freeBoardService.searchByTitle(keyword, pageable);
			} else if ("content".equals(searchOption)) {
				freeBoardPage = freeBoardService.searchByContent(keyword, pageable);
			} else {
				freeBoardPage = freeBoardService.searchByTitle(keyword, pageable);
			}
		} else {
			freeBoardPage = freeBoardService.paging(pageable);
		}

		return freeBoardPage;
	}

	@GetMapping("/{fbid}")
	public FreeBoardDTO getDetail(@PathVariable Long fbid) {
		FreeBoardDTO fb = freeBoardService.findById(fbid);
		fb.setFbhit(fb.getFbhit()+1);
		return fb;
	}

    @PostMapping("/write")
    public void write(@RequestBody FreeBoardDTO freeBoardDTO,
                      @RequestParam(value = "freeBoardFile", required = false) MultipartFile freeBoardFile) throws IOException, Exception {
        MemberDTO memberDTO = memberService.findByMidDirect(freeBoardDTO.getMember().getMid());
        freeBoardService.save(freeBoardDTO, memberDTO, freeBoardFile);
    }

	@PutMapping("/update/{fbid}")
	public FreeBoardDTO update(@PathVariable Long fbid, @RequestBody FreeBoardDTO freeBoardDTO,
			@RequestParam("freeBoardFile") MultipartFile freeBoardFile, @AuthenticationPrincipal SecurityUser principal) throws IOException, Exception {
		FreeBoard freeBoard = FreeBoard.toUpdateEntity(freeBoardDTO);
		freeBoard.setMember(principal.getMember()); // 설정된 인증된 사용자로 member 설정
		return freeBoardService.update(freeBoardDTO, freeBoardFile);
	}

	@DeleteMapping("/delete/{fbid}")
	public void deleteFreeBoard(@PathVariable Long fbid) {
		freeBoardService.deleteById(fbid);
	}

	@GetMapping("/main")
	public List<FreeBoard> mainList() {
		return freeBoardService.mainList();
	}
}

