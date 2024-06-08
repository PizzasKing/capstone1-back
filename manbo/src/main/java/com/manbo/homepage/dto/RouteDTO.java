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
    private double latitude;
    private double longitude;
    private double altitude;
    private Long trailId; // Trail 엔티티의 ID를 직접 참조

    public static RouteDTO toSaveDTO(Route route) {
        return RouteDTO.builder()
                .routeId(route.getRouteId())
                .timeIDX(route.getTimeIDX())
                .latitude(route.getLatitude())
                .longitude(route.getLongitude())
                .altitude(route.getAltitude())
                .trailId(route.getTrail().getTrailId())
                .build();
    }
}
