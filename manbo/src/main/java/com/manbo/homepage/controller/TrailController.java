package com.manbo.homepage.controller;

import com.manbo.homepage.dto.TrailDTO;
import com.manbo.homepage.service.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trails")
public class TrailController {

    @Autowired
    private TrailService trailService;

    @GetMapping("/{trailId}")
    public ResponseEntity<TrailDTO> getTrailById(@PathVariable Long trailId) {
        return ResponseEntity.ok(trailService.getTrailById(trailId));
    }

    @GetMapping
    public ResponseEntity<List<TrailDTO>> getAllTrails() {
        return ResponseEntity.ok(trailService.getAllTrails());
    }

    @PostMapping
    public ResponseEntity<TrailDTO> addTrail(@RequestBody TrailDTO trailDTO) {
        return ResponseEntity.ok(trailService.addTrail(trailDTO));
    }

    @DeleteMapping("/{trailId}")
    public ResponseEntity<Void> removeTrail(@PathVariable Long trailId) {
        trailService.removeTrail(trailId);
        return ResponseEntity.ok().build();
    }
}
