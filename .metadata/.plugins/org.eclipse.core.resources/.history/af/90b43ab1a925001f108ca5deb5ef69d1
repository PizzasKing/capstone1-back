package com.manbo.homepage.controller;

import com.manbo.homepage.dto.RoomsDTO;
import com.manbo.homepage.service.RoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomsController {

    private final RoomsService roomsService;

    @PostMapping
    public ResponseEntity<String> createRoom(@RequestBody RoomsDTO roomsDTO) {
        roomsService.save(roomsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Room created successfully");
    }

    @GetMapping
    public ResponseEntity<List<RoomsDTO>> getAllRooms() {
        List<RoomsDTO> rooms = roomsService.findAll();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomsDTO> getRoomById(@PathVariable Long id) {
        RoomsDTO room = roomsService.findById(id);
        return room != null ? ResponseEntity.ok(room) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id) {
        roomsService.deleteById(id);
        return ResponseEntity.ok("Room deleted successfully");
    }
}
