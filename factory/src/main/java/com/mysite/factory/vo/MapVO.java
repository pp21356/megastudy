package com.mysite.factory.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MapVO {
	private String lib_name;
	private String sido_name;
	private String sigoon_name;
	private String lib_type;
	private String road_name;
	private String center_name;
	private String lib_num;
	private String page;
	private int latitude;
	private int longitude;
}
