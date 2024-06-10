package com.manbo.homepage.service;

import com.manbo.homepage.dto.RoomsMemberDTO;
import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.MemberRole;
import com.manbo.homepage.entity.Rooms;
import com.manbo.homepage.entity.RoomsMember;
import com.manbo.homepage.repository.RoomsMemberRepository;
import com.manbo.homepage.repository.RoomsRepository;
import com.manbo.homepage.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomsMemberService {

    private final RoomsMemberRepository roomsMemberRepository;
    private final RoomsRepository roomsRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public RoomsMemberDTO addMember(RoomsMemberDTO roomsMemberDTO) {
        Rooms room = roomsRepository.findById(roomsMemberDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        Member member = memberRepository.findById(roomsMemberDTO.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        RoomsMember roomsMember = RoomsMember.builder()
                .room(room)
                .member(member)
                .role(MemberRole.valueOf(roomsMemberDTO.getRole()))
                .build();
        RoomsMember savedRoomsMember = roomsMemberRepository.save(roomsMember);
        return RoomsMemberDTO.toSaveDTO(savedRoomsMember);
    }

    @Transactional
    public void removeMember(Long rmid) {
        roomsMemberRepository.deleteById(rmid);
    }

    @Transactional(readOnly = true)
    public List<RoomsMemberDTO> getMembersByRoomId(Long roomId) {
        List<RoomsMember> roomsMembers = roomsMemberRepository.findByRoomRoomId(roomId);
        return RoomsMemberDTO.toDTOList(roomsMembers);
    }

    @Transactional
    public RoomsMemberDTO updateMemberRole(Long rmid, String role) {
        RoomsMember roomsMember = roomsMemberRepository.findById(rmid).orElseThrow(() -> new RuntimeException("Member not found"));
        roomsMember.setRole(MemberRole.valueOf(role));
        RoomsMember updatedRoomsMember = roomsMemberRepository.save(roomsMember);
        return RoomsMemberDTO.toSaveDTO(updatedRoomsMember);
    }
}
