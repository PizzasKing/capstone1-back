package com.manbo.homepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manbo.homepage.dto.RouteDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Route extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_id")
	private String routeId;

	@Column(name = "time_idx")
	private String timeIDX;

	@Column(name = "lat") // 위도
	private double lat;

	@Column(name = "long") // 경도
	private double lng;

	@Column(name = "al") // 고도
	private double al;
	
	// 작성자 - 외래키
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "")
    private Member member;
	
}
