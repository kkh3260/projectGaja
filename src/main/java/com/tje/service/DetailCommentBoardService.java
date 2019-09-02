package com.tje.service;

import java.util.List;

import com.tje.domain.DetailCommentVO;

public interface DetailCommentBoardService {

	public int insertcomment(DetailCommentVO vo);
	public List<DetailCommentVO> getList(String contentid);
	public String commentChkpw (int cno,int commentpw);
	public Integer commentUpdate(int cno, String commenttxt);
	public int commentDelete(int cno,int commentpw);
}
