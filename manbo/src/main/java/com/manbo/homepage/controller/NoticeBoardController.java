package com.manbo.homepage.controller;

import java.io.IOException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.manbo.homepage.config.SecurityUser;
import com.manbo.homepage.dto.MemberDTO;
import com.manbo.homepage.dto.NoticeBoardDTO;
import com.manbo.homepage.entity.NoticeBoard;
import com.manbo.homepage.service.MemberService;
import com.manbo.homepage.service.NoticeBoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notice")
@Slf4j
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;
    private final MemberService memberService;

    // 쓰기 처리
    @PostMapping("/write")
    public ResponseEntity<String> write(@RequestBody NoticeBoardDTO noticeBoardDTO,
                                        @AuthenticationPrincipal SecurityUser principal,
                                        @RequestParam("noticeBoardFile") MultipartFile noticeBoardFile) throws IOException, Exception {
        NoticeBoard noticeBoard = NoticeBoard.toSaveEntity(noticeBoardDTO);
        noticeBoard.setMember(principal.getMember());
        noticeBoard.setNbhit(0);
        noticeBoardService.save(noticeBoard, noticeBoardFile);
        return ResponseEntity.status(HttpStatus.CREATED).body("게시글 작성 성공!");
    }

    // 수정 처리
    @PutMapping("/update/{nbid}")
    public ResponseEntity<String> update(@PathVariable Long nbid,
                                         @RequestBody NoticeBoardDTO noticeBoardDTO,
                                         @RequestParam("noticeBoardFile") MultipartFile noticeBoardFile,
                                         @AuthenticationPrincipal SecurityUser principal) throws IOException, Exception {
        NoticeBoard noticeBoard = NoticeBoard.toUpdateEntity(noticeBoardDTO);
        noticeBoard.setMember(principal.getMember());
        NoticeBoardDTO upNoticeBoard = noticeBoardService.update(noticeBoardDTO, noticeBoardFile);
        return ResponseEntity.ok("게시글 수정 성공!");
    }

    // 페이징, 글 목록
    @GetMapping("/pagelist")
    public ResponseEntity<Page<NoticeBoardDTO>> pagelist(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<NoticeBoardDTO> noticeBoardPage = noticeBoardService.paging(pageable);
        return ResponseEntity.ok(noticeBoardPage);
    }

    // 상세보기
    @GetMapping("/{nbid}")
    public ResponseEntity<NoticeBoardDTO> getDetail(@PathVariable Long nbid) {
        noticeBoardService.updateHits(nbid);
        NoticeBoardDTO noticeBoardDTO = noticeBoardService.findById(nbid);
        return ResponseEntity.ok(noticeBoardDTO);
    }

    // 삭제
    @DeleteMapping("/delete/{nbid}")
    public ResponseEntity<String> deleteHopeBoard(@PathVariable Long nbid) {
        noticeBoardService.deleteById(nbid);
        return ResponseEntity.ok("게시글 삭제 성공!");
    }

    // 메인 리스트
    @GetMapping("/main")
    public ResponseEntity<List<NoticeBoard>> mainList() {
        List<NoticeBoard> mainList = noticeBoardService.mainList();
        return ResponseEntity.ok(mainList);
    }

    // 회원 정보 조회
    @GetMapping("/member")
    public ResponseEntity<MemberDTO> getMember(@AuthenticationPrincipal SecurityUser principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        MemberDTO memberDTO = memberService.findByMid(principal);
        return ResponseEntity.ok(memberDTO);
    }
}
