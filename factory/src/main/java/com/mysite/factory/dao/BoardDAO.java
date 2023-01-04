package com.mysite.factory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.factory.mappers.BoardMapper;
import com.mysite.factory.vo.BoardVO;
import com.mysite.factory.vo.Criteria;

@Repository
public class BoardDAO {
		
	@Autowired
	private BoardMapper boardmapper;
	
	public List<BoardVO> getList() {
		return boardmapper.getList();
	}
	public List<BoardVO> getList(Criteria cri){
		return boardmapper.getListWithPaging(cri);
	}
	public List<BoardVO> getListwithGenre(Criteria cri){
		return boardmapper.getListWithPagingGenre(cri);
	}
	public int getTotal(Criteria cri) {
		return boardmapper.getTotal(cri);
	}
	public int getTotalGenre(Criteria cri) {
		return boardmapper.getTotalGenre(cri);
	}
	public BoardVO getBoard(Long bno) {
		return boardmapper.getBoard(bno);
	}
	
	public void insert(BoardVO board) {
		boardmapper.insert(board);
	}
}
