package com.manbo.homepage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.Route;
import com.manbo.homepage.entity.Route;
import com.manbo.homepage.entity.Trail;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrailDTO {

    private Long trailId; // 산책로 ID
    private Member member;
    private Route routeID;
    private Route routeID;
    private String startLocation; // 시작 위치
    private String trailName; // 산책로 이름
    private int usageCount; // 산책로 이용 횟수
    private double rating; // 산책로 평점
    private double distance; //거리
    private boolean regstate; // 등록상태
    private boolean isReviewed; // 리뷰 여부
    private Integer refId; //참조id
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Timestamp endDate;
    private Timestamp updatedDate;
    private Timestamp endDate;
    private String trailRoutePath; // 산책로 경로 파일 경로
    
    
    public static TrailDTO toSaveDTO(Trail trail) {
        TrailDTO trailDTO = TrailDTO.builder()
                .trailId(trail.getTrailId())
                .member(trail.getMember())
                .startLocation(trail.getStartLocation())
                .trailName(trail.getTrailName())
                .usageCount(trail.getUsageCount())
                .rating(trail.getRating())
                .distance(trail.getDistance())
                .regstate(trail.isRegstate())
                .refId(trail.getRefId())
                .isReviewed(trail.isReviewed())
                .createdDate(trail.getCreatedDate())
                .updatedDate(trail.getUpdatedDate())
                .endDate(trail.getEndDate())
                .routeID(trail.getRouteId())
                .build();
        
        return trailDTO;
    }
    public static TrailDTO toEntity(Trail trail) {
    	TrailDTO trailDTO = TrailDTO.builder()
    			.trailId(trail.getTrailId())
    			.member(trail.getMember())
    			.startLocation(trail.getStartLocation())
    			.trailName(trail.getTrailName())
    			.usageCount(trail.getUsageCount())
                .isReviewed(trail.isReviewed())
    			.distance(trail.getDistance())
                .regstate(trail.isRegstate())
                .refId(trail.getRefId())
    			.rating(trail.getRating())
    			.routeID(trail.getRouteId())
    			.build();
    	
    	return trailDTO;
    }
}
