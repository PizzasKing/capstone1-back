package com.manbo.homepage.dto;

import com.manbo.homepage.entity.RoomsMember;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class RoomsMemberDTO {

    private Long roomMemberId;
    private Long roomId;
    private Long memberId;
    private String role;

    public static List<RoomsMemberDTO> toDTOList(List<RoomsMember> roomsMembers) {
        return roomsMembers.stream()
                .map(RoomsMemberDTO::toDTO)
                .collect(Collectors.toList());
    }

    public static RoomsMemberDTO toDTO(RoomsMember roomsMember) {
        return RoomsMemberDTO.builder()
                .roomMemberId(roomsMember.getRoomMemberId())
                .roomId(roomsMember.getRoom().getRoomId())
                .memberId(roomsMember.getMember().getMemberId())
                .role(roomsMember.getRole().toString())
                .build();
    }
}
