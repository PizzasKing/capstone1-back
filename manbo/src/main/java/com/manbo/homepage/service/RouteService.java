package com.manbo.homepage.service;

import com.manbo.homepage.dto.RouteDTO;
import com.manbo.homepage.entity.Route;
import com.manbo.homepage.entity.Trail;
import com.manbo.homepage.repository.RouteRepository;
import com.manbo.homepage.repository.TrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private TrailRepository trailRepository;

    public Route saveRoute(RouteDTO routeDTO) {
        Trail trail = trailRepository.findById(routeDTO.getTrailId())
                .orElseThrow(() -> new RuntimeException("Trail not found"));
        Route route = Route.toSaveEntity(routeDTO, trail);
        return routeRepository.save(route);
    }

    public Route updateRoute(RouteDTO routeDTO) {
        Trail trail = trailRepository.findById(routeDTO.getTrailId())
                .orElseThrow(() -> new RuntimeException("Trail not found"));
        Route route = Route.toUpdateEntity(routeDTO, trail);
        return routeRepository.save(route);
    }
}
