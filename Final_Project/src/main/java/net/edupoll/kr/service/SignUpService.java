package net.edupoll.kr.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.repository.AccountDao;

@Service
public class SignUpService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AccountDao accountDao;
	
	public boolean registerAccount(AccountVo vo) {
		
		String pass = vo.getUserPass();
		System.out.println("pass =" + pass);
		String encodePass = passwordEncoder.encode(pass);
		System.out.println("encodePass =" + encodePass);
		vo.setUserPass(encodePass);
		
		int r = accountDao.insertOne(vo);
		
//		boolean flag = pass.equals(encodePass);
//		boolean flag2 =	passwordEncoder.matches(pass, encodePass);
//			System.out.println(flag + " /" + flag2);
//			
		return r==1?true:false;
	}

}
