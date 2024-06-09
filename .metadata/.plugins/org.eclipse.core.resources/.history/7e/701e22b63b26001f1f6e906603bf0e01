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
@NoArgsConstructor
@AllArgsConstructor
public class Route extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "time_idx")
    private Long timeIDX;

    @Column(name = "latitude") // 위도
    private double latitude;

    @Column(name = "longitude") // 경도
    private double longitude;

    @Column(name = "altitude") // 고도
    private double altitude;

    // 작성자 - 외래키
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trail_id")
    private Trail trail;

    // 생성자를 이용하여 Trail 속성을 설정
    public Route(Long timeIDX, double latitude, double longitude, double altitude, Trail trail) {
        this.timeIDX = timeIDX;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.trail = trail;
    }

    //insert
    public static Route toSaveEntity(RouteDTO routeDTO, Trail trail) {
        return new Route(routeDTO.getTimeIDX(), routeDTO.getLatitude(), routeDTO.getLongitude(), routeDTO.getAltitude(), trail);
    }

    // update
    public static Route toUpdateEntity(RouteDTO routeDTO, Trail trail) {
        return new Route(routeDTO.getRouteId(), routeDTO.getTimeIDX(), routeDTO.getLatitude(), routeDTO.getLongitude(), routeDTO.getAltitude(), trail);
    }
}

