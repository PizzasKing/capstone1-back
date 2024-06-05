package com.manbo.homepage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manbo.homepage.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    
}
