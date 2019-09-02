package com.tje.mapper;

import org.apache.ibatis.annotations.Param;

import com.tje.domain.AuthVO;
import com.tje.domain.MemberVO;

public interface MemberMapper {

	public MemberVO read(String userid);

	public void insert(MemberVO member);

	public void insert_Auth_ROLE_USER(@Param("userid") String userid, @Param("auth") String auth);

	public int update(MemberVO member);

	public int delete(String userid);

	public int delete_Auth(String userid);

	public int confirmId(@Param("userid") String userid);

	public int modify_Pw(@Param("userid") String userid, @Param("userpw") String userpw);

	public String checkPw(String userid);

}
