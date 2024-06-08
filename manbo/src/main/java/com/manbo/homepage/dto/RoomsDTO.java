package com.manbo.homepage.dto;

import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.Rooms;
import com.manbo.homepage.entity.Trail;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class RoomsDTO {

    private Long roomId;
    private Member member; // 방 생성자 ID
    private Trail trailId; // 산책로 ID
    private String title;
    private String description;
    private int maxMembers;
    private LocalDateTime meetingTime;
    private String status;

    public static RoomsDTO toDTO(Rooms rooms) {
        return RoomsDTO.builder()
                .roomId(rooms.getRoomId())
                .member(rooms.getMember())
                .trailId(rooms.getTrailId())
                .title(rooms.getTitle())
                .description(rooms.getDescription())
                .maxMembers(rooms.getMaxMembers())
                .meetingTime(rooms.getMeetingTime())
                .status(rooms.getStatus())
                .build();
    }
    public static List<RoomsDTO> toDTOList(List<Rooms> rooms) {
        return rooms.stream()
                .map(RoomsDTO::toDTO)
                .collect(Collectors.toList());
    }
}
