package com.mysite.factory.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.mysite.factory.vo.MapVO;
import com.mysite.factory.vo.MarkerVO;

@Service
@Mapper
public interface MarkerMapper {
	public List<MarkerVO> getMarkers();
}
