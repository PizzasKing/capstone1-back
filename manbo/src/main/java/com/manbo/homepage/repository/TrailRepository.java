package com.manbo.homepage.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manbo.homepage.entity.Trail;



@Repository
public interface TrailRepository extends JpaRepository<Trail, Long>{

	@Query("SELECT t FROM Trail t WHERE LOWER(t.trailName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(t.startLocation) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	Page<Trail> findByTrailNameContainingIgnoreCaseOrStartLocationContainingIgnoreCase(@Param("keyword") String keyword, Pageable pageable);


    
    //페이징 처리
    Page<Trail> findAll(Pageable pageable);

}

