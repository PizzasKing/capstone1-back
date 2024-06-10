package com.manbo.homepage.entity;

import com.manbo.homepage.dto.RoomsMemberDTO;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms_member")
public class RoomsMember extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_member_id")
    private Long rmid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Rooms room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private MemberRole role;

    public static RoomsMember toSaveEntity(RoomsMemberDTO roomsMemberDTO) {
        Rooms room = new Rooms();
        room.setRoomId(roomsMemberDTO.getRoomId());

        Member member = new Member();
        member.setMemberId(roomsMemberDTO.getMemberId());

        return RoomsMember.builder()
                .room(room)
                .member(member)
                .role(MemberRole.valueOf(roomsMemberDTO.getRole()))
                .build();
    }

    public static RoomsMemberDTO toUpdateEntity(RoomsMember roomsMember) {
        return RoomsMemberDTO.builder()
                .rmid(roomsMember.getRmid())
                .roomId(roomsMember.getRoom().getRoomId())
                .memberId(roomsMember.getMember().getMemberId())
                .role(roomsMember.getRole().toString())
                .build();
    }
}
