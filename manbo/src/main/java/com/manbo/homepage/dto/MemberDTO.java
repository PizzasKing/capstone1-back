package com.manbo.homepage.dto;


import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.Role;

@Data
@Builder
public class MemberDTO {
    private Long memberId;

    @NotEmpty(message = "ID는 필수 항목입니다.")
    @Size(min = 6)
    private String mid;

    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하여야 합니다.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!*]).*$", message = "비밀번호는 영문, 숫자, 특수문자를 모두 포함해야 합니다.")
    private String password;

    @NotEmpty(message = "이메일은 필수 항목입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotEmpty(message = "이름은 필수 항목입니다.")
    @Pattern(regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$", message = "사용할 수 없는 닉네임 입니다.")
    private String name;

    private Role role;

    private Timestamp createdDate;
    private Timestamp updatedDate;


    public static MemberDTO toSaveDTO(Member member){
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId(member.getMemberId())
                .mid(member.getMid())
                .password(member.getPassword())
                .email(member.getEmail())
                .name(member.getName())
                .role(member.getRole())
                .createdDate(member.getCreatedDate())
                .updatedDate(member.getUpdatedDate())
                .build();
        return memberDTO;
    }

    // MemberDTO -> Member
    public static Member toEntity(MemberDTO memberDTO) {
        return Member.builder()
                .memberId(memberDTO.getMemberId())
                .mid(memberDTO.getMid())
                .password(memberDTO.getPassword())
                .email(memberDTO.getEmail())
                .name(memberDTO.getName())
                .role(memberDTO.getRole())
                .build();
    }
}