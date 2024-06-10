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
    private Member member;
    private Trail trail;
    private String roomTitle;
    private String roomContent;
    private Integer maxMembers;
    private LocalDateTime meetingTime;
    private String status;

    public static RoomsDTO toSaveDTO(Rooms rooms) {
        return RoomsDTO.builder()
                .roomId(rooms.getRoomId())
                .member(rooms.getMember())
                .trail(rooms.getTrail())
                .roomTitle(rooms.getRoomTitle())
                .roomContent(rooms.getRoomContent())
                .maxMembers(rooms.getMaxMembers())
                .meetingTime(rooms.getMeetingTime())
                .status(rooms.getStatus())
                .build();
    }

    public static RoomsDTO toEntity(Rooms rooms) {
        return RoomsDTO.builder()
                .roomId(rooms.getRoomId())
                .member(rooms.getMember())
                .trail(rooms.getTrail())
                .roomTitle(rooms.getRoomTitle())
                .roomContent(rooms.getRoomContent())
                .maxMembers(rooms.getMaxMembers())
                .meetingTime(rooms.getMeetingTime())
                .status(rooms.getStatus())
                .build();
    }

    public static List<RoomsDTO> toDTOList(List<Rooms> rooms) {
        return rooms.stream()
                .map(RoomsDTO::toSaveDTO)
                .collect(Collectors.toList());
    }
}
