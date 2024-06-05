package com.manbo.homepage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.manbo.homepage.entity.RoomsMember;

@Repository
public interface RoomsMemberRepository extends JpaRepository<RoomsMember, Long> {
}
