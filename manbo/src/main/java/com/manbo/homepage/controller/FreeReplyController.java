package com.manbo.homepage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.manbo.homepage.config.SecurityUser;
import com.manbo.homepage.entity.FreeReply;
import com.manbo.homepage.service.FreeReplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/freereply")
public class FreeReplyController {
    private final FreeReplyService freeReplyService;

    @PostMapping("/{freeBoardFbid}")
    public ResponseEntity<String> insertReply(@PathVariable Long freeBoardFbid,
                                              @RequestBody FreeReply freeReply,
                                              @AuthenticationPrincipal SecurityUser principal) {
        freeReply.setMember(principal.getMember());
        freeReplyService.insertReply(freeBoardFbid, freeReply);
        
        return ResponseEntity.status(HttpStatus.CREATED).body("댓글 등록 성공!");
    }
    
    @PutMapping("/{freeReplyFrid}")
    public ResponseEntity<String> updateReply(@PathVariable Long freeReplyFrid, @RequestBody FreeReply freeReply) {
        FreeReply updateFreeReply = freeReplyService.findById(freeReplyFrid);
        if (updateFreeReply == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("수정할 댓글을 찾을 수 없습니다");
        }
        updateFreeReply.setFrcontent(freeReply.getFrcontent()); // 새로운 내용으로 댓글 업데이트
        freeReplyService.save(updateFreeReply); // 업데이트된 댓글 저장
        return ResponseEntity.ok("댓글 수정 완료!");
    }
    
    @DeleteMapping("/{freeReplyFrid}")
    public ResponseEntity<String> deleteReply(@PathVariable Long freeReplyFrid) {
        freeReplyService.deleteById(freeReplyFrid);
        return ResponseEntity.ok("댓글 삭제 완료!");
    }
}
