package com.manbo.homepage.dto;

import java.sql.Timestamp;

import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.Trail;
import com.manbo.homepage.entity.TrailReview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrailReviewDTO {
	
	private Long reviewId;
	private Member member;
	private Integer reviewRank;
	private String reviewContent;
	private Trail trail;
	private Timestamp createdDate;
	private double rating;
	
	public static TrailReviewDTO toSaveDTO(TrailReview review) {
		return TrailReviewDTO.builder()
				.reviewId(review.getReviewId())
				.member(review.getMember())
				.reviewRank(review.getReviewRank())
				.reviewContent(review.getReviewContent())
				.trail(review.getTrail())
				.createdDate(review.getCreatedDate())
				.rating(review.getRating())
				.build();
	}
}
