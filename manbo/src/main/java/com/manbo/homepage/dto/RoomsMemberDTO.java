package com.manbo.homepage.dto;

import com.manbo.homepage.entity.RoomsMember;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class RoomsMemberDTO {

    private Long rmid;
    private Long roomId;
    private Long memberId;
    private String role;

    public static List<RoomsMemberDTO> toDTOList(List<RoomsMember> roomsMembers) {
        return roomsMembers.stream()
                .map(RoomsMemberDTO::toSaveDTO)
                .collect(Collectors.toList());
    }

    public static RoomsMemberDTO toSaveDTO(RoomsMember roomsMember) {
        return RoomsMemberDTO.builder()
                .rmid(roomsMember.getRmid())
                .roomId(roomsMember.getRoom().getRoomId())
                .memberId(roomsMember.getMember().getMemberId())
                .role(roomsMember.getRole().toString())
                .build();
    }

    public static RoomsMemberDTO toEntity(RoomsMember roomsMember) {
        return RoomsMemberDTO.builder()
                .rmid(roomsMember.getRmid())
                .roomId(roomsMember.getRoom().getRoomId())
                .memberId(roomsMember.getMember().getMemberId())
                .role(roomsMember.getRole().toString())
                .build();
    }
}
