package com.manbo.homepage.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "recommend_reply")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendReply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rrid; // 추천게시판 댓글 번호

    @Column(nullable = false)
    private String rrcontent; // 추천게시판 댓글 내용

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rbid")
    private RecommendBoard recommendBoard;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mid")
    private Member member;

}
