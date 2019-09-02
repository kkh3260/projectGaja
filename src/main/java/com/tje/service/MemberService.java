package com.tje.service;

import com.tje.domain.AuthVO;
import com.tje.domain.MemberVO;

public interface MemberService {

	// 회원가입
	public void register(MemberVO member);

	public void register_auth(String userid, String auth);

	// 회원정보 조회
	public MemberVO get(String userid);

	// 회원정보 수정
	public boolean modify(MemberVO member);

	// 비밀번호 수정

	public boolean modifyPw(String userid, String userpw);

	public boolean checkPw(String userid, String userpw);

	// 회원탈퇴
	public boolean remove(String userid);

	public boolean remove_auth(String userid);

	// 아이디 중복 검사
	public int checkId(String userid);

}
