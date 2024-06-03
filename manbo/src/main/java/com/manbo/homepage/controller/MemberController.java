package com.manbo.homepage.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.manbo.homepage.dto.MemberDTO;
import com.manbo.homepage.service.MemberService;

import java.util.List;

@Slf4j
@RestController // 컨트롤러를 REST API로 사용하려면 @RestController로 선언합니다.
@RequiredArgsConstructor
@RequestMapping("/api/v1/members") // URL을 리소스 중심으로 변경합니다.
public class MemberController {
    private final MemberService memberService;
    private final AuthenticationManager authenticationManager;

    // 회원 가입
    @PostMapping("/join")
    public ResponseEntity<String> join(@Valid @RequestBody MemberDTO memberDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation error"); // 유효성 검사 실패 시 400 에러 반환
        }
        memberService.save(memberDTO);
        return ResponseEntity.ok("Join successful"); // 성공 시 200 반환
    }

    // 회원 목록 조회
    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        List<MemberDTO> memberDTOList = memberService.findAll();
        return ResponseEntity.ok(memberDTOList);
    }

    // 개별 회원 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Long memberId) {
        MemberDTO memberDTO = memberService.findById(memberId);
        if (memberDTO == null) {
            return ResponseEntity.notFound().build(); // 해당 회원이 없을 경우 404 에러 반환
        }
        return ResponseEntity.ok(memberDTO);
    }   
    //로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDTO memberDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(memberDTO.getMid(), memberDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok("Login successful");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    // 회원 삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable Long memberId) {
        memberService.deleteById(memberId);
        return ResponseEntity.ok("Member deleted successfully");
    }

    // 회원 수정
    @PutMapping("/{memberId}")
    public ResponseEntity<String> updateMember(@PathVariable Long memberId, @Valid @RequestBody MemberDTO memberDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation error");
        }
        MemberDTO existingMember = memberService.findById(memberId);
        if (existingMember == null) {
            return ResponseEntity.notFound().build();
        }
        memberDTO.setMemberId(memberId);
        memberService.update(memberDTO);
        return ResponseEntity.ok("Member updated successfully");
    }
}
