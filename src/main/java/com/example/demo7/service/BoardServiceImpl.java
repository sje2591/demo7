package com.example.demo7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo7.dto.BoardDTO;
import com.example.demo7.dto.BoardFileDTO;
import com.example.demo7.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public void registerBoard(BoardDTO board) throws Exception {
// TODO Auto-generated method stub
		boardMapper.insertBoard(board);// ��������� boardIdx����
	}

	@Override
	public List<BoardDTO> findBoardList() {
// TODO Auto-generated method stub
		return boardMapper.selectBoardList();
	}

	@Override
	public void registerBoardFileList(List<BoardFileDTO> list) throws Exception {
// TODO Auto-generated method stub
		for (BoardFileDTO boardFile : list)
			boardMapper.insertBoardFile(boardFile);
	}

	@Override
	public BoardDTO findBoardDetail(int boardIdx) {
// TODO Auto-generated method stub
		BoardDTO board = boardMapper.selectBoardDetail(boardIdx);
		List<BoardFileDTO> boardFileList = boardMapper.selectBoardFileList(boardIdx);
		board.setFileList(boardFileList);
		return board;
	}

	@Override
	public BoardFileDTO findBoardFileDetail(int idx) {
// TODO Auto-generated method stub
		return boardMapper.selectBoardFile(idx);
	}
}
