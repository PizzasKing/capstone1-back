package com.manbo.homepage.dto;

import java.sql.Timestamp;

import com.manbo.homepage.entity.Member;
import com.manbo.homepage.entity.Review;
import com.manbo.homepage.entity.Trail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
	
	private Long reviewId;
	private Member member;
	private Integer reviewRank;
	private String reviewContent;
	private Trail trail;
	private Timestamp createdDate;
	
	public static ReviewDTO toSaveDTO(Review review) {
		ReviewDTO reviewDTO = ReviewDTO.builder()
				.reviewId(review.getReviewId())
				.member(review.getMember())
				.reviewRank(review.getReviewRank())
				.reviewContent(review.getReviewContent())
				.trail(review.getTrail())
				.createdDate(review.getCreatedDate())
				.build();
		return reviewDTO;
	}
}
