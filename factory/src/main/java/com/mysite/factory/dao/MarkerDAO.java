package com.mysite.factory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.factory.mappers.MarkerMapper;
import com.mysite.factory.vo.MapVO;
import com.mysite.factory.vo.MarkerVO;

@Repository
public class MarkerDAO {
	
	@Autowired
	private MarkerMapper markermapper;
	
	public List<MarkerVO> getMarkers(){
		return markermapper.getMarkers();
	}
}
