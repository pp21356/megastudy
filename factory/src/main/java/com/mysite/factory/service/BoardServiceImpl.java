package com.mysite.factory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.factory.dao.BoardDAO;
import com.mysite.factory.vo.BoardVO;
import com.mysite.factory.vo.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO board;
	@Override
	public List<BoardVO> getList() {
		return board.getList();
	}
	@Override
	public List<BoardVO> getList(Criteria cri) {
		return board.getList(cri);
	}
	@Override
	public List<BoardVO> getListGenre(Criteria cri) {
		return board.getListwithGenre(cri);
	}
	@Override
	public int getTotal(Criteria cri) {
		return board.getTotal(cri);
	}
	@Override
	public int getTotalGenre(Criteria cri) {
		return board.getTotalGenre(cri);
	}
	@Override
	public BoardVO getBoard(Long bno) {
		return board.getBoard(bno);
	}
	@Override
	public void insert(BoardVO vo) {
		board.insert(vo);
	}

}
