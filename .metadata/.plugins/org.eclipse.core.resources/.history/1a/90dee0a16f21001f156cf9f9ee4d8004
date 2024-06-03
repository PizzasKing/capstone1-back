package com.manbo.homepage.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.manbo.homepage.entity.Member;

public class SecurityUser extends User {

    private Member member;

    public SecurityUser(Member member){
        super(member.getMid(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
        this.member = member;
    }
    public Member getMember(){
        return member;
    }
}
