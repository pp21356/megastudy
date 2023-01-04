package com.mysite.factory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.factory.vo.MapVO;
import com.mysite.factory.vo.MarkerVO;

@Service
public interface MarkerService {
	public List<MarkerVO> getMarkers();
}
