package com.manbo.homepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manbo.homepage.dto.RoomsDTO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rooms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    @Column(name = "room_id")
    private Long roomId;

    @Column(nullable = false)
    private String roomTitle;

    @Column(length = 2000, nullable = false)
    private String roomContent;

    @Column(name = "max_members", nullable = false)
    private Integer maxMembers;

    @Column(name = "meeting_time", nullable = false)
    private LocalDateTime meetingTime;

    @Column(nullable = false)
    private String status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mid")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trail_id")
    private Trail trail;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomsMember> roomsMembers;

    public static Rooms toSaveEntity(RoomsDTO roomsDTO) {
        return Rooms.builder()
                .member(roomsDTO.getMember())
                .trail(roomsDTO.getTrail())
                .roomTitle(roomsDTO.getRoomTitle())
                .roomContent(roomsDTO.getRoomContent())
                .maxMembers(roomsDTO.getMaxMembers())
                .meetingTime(roomsDTO.getMeetingTime())
                .status(roomsDTO.getStatus())
                .build();
    }

    public static Rooms toUpdateEntity(RoomsDTO roomsDTO) {
        return Rooms.builder()
                .roomId(roomsDTO.getRoomId())
                .member(roomsDTO.getMember())
                .trail(roomsDTO.getTrail())
                .roomTitle(roomsDTO.getRoomTitle())
                .roomContent(roomsDTO.getRoomContent())
                .maxMembers(roomsDTO.getMaxMembers())
                .meetingTime(roomsDTO.getMeetingTime())
                .status(roomsDTO.getStatus())
                .build();
    }
}
