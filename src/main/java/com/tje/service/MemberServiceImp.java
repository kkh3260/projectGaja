package com.tje.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tje.domain.MemberVO;
import com.tje.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImp implements MemberService {

	private MemberMapper mapper;
	private PasswordEncoder pwencoder;

	@Override
	public void register(MemberVO member) {
		log.info("register .." + member);
		log.info(member.getUserpw());
		String encode_pw = pwencoder.encode(member.getUserpw());
		member.setUserpw(encode_pw);
		log.info(member.getUserpw());
		mapper.insert(member);
	}

	@Override
	public void register_auth(String userid, String auth) {
		log.info("register_auth......");
		mapper.insert_Auth_ROLE_USER(userid, auth);
	}

	@Override
	public MemberVO get(String userid) {
		log.info("get...." + userid);
		return mapper.read(userid);
	}

	@Override
	public boolean modify(MemberVO member) {
		log.info("modify...." + member);
		return mapper.update(member) == 1;
	}

	@Override
	public boolean remove(String userid) {
		log.info("remove...." + userid);
		return mapper.delete(userid) == 1;
	}

	@Override
	public boolean remove_auth(String userid) {
		log.info("remove....auth..." + userid);
		return mapper.delete_Auth(userid) == 1;
	}

	@Override
	public boolean modifyPw(String userid, String userpw) {
		log.info("service -> modifyPw....");
		String encode_pw = pwencoder.encode(userpw);
		return mapper.modify_Pw(userid, encode_pw) == 1;
	}

	@Override
	public boolean checkPw(String userid, String userpw) {
		log.info("service -> modifyPw....");
		String encodedPw = mapper.checkPw(userid);

		return pwencoder.matches(userpw, encodedPw);
	}

	@Override
	public int checkId(String userid) {
		log.info("service -> chechId....");
		System.out.println("서비스" + userid);
		return mapper.confirmId(userid);
	}
}
