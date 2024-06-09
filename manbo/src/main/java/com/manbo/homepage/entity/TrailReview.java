package com.manbo.homepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manbo.homepage.dto.TrailReviewDTO;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "trail_review")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TrailReview extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "review_rank", nullable = false)
    private Integer reviewRank;

    @Column(name = "review_content", nullable = false)
    private String reviewContent;
    
    @JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="trail_id")
	private Trail trail;

    @JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="member_id")
	private Member member;
    
    @Column(nullable = false)
    private double rating; // 평점
    
    // insert
    public static TrailReview toSaveEntity(TrailReviewDTO reviewDTO) {
    	return TrailReview.builder()
    			.reviewRank(reviewDTO.getReviewRank())
    			.reviewContent(reviewDTO.getReviewContent())
    			.trail(reviewDTO.getTrail())
    			.member(reviewDTO.getMember())
    			.rating(reviewDTO.getRating())
    			.build();
    }

    // update
    public static TrailReview toUpdateEntity(TrailReviewDTO reviewDTO) {
    	return TrailReview.builder()
    			.reviewId(reviewDTO.getReviewId())
    			.reviewRank(reviewDTO.getReviewRank())
    			.reviewContent(reviewDTO.getReviewContent())
    			.trail(reviewDTO.getTrail())
    			.member(reviewDTO.getMember())
    			.build();
    }
}
