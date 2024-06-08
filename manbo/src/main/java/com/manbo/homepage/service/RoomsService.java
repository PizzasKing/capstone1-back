package com.manbo.homepage.service;

import com.manbo.homepage.dto.RoomsDTO;
import com.manbo.homepage.dto.RoomsMemberDTO;
import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.Rooms;
import com.manbo.homepage.entity.RoomsMember;
import com.manbo.homepage.entity.MemberRole;
import com.manbo.homepage.repository.MemberRepository;
import com.manbo.homepage.repository.RoomsMemberRepository;
import com.manbo.homepage.repository.RoomsRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomsService {

    private final RoomsRepository roomsRepository;
    private final MemberRepository memberRepository;
    private final RoomsMemberRepository roomsMemberRepository;

    public RoomsDTO createRoom(RoomsDTO roomsDTO) {
        Member member = memberRepository.findById(roomsDTO.getMember().getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        Rooms room = Rooms.toSaveEntity(roomsDTO);
        room.setMember(member);
        room = roomsRepository.save(room);

        return RoomsDTO.toDTO(room);
    }

    public RoomsDTO updateRoomState(Long roomId, String status) {
        Rooms room = roomsRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        room.setStatus(status);
        room = roomsRepository.save(room);
        return RoomsDTO.toDTO(room);
    }

    public RoomsDTO getRoomById(Long roomId) {
        Rooms room = roomsRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        return RoomsDTO.toDTO(room);
    }

    public List<RoomsDTO> getAllRooms() {
        List<Rooms> rooms = roomsRepository.findAll();
        return RoomsDTO.toDTOList(rooms);
    }

    public void removeRoom(Long roomId) {
        Rooms room = roomsRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        roomsRepository.delete(room);
    }

    public RoomsMemberDTO addRoomMember(Long roomId, RoomsMemberDTO roomsMemberDTO) {
        Rooms room = roomsRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        Member member = memberRepository.findById(roomsMemberDTO.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        RoomsMember roomsMember = RoomsMember.builder()
                .room(room)
                .member(member)
                .role(MemberRole.valueOf(roomsMemberDTO.getRole())) // String 값을 MemberRole로 변환
                .build();

        roomsMember = roomsMemberRepository.save(roomsMember);

        return RoomsMemberDTO.toDTO(roomsMember);
    }

    public void removeRoomMember(Long roomId, Long memberId) {
        RoomsMember roomsMember = roomsMemberRepository.findByRoomRoomIdAndMemberMemberId(roomId, memberId)
                .orElseThrow(() -> new IllegalArgumentException("Room Member not found"));
        roomsMemberRepository.delete(roomsMember);
    }

    public List<RoomsMemberDTO> getRoomMembers(Long roomId) {
        List<RoomsMember> roomsMembers = roomsMemberRepository.findByRoomRoomId(roomId);
        return RoomsMemberDTO.toDTOList(roomsMembers);
    }

    public RoomsMemberDTO updateMemberRole(Long roomId, Long memberId, String role) {
        RoomsMember roomsMember = roomsMemberRepository.findByRoomRoomIdAndMemberMemberId(roomId, memberId)
                .orElseThrow(() -> new IllegalArgumentException("Room Member not found"));
        roomsMember.setRole(MemberRole.valueOf(role)); // String 값을 MemberRole로 변환
        roomsMember = roomsMemberRepository.save(roomsMember);
        return RoomsMemberDTO.toDTO(roomsMember);
    }
}
