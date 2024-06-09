package com.manbo.homepage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manbo.homepage.dto.RouteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "route")
@NoArgsConstructor
@AllArgsConstructor
public class Route extends BaseEntity {

    @Column(name = "time_idx")
    private Long timeIDX;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long routeId;
    
    @Column(name = "tid")
    private Long trailId;


    @Column(nullable = false) // 위도
    private double latitude;

    @Column(nullable = false) // 경도
    private double longitude;

    public static Route toSaveEntity(RouteDTO routeDTO) {
        return Route.builder()
                .timeIDX(routeDTO.getTimeIDX())
                .trailId(routeDTO.getTrailId())
                .latitude(routeDTO.getLatitude())
                .longitude(routeDTO.getLongitude())
                .build();
    }

    public static Route toUpdateEntity(RouteDTO routeDTO) {
        return Route.builder()
                .routeId(routeDTO.getRouteId())
                .timeIDX(routeDTO.getTimeIDX())
                .trailId(routeDTO.getTrailId())
                .latitude(routeDTO.getLatitude())
                .longitude(routeDTO.getLongitude())
                .build();
    }
}
