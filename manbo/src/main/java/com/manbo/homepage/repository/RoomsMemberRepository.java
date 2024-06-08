package com.manbo.homepage.repository;

import com.manbo.homepage.entity.RoomsMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomsMemberRepository extends JpaRepository<RoomsMember, Long> {
    Optional<RoomsMember> findByRoomRoomIdAndMemberMemberId(Long roomId, Long memberId);
    List<RoomsMember> findByRoomRoomId(Long roomId);
}
