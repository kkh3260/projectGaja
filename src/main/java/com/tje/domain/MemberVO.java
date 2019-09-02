package com.tje.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String userid;
	private String userpw;
	private String newPw;
	private String userName;
	private boolean enabled;
	//
	private String phone;
	private String email;
	private String gender;
	private String birth;
	//
	private Date regDate;
	private Date updateDate;
	private List<AuthVO> authList;

}
