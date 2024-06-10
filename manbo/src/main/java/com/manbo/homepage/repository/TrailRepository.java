package com.manbo.homepage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manbo.homepage.entity.Trail;

@Repository
public interface TrailRepository extends JpaRepository<Trail, Long> {
}
