package com.tje.mapper;

import java.util.List;

import com.tje.domain.DetailCommentVO;

public interface DetailCommentMapper {

	

	public int insert(DetailCommentVO vo);
	public List<DetailCommentVO> getList(String contentid);
	public String chkPw(int cno,int commentpw);
	public Integer update(int cno, String commenttxt);
	public int delete(int cno,int commentpw);

}
