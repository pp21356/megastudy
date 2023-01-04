package com.mysite.factory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.factory.vo.BoardVO;
import com.mysite.factory.vo.Criteria;

@Service
public interface BoardService {
	public List<BoardVO> getList();
	public List<BoardVO> getList(Criteria cri);
	public List<BoardVO> getListGenre(Criteria cri);
	public int getTotal(Criteria cri);
	public int getTotalGenre(Criteria cri);
	public BoardVO getBoard(Long bno);
	public void insert(BoardVO board);
}
