package com.example.demo7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo7.common.FileUtils;
import com.example.demo7.dto.BoardDTO;
import com.example.demo7.dto.BoardFileDTO;
import com.example.demo7.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {

@Autowired
private BoardService boardService;
@Autowired
private FileUtils fileUtils;

@RequestMapping("/board-form")
public ModelAndView main() {
log.info("========================== BoardController(/board-form) ==================================");
ModelAndView mv=new ModelAndView("/boardForm");
return mv;
}
@RequestMapping("/board")
public ModelAndView registerBoard(
BoardDTO board,
MultipartHttpServletRequest multipartHttpServletRequest
) throws Exception {
log.info("========================== BoardController(/board) ==================================");
boardService.registerBoard(board);
List<BoardFileDTO> list=fileUtils.parseFileInfo(
board.getBoardIdx(), multipartHttpServletRequest
);
if(!CollectionUtils.isEmpty(list)) boardService.registerBoardFileList(list);
return new ModelAndView("redirect:/board-list");
}

@RequestMapping("/board-list")
public ModelAndView findBoardList() throws Exception {
log.info("========================== BoardController(/board-list) ==================================");
List<BoardDTO> list=boardService.findBoardList();
ModelAndView mv=new ModelAndView("/boardList");
mv.addObject("list", list);
return mv;
}
}