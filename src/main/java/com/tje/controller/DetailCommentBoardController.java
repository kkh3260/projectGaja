package com.tje.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tje.domain.DetailCommentVO;
import com.tje.service.DetailCommentBoardService;

import lombok.Setter;

@Controller
public class DetailCommentBoardController {

	@Setter(onMethod_ = { @Autowired })
	private DetailCommentBoardService service;

	// 후기 insert and getList
	@ResponseBody
	@RequestMapping(value = "/commentInsert/{contentid}", method = RequestMethod.POST)
	public List<DetailCommentVO> insertComment(@PathVariable String contentid, HttpServletRequest request) {
		DetailCommentVO vo = new DetailCommentVO();

		// ajax 꺼내오기
		System.out.println("@@@commentInsert : " + contentid);
		System.out.println(request.getParameter("commenttxt"));
		System.out.println(request.getParameter("commentname"));
		System.out.println(request.getParameter("commentpw"));

		String commenttxt = request.getParameter("commenttxt");
		String commentname = request.getParameter("commentname");
		int commentpw = (Integer.parseInt(request.getParameter("commentpw")));

		// vo에 담기
		vo.setContentid(contentid);
		vo.setCommentname(commentname);
		vo.setCommentpw(commentpw);
		vo.setCommenttxt(commenttxt);

		List commentVO = null;
		// 후기 insert
		int num = this.service.insertcomment(vo);
		// 후기 리스트 가져오기
		if (num == 1) {
			commentVO = service.getList(contentid);
		}

		return commentVO;
	}

	// 수정 또는 삭제하기위해서 비밀번호 확인
	@ResponseBody
	@RequestMapping(value = "/commentChkpw/{cno}", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public String commentChkpw(@PathVariable int cno, @Param("commentpw") int commentpw,
			@Param("checkfor") int checkfor) {
		String result;
		try {
			System.out.println("@@@chkPw controller pw : " + commentpw);
			System.out.println("@@@chkPw controller cno : " + cno);
			System.out.println("@@@chkPw controller checkfor : " + checkfor);
			// 수정용 체크
			System.out.println("체크값modify"+(checkfor == 1));
			System.out.println();
			System.out.println("체크값dele"+(checkfor == 2));
			if (checkfor == 1) {
				result = this.service.commentChkpw(cno, commentpw);
				System.out.println(" 수정하기위한 비밀번호 확인결과 :" + result);
				// 비밀번호가 맞을떄 commenttxt 반환
				if (result != null) {

					return "OK";
				}
			} // 삭제용 체크
			else if (checkfor == 2) {
				result = this.service.commentChkpw(cno, commentpw);
				System.out.println(" 삭제하기위한 비밀번호 확인결과 :" + result);
				// 비밀번호가 맞을떄 ok 반환 및 글삭제
				if (result != null) {
					int dele = this.service.commentDelete(cno, commentpw);
					if (dele == 1) {
						System.out.println("contorller 단 삭제결과 :" + dele);
						return "OK";
					}
				}

			}

		} catch (NumberFormatException e) {
			System.out.println("숫자 입력 : " + e);
			return "숫자입력하세요";
		}

		return "NO";
	}

	@ResponseBody
	@RequestMapping(value = "/commentUpdate/{cno}", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public String commentUpdate(@PathVariable int cno, @Param("commenttxt") String commenttxt) {
		System.out.println("@@@commentUpdate controller commenttxt : " + commenttxt);
		System.out.println("@@@commentUpdate controller cno : " + cno);

		try {
			int result;
			result = this.service.commentUpdate(cno, commenttxt);
			System.out.println("result  값 :" + this.service.commentUpdate(cno, commenttxt));

			System.out.println("result : " + result);
			if (result == 1) {

				return "OK";
			}
		} catch (NullPointerException e) {
			System.out.println("commentUpdate 예외" + e);
		}

		return "Failed";
	}

}
