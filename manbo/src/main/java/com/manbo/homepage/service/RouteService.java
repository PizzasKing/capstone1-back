package com.manbo.homepage.service;

import com.manbo.homepage.dto.RouteDTO;
import com.manbo.homepage.entity.Route;
import com.manbo.homepage.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    @Transactional(readOnly = true)
    public List<RouteDTO> getAllRoutes() {
        List<Route> routes = routeRepository.findAll();
        return routes.stream()
                .map(RouteDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<RouteDTO> addRoutes(List<RouteDTO> routeDTOs) {
        List<Route> routes = routeDTOs.stream().map(RouteDTO::toEntity).collect(Collectors.toList());
        List<Route> savedRoutes = routeRepository.saveAll(routes);
        return savedRoutes.stream().map(RouteDTO::toSaveDTO).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public RouteDTO getRouteById(Long routeId) {
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new IllegalArgumentException("Route not found with id: " + routeId));
        return RouteDTO.fromEntity(route);
    }
    @Transactional(readOnly = true)
    public RouteDTO getRouteBytId(Long routeId) {
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new IllegalArgumentException("Route not found with id: " + routeId));
        return RouteDTO.fromEntity(route);
    }

    @Transactional
    public RouteDTO createRoute(RouteDTO routeDTO) {
        Route route = Route.toSaveEntity(routeDTO);
        Route savedRoute = routeRepository.save(route);
        return RouteDTO.fromEntity(savedRoute);
    }

    @Transactional
    public RouteDTO updateRoute(Long routeId, RouteDTO routeDTO) {
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new IllegalArgumentException("Route not found with id: " + routeId));
        Route updatedRoute = Route.toUpdateEntity(routeDTO);
        Route savedRoute = routeRepository.save(updatedRoute);
        return RouteDTO.fromEntity(savedRoute);
    }

    @Transactional
    public void deleteRoute(Long routeId) {
        routeRepository.deleteById(routeId);
    }
}
