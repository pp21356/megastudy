package com.mysite.factory.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.factory.vo.BoardVO;
import com.mysite.factory.vo.Criteria;

@Service
@Mapper
public interface BoardMapper {
	
	public List<BoardVO> getList();
	public List<BoardVO> getListWithPaging(Criteria cri);
	public List<BoardVO> getListWithPagingGenre(Criteria cri);
	public int getTotal(Criteria cri);
	public BoardVO getBoard(Long bno);
	public void insert(BoardVO board);
	public int getTotalGenre(Criteria cri);
}
