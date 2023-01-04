package com.mysite.factory.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MarkerVO {
	private double latitude;
	private double longitude;
}
