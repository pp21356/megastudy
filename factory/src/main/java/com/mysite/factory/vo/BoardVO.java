package com.mysite.factory.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String username;
	private String regdate;
	private String updatedate;
	private String categorie;
	private String image;
}
