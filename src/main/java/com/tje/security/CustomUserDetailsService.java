package com.tje.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.tje.domain.MemberVO;
import com.tje.mapper.MemberMapper;
import com.tje.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_ = { @Autowired })
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.warn("Load user by UserName : " + userName);
		// return null;

		// userName means userid
		MemberVO vo = memberMapper.read(userName);

		log.warn("queried by member mapper : " + vo);
		return vo == null ? null : new CustomUser(vo);
	}
}
