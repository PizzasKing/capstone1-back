package com.manbo.homepage.dto;

import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.RecommendBoard;
import com.manbo.homepage.entity.RecommendReply;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class RecommendReplyDTO {

    private Long rrid;
    private String rrcontent;
    private RecommendBoard recommendBoard;
    private Member member;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    public static RecommendReplyDTO toSaveDTO(RecommendReply recommendReply) {
        return RecommendReplyDTO.builder()
                .rrid(recommendReply.getRrid())
                .rrcontent(recommendReply.getRrcontent())
                .recommendBoard(recommendReply.getRecommendBoard())
                .member(recommendReply.getMember())
                .createdDate(recommendReply.getCreatedDate())
                .updatedDate(recommendReply.getUpdatedDate())
                .build();
    }

    public static RecommendReply toEntity(RecommendReplyDTO recommendReplyDTO) {
        return RecommendReply.builder()
                .rrid(recommendReplyDTO.getRrid())
                .rrcontent(recommendReplyDTO.getRrcontent())
                .recommendBoard(recommendReplyDTO.getRecommendBoard())
                .member(recommendReplyDTO.getMember())
                .build();
    }
}
