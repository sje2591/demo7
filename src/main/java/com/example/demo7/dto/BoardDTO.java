package com.example.demo7.dto;

import java.util.List;

import lombok.Data;

@Data
public class BoardDTO {
private int boardIdx;
private String title;
private List<BoardFileDTO> fileList;
}