package com.manbo.homepage.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manbo.homepage.dto.FreeBoardDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "free_board")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoard extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fbid; // 자유게시판 번호

	@Column(nullable = false)
	private String fbtitle; // 자유게시판 제목

	@Column(length = 2000, nullable = false)
	private String fbcontent; // 자유게시판 내용

	@Column(nullable = true)
	private Integer fbhit; // 조회수

	@Column
	private String freeFilename;

	@Column
	private String freeFilepath;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="mid")
	private Member member;

	@OneToMany(mappedBy = "freeboard", cascade = CascadeType.ALL)
	@OrderBy("frid desc")
	@JsonIgnore
	private List<FreeReply> freeReplyList;

	public static FreeBoard toSaveEntity(FreeBoardDTO freeBoardDTO) {
		return FreeBoard.builder()
				.fbtitle(freeBoardDTO.getFbtitle())
				.fbcontent(freeBoardDTO.getFbcontent())
				.fbhit(0)
				.freeFilename(freeBoardDTO.getFreeFilename())
				.freeFilepath(freeBoardDTO.getFreeFilepath())
				.member(freeBoardDTO.getMember())
				.build();
	}

	public static FreeBoard toUpdateEntity(FreeBoardDTO freeBoardDTO) {
		return FreeBoard.builder()
				.fbid(freeBoardDTO.getFbid())
				.fbtitle(freeBoardDTO.getFbtitle())
				.fbcontent(freeBoardDTO.getFbcontent())
				.fbhit(freeBoardDTO.getFbhit())
				.freeFilename(freeBoardDTO.getFreeFilename())
				.freeFilepath(freeBoardDTO.getFreeFilepath())
				.member(freeBoardDTO.getMember())
				.build();
	}
}
