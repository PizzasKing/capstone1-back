package com.manbo.homepage.dto;

import com.manbo.homepage.entity.Route;
import com.manbo.homepage.entity.Trail;
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
    private Trail trail; // Trail 엔티티를 직접 참조

    public static RouteDTO toSaveDTO(Route route) {
        return RouteDTO.builder()
                .routeId(route.getRouteId())
                .timeIDX(route.getTimeIDX())
                .latitude(route.getLatitude()) // 수정
                .longitude(route.getLongitude()) // 수정
                .altitude(route.getAltitude()) // 수정
                .trail(route.getTrail())
                .build();
    }
}
