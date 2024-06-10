package com.manbo.homepage.controller;

import com.manbo.homepage.dto.RouteDTO;
import com.manbo.homepage.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @GetMapping
    public ResponseEntity<List<RouteDTO>> getAllRoutes() {
        List<RouteDTO> routeDTOs = routeService.getAllRoutes();
        return ResponseEntity.ok(routeDTOs);
    }

    @GetMapping("/{routeId}")
    public ResponseEntity<RouteDTO> getRouteById(@PathVariable Long routeId) {
        RouteDTO routeDTO = routeService.getRouteById(routeId);
        return ResponseEntity.ok(routeDTO);
    }

    @PostMapping
    public ResponseEntity<RouteDTO> createRoute(@RequestBody RouteDTO routeDTO) {
        RouteDTO savedRouteDTO = routeService.createRoute(routeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRouteDTO);
    }

    @PutMapping("/{routeId}")
    public ResponseEntity<RouteDTO> updateRoute(@PathVariable Long routeId, @RequestBody RouteDTO routeDTO) {
        RouteDTO updatedRouteDTO = routeService.updateRoute(routeId, routeDTO);
        return ResponseEntity.ok(updatedRouteDTO);
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long routeId) {
        routeService.deleteRoute(routeId);
        return ResponseEntity.noContent().build();
    }
}
