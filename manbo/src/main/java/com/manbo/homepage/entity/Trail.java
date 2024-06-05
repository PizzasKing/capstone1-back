package com.manbo.homepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manbo.homepage.dto.TrailDTO;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@Table(name = "trail")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Trail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trailId; // 산책로 ID

    // 작성자 - 외래키
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mid")
    private Member member;

    @Column(nullable = false)
    private String startLocation; // 시작 위치

    @Column(nullable = false)
    private String trailName; // 산책로 이름

    @Column(nullable = false)
    private Integer usageCount; // 산책로 이용 횟수

    @Column(nullable = false)
    private double rating; // 산책로 평점

    @Column(nullable = true)
    private String trailRoutePath; // 산책로 경로 파일 경로

    // insert
    public static Trail toSaveEntity(TrailDTO trailDTO) {
        Trail trail = Trail.builder()
                .startLocation(trailDTO.getStartLocation())
                .trailName(trailDTO.getTrailName())
                .usageCount(trailDTO.getUsageCount())
                .rating(trailDTO.getRating())
                .member(trailDTO.getMember())
                .trailRoutePath(trailDTO.getTrailRoutePath())
                .build();
        return trail;
    }

    // update
    public static Trail toUpdateEntity(TrailDTO trailDTO) {
        Trail trail = Trail.builder()
                .trailId(trailDTO.getTrailId())
                .startLocation(trailDTO.getStartLocation())
                .trailName(trailDTO.getTrailName())
                .usageCount(trailDTO.getUsageCount())
                .rating(trailDTO.getRating())
                .member(trailDTO.getMember())
                .trailRoutePath(trailDTO.getTrailRoutePath())
                .build();
        return trail;
    }
}
