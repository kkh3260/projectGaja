package com.tje.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.domain.DetailCommentVO;
import com.tje.mapper.DetailCommentMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class DetailCommentBoardServiceImpl implements DetailCommentBoardService{

	@Setter(onMethod_= {@Autowired})
	private DetailCommentMapper mapper;

	@Override
	public int insertcomment(DetailCommentVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public List<DetailCommentVO> getList(String contentid) {
		System.out.println("댓글리스트 go to mapper");
		return mapper.getList(contentid);
	}

	@Override
	public String commentChkpw(int cno, int commentpw) {
		System.out.println(" service 에서 pw 체크하기 commpentpw: "+cno+","+commentpw);

		return mapper.chkPw(cno, commentpw);
	}

	@Override
	public Integer commentUpdate(int cno, String commenttxt) {
		System.out.println(" service 에서 commentUpdate 체크하기 commpentpw: "+cno+","+commenttxt);
		return mapper.update(cno, commenttxt);
	}

	@Override
	public int commentDelete(int cno, int commentpw) {
		System.out.println(" service 에서 commentDelete 체크하기 commpentpw: "+cno+","+commentpw);
		return mapper.delete(cno, commentpw);
	}

	
	

}
