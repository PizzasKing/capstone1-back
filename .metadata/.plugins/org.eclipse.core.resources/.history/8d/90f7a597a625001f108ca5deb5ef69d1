package com.manbo.homepage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.manbo.homepage.config.SecurityUser;
import com.manbo.homepage.dto.MemberDTO;
import com.manbo.homepage.dto.TrailDTO;
import com.manbo.homepage.service.MemberService;
import com.manbo.homepage.service.TrailService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/trail")
public class TrailController {
    private final TrailService trailService;
    private final MemberService memberService;

    // 산책로 등록 폼
    @GetMapping("/register")
    public String insertForm(@AuthenticationPrincipal SecurityUser principal, Model model) {
        if (principal == null) {
            return "trail/register";
        } else {
            MemberDTO memberDTO = memberService.findByMid(principal);
            model.addAttribute("member", memberDTO);
            return "trail/register";
        }
    }

    // 산책로 등록 처리
    @PostMapping("/register")
    public String insert(@ModelAttribute TrailDTO trailDTO, MultipartFile trailRoute) throws Exception {
        trailService.save(trailDTO, trailRoute);
        return "redirect:/trail/list";
    }

    // 산책로 리스트
    @GetMapping("/list")
    public String getList(@RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size,
                          @RequestParam(value = "keyword", required = false) String keyword,
                          @AuthenticationPrincipal SecurityUser principal,
                          Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<TrailDTO> trailPage;

        if (keyword != null) {
            trailPage = trailService.search(keyword, pageable);
        } else {
            trailPage = trailService.paging(pageable);
        }

        List<TrailDTO> trailDTOList = trailService.findAll();

        model.addAttribute("trailPage", trailPage);
        model.addAttribute("trailList", trailDTOList);
        model.addAttribute("keyword", keyword);

        if (principal == null) {
            return "trail/list";
        } else {
            MemberDTO memberDTO = memberService.findByMid(principal);
            model.addAttribute("member", memberDTO);
            return "trail/list";
        }
    }

    // 산책로 상세
    @GetMapping("/detail/{trailId}")
    public String detail(@PathVariable Long trailId, Model model, @AuthenticationPrincipal SecurityUser principal) {
        TrailDTO trailDTO = trailService.findById(trailId);
        model.addAttribute("trail", trailDTO);
        if (principal == null) {
            return "trail/detail";
        } else {
            MemberDTO memberDTO = memberService.findByMid(principal);
            model.addAttribute("member", memberDTO);
            return "trail/detail";
        }
    }

    // 산책로 수정 폼
    @GetMapping("/update/{trailId}")
    public String updateForm(@PathVariable Long trailId, Model model, @AuthenticationPrincipal SecurityUser principal) {
        TrailDTO trailDTO = trailService.findById(trailId);
        model.addAttribute("trail", trailDTO);

        if (principal == null) {
            return "trail/update";
        } else {
            MemberDTO memberDTO = memberService.findByMid(principal);
            model.addAttribute("member", memberDTO);
            return "trail/update";
        }
    }

    // 산책로 수정 처리
    @PostMapping("/update")
    public String update(@ModelAttribute TrailDTO trailDTO, MultipartFile trailRoute) throws Exception {
        trailService.update(trailDTO, trailRoute);
        return "redirect:/trail/list";
    }

    // 산책로 삭제
    @GetMapping("/delete/{trailId}")
    public String delete(@PathVariable Long trailId) {
        trailService.deleteById(trailId);
        return "redirect:/trail/list";
    }
}
