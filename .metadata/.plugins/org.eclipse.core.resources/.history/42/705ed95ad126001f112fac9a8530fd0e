package com.manbo.homepage.entity;

import java.sql.Timestamp;
import java.util.List;

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
public class Trail extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trail_id")
	private Long trailId; // 산책로 ID
	
	@Column(nullable = false)
	private String startLocation; // 시작 위치

	@Column(nullable = false)
	private String trailName; // 산책로 이름

	@Column(nullable = true)
	private Integer usageCount; // 산책로 이용 횟수

	@Column(nullable = true)
	private double rating; // 산책로 평점

	@Column(nullable = false)
	private double distance; // 거리
	
	@Column(nullable = true)
	private boolean regstate; // 등록 상태
	
	@Column(nullable = true)
    private Timestamp endDate; // 산책 끝난 시간
	
	@Column(nullable = true)
	private Integer refId; // 참조한 산책로

	// 작성자 - 외래키
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "mid")
	private Member member;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "route_id")
	private Route routeId;
	

	// insert
	public static Trail toSaveEntity(TrailDTO trailDTO) {
		Trail trail = Trail.builder()
				.startLocation(trailDTO.getStartLocation())
				.trailName(trailDTO.getTrailName())
				.usageCount(trailDTO.getUsageCount())
				.rating(trailDTO.getRating())
				.distance(trailDTO.getDistance())
				.regstate(trailDTO.isRegstate())
				.refId(trailDTO.getRefId())
				.endDate(trailDTO.getEndDate())
				.member(trailDTO.getMember())
				.routeId(trailDTO.getRouteID())
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
				.distance(trailDTO.getDistance())
				.regstate(trailDTO.isRegstate())
				.refId(trailDTO.getRefId())
				.endDate(trailDTO.getEndDate())
				.member(trailDTO.getMember())
				.build();
		return trail;
	}
}
