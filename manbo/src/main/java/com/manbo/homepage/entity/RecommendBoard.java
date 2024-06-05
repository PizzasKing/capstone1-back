package com.manbo.homepage.entity;

import lombok.*;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "recommend_board")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendId; // 산책로 추천 게시판 번호

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mid", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trail_id", nullable = false)
    private Trail trailId;

    @Column(nullable = false)
    private String title; // 게시글 제목

    @Column(nullable = false, length = 2000)
    private String content; // 게시글 내용

    @Column(nullable = false)
    private Timestamp createdDate; // 등록일

    @Column(nullable = false)
    private Integer viewCount; // 조회수

    @Column(nullable = false)
    private Integer likeCount; // 좋아요 수

}
