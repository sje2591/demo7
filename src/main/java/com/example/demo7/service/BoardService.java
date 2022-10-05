package com.example.demo7.service;

import java.util.List;
import com.example.demo7.dto.BoardDTO;
import com.example.demo7.dto.BoardFileDTO;

public interface BoardService {
List<BoardDTO> findBoardList();
void registerBoard( BoardDTO dto ) throws Exception ;
void registerBoardFileList(List<BoardFileDTO> list) throws Exception ;
BoardDTO findBoardDetail(int boardIdx);
BoardFileDTO findBoardFileDetail(int idx);
}