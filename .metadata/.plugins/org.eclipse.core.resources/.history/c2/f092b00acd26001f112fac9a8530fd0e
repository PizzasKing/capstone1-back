package com.manbo.homepage.controller;

import com.manbo.homepage.dto.RoomsDTO;
import com.manbo.homepage.dto.RoomsMemberDTO;
import com.manbo.homepage.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    private final RoomsService roomsService;

    @Autowired
    public RoomsController(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @PostMapping("/create")
    public RoomsDTO createRoom(@RequestBody RoomsDTO roomsDTO) {
        return roomsService.createRoom(roomsDTO);
    }

    @PutMapping("/update/{roomId}")
    public RoomsDTO updateRoomState(@PathVariable Long roomId, @RequestParam String status) {
        return roomsService.updateRoomState(roomId, status);
    }

    @GetMapping("/{roomId}")
    public RoomsDTO getRoomById(@PathVariable Long roomId) {
        return roomsService.getRoomById(roomId);
    }

    @GetMapping("/all")
    public List<RoomsDTO> getAllRooms() {
        return roomsService.getAllRooms();
    }

    @DeleteMapping("/remove/{roomId}")
    public void removeRoom(@PathVariable Long roomId) {
        roomsService.removeRoom(roomId);
    }

    @PostMapping("/{roomId}/add-member")
    public RoomsMemberDTO addRoomMember(@PathVariable Long roomId, @RequestBody RoomsMemberDTO roomsMemberDTO) {
        return roomsService.addRoomMember(roomId, roomsMemberDTO);
    }

    @DeleteMapping("/{roomId}/remove-member/{memberId}")
    public void removeRoomMember(@PathVariable Long roomId, @PathVariable Long memberId) {
        roomsService.removeRoomMember(roomId, memberId);
    }

    @GetMapping("/{roomId}/members")
    public List<RoomsMemberDTO> getRoomMembers(@PathVariable Long roomId) {
        return roomsService.getRoomMembers(roomId);
    }

    @PutMapping("/{roomId}/update-member-role/{memberId}")
    public RoomsMemberDTO updateMemberRole(@PathVariable Long roomId, @PathVariable Long memberId, @RequestParam String role) {
        return roomsService.updateMemberRole(roomId, memberId, role);
    }
}
