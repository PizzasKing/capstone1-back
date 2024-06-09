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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "time_idx")
    private Long timeIDX;

    @Column(nullable = false) // 위도
    private double latitude;

    @Column(nullable = false) // 경도
    private double longitude;

    public static Route toSaveEntity(RouteDTO routeDTO) {
    	Route route = Route.builder()
    			.timeIDX(routeDTO.getTimeIDX())
    			.latitude(routeDTO.getLatitude())
    			.longitude(routeDTO.getLongitude())
    			.build();
    	return route;
    }
    public static Route toUpdateEntity(RouteDTO routeDTO) {
    	Route route = Route.builder()
    			.routeId(routeDTO.getRouteId())
    			.timeIDX(routeDTO.getTimeIDX())
    			.latitude(routeDTO.getLatitude())
    			.longitude(routeDTO.getLongitude())
    			.build();
    	return route;
    }
}

