package com.manbo.homepage.dto;

import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.RecommendBoard;
import com.manbo.homepage.entity.Trail;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class RecommendBoardDTO {

    private Long recommendId; // 산책로 추천 게시판 번호

    private Member member; // 회원 정보

    private Trail trailId; // 산책로 정보

    private String title; // 게시글 제목

    private String content; // 게시글 내용

    private Timestamp createdDate; // 등록일

    private Integer viewCount; // 조회수

    private Integer likeCount; // 좋아요 수

    // Entity -> DTO
    public static RecommendBoardDTO toDTO(RecommendBoard recommendBoard) {
        return RecommendBoardDTO.builder()
                .recommendId(recommendBoard.getRecommendId())
                .member(recommendBoard.getMember())
                .trailId(recommendBoard.getTrailId())
                .title(recommendBoard.getTitle())
                .content(recommendBoard.getContent())
                .createdDate(recommendBoard.getCreatedDate())
                .viewCount(recommendBoard.getViewCount())
                .likeCount(recommendBoard.getLikeCount())
                .build();
    }

    // DTO -> Entity (Save)
    public static RecommendBoard toSaveEntity(RecommendBoardDTO recommendBoardDTO) {
        return RecommendBoard.builder()
                .member(recommendBoardDTO.getMember())
                .trailId(recommendBoardDTO.getTrailId())
                .title(recommendBoardDTO.getTitle())
                .content(recommendBoardDTO.getContent())
                .createdDate(recommendBoardDTO.getCreatedDate())
                .viewCount(0) // 초기 조회수는 0으로 설정
                .likeCount(0) // 초기 좋아요 수는 0으로 설정
                .build();
    }
}
