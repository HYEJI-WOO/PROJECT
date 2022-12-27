package com.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	
	public static void main(String[] args) {
		BoardVO vo = BoardVO.builder()
				.bno(1)
				.title("제목")
				.content("내용")
				.writer("관리자").
				build();
		System.out.println(vo);
	}
}
