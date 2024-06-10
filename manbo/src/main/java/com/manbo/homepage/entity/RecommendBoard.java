package com.manbo.homepage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manbo.homepage.dto.RecommendBoardDTO;

@Entity
@Data
@Table(name = "recommend_board")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rbid; // 추천게시판 번호

    @Column(nullable = false)
    private String rbtitle; // 추천게시판 제목

    @Column(length = 2000, nullable = false)
    private String rbcontent; // 추천게시판 내용

    @Column(nullable = true)
    private Integer rbhit; // 조회수

    @Column
    private String recommendFilename;

    @Column
    private String recommendFilepath;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="mid")
    private Member member;

    @OneToMany(mappedBy = "recommendBoard", cascade = CascadeType.ALL)
    @OrderBy("rrid desc")
    @JsonIgnore
    private List<RecommendReply> recommendReplyList;

    public static RecommendBoard toSaveEntity(RecommendBoardDTO recommendBoardDTO) {
        return RecommendBoard.builder()
                .rbtitle(recommendBoardDTO.getRbtitle())
                .rbcontent(recommendBoardDTO.getRbcontent())
                .rbhit(0)
                .recommendFilename(recommendBoardDTO.getRecommendFilename())
                .recommendFilepath(recommendBoardDTO.getRecommendFilepath())
                .member(recommendBoardDTO.getMember())
                .build();
    }

    public static RecommendBoard toUpdateEntity(RecommendBoardDTO recommendBoardDTO) {
        return RecommendBoard.builder()
                .rbid(recommendBoardDTO.getRbid())
                .rbtitle(recommendBoardDTO.getRbtitle())
                .rbcontent(recommendBoardDTO.getRbcontent())
                .rbhit(recommendBoardDTO.getRbhit())
                .recommendFilename(recommendBoardDTO.getRecommendFilename())
                .recommendFilepath(recommendBoardDTO.getRecommendFilepath())
                .member(recommendBoardDTO.getMember())
                .build();
    }
}
