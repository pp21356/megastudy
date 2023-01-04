package com.mysite.factory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.factory.dao.MarkerDAO;
import com.mysite.factory.vo.MapVO;
import com.mysite.factory.vo.MarkerVO;

@Service
public class MarkerServiceImpl implements MarkerService {

	@Autowired
	private MarkerDAO markerdao;
	@Override
	public List<MarkerVO> getMarkers() {
		return markerdao.getMarkers();
	}
	
}
