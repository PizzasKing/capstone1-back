package com.manbo.homepage.dto;

import java.sql.Timestamp;
import java.util.List;

import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.RecommendBoard;
import com.manbo.homepage.entity.RecommendReply;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecommendBoardDTO {

    private Long rbid;  // 추천게시판 번호

    private Member member;  // foreign key

    private String rbtitle;  // 추천게시판 제목

    private String rbcontent; // 추천게시판 내용

    private Integer rbhit;  // 조회수

    private Timestamp createdDate;
    private Timestamp updatedDate;

    private String recommendFilename;
    private String recommendFilepath;

    private List<RecommendReply> recommendReplyList;

    public static RecommendBoardDTO toSaveDTO(RecommendBoard recommendBoard) {
        return RecommendBoardDTO.builder()
                .rbid(recommendBoard.getRbid())
                .member(recommendBoard.getMember())
                .rbtitle(recommendBoard.getRbtitle())
                .rbcontent(recommendBoard.getRbcontent())
                .rbhit(recommendBoard.getRbhit())
                .recommendFilename(recommendBoard.getRecommendFilename())
                .recommendFilepath(recommendBoard.getRecommendFilepath())
                .createdDate(recommendBoard.getCreatedDate())
                .updatedDate(recommendBoard.getUpdatedDate())
                .recommendReplyList(recommendBoard.getRecommendReplyList())
                .build();
    }

    public static RecommendBoard toEntity(RecommendBoardDTO recommendBoardDTO) {
        return RecommendBoard.builder()
                .rbid(recommendBoardDTO.getRbid())
                .member(recommendBoardDTO.getMember())
                .rbtitle(recommendBoardDTO.getRbtitle())
                .rbcontent(recommendBoardDTO.getRbcontent())
                .rbhit(recommendBoardDTO.getRbhit())
                .recommendFilename(recommendBoardDTO.getRecommendFilename())
                .recommendFilepath(recommendBoardDTO.getRecommendFilepath())
                .build();
    }
}
