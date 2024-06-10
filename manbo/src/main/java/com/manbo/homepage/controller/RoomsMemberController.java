package com.manbo.homepage.controller;

import com.manbo.homepage.dto.RoomsMemberDTO;
import com.manbo.homepage.service.RoomsMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms-members")
@RequiredArgsConstructor
public class RoomsMemberController {

    private final RoomsMemberService roomsMemberService;

    @PostMapping("/add")
    public ResponseEntity<RoomsMemberDTO> addMember(@RequestBody RoomsMemberDTO roomsMemberDTO) {
        RoomsMemberDTO addedMember = roomsMemberService.addMember(roomsMemberDTO);
        return ResponseEntity.ok(addedMember);
    }

    @DeleteMapping("/remove/{rmid}")
    public ResponseEntity<Void> removeMember(@PathVariable Long rmid) {
        roomsMemberService.removeMember(rmid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<RoomsMemberDTO>> getMembersByRoomId(@PathVariable Long roomId) {
        List<RoomsMemberDTO> members = roomsMemberService.getMembersByRoomId(roomId);
        return ResponseEntity.ok(members);
    }

    @PutMapping("/update-role/{rmid}")
    public ResponseEntity<RoomsMemberDTO> updateMemberRole(@PathVariable Long rmid, @RequestBody String role) {
        RoomsMemberDTO updatedMember = roomsMemberService.updateMemberRole(rmid, role);
        return ResponseEntity.ok(updatedMember);
    }
}
