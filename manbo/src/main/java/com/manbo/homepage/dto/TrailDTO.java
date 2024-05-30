package com.manbo.homepage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.Trail;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrailDTO {

    private Long trailId; // 산책로 ID
    private Member member;
    private String startLocation; // 시작 위치
    private String trailName; // 산책로 이름
    private int usageCount; // 산책로 이용 횟수
    private double rating; // 산책로 평점
    private Timestamp createdDate; 
    
    public static TrailDTO toSaveDTO(Trail trail) {
    	TrailDTO trailDTO = TrailDTO.builder()
                .trailId(trail.getTrailId())
                .member(trail.getMember())
                .startLocation(trail.getStartLocation())
                .trailName(trail.getTrailName())
                .usageCount(trail.getUsageCount())
                .rating(trail.getRating())
                .createdDate(trail.getCreatedDate())
                .build();
    	
    	return trailDTO;
    }
}
