package com.manbo.homepage.dto;

import com.manbo.homepage.entity.Route;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO {

    private Long routeId;
    private Long timeIDX;
    private Long trailId;
    private double latitude;
    private double longitude;

    public static RouteDTO toSaveDTO(Route route) {
        return RouteDTO.builder()
                .routeId(route.getRouteId())
                .timeIDX(route.getTimeIDX())
                .trailId(route.getTrailId())
                .latitude(route.getLatitude())
                .longitude(route.getLongitude())
                .build();
    }
    public static RouteDTO fromEntity(Route route) {
    	return RouteDTO.builder()
    			.routeId(route.getRouteId())
    			.timeIDX(route.getTimeIDX())
                .trailId(route.getTrailId())
    			.latitude(route.getLatitude())
    			.longitude(route.getLongitude())
    			.build();
    }
    // DTO -> Entity
    public static Route toEntity(RouteDTO routeDTO) {
        return Route.builder()
                .routeId(routeDTO.getRouteId())
                .timeIDX(routeDTO.getTimeIDX())
                .trailId(routeDTO.getTrailId())
                .latitude(routeDTO.getLatitude())
                .longitude(routeDTO.getLongitude())
                .build();
    }
}
