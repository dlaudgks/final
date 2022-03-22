package net.edupoll.kr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.repository.AccountDao;

@Service
public class PersonalService {
	
	@Autowired
	AccountDao accountDao;

	public boolean modifyAccount(AccountVo vo) {
		// TODO Auto-generated method stub
		
		int r = accountDao.updateOne(vo);
		if(r==1)
			return true;
		else
			return false;
		
	}
	
	public boolean profileAccount(AccountVo vo) {
		
		int r = accountDao.updateOne(vo);
		return r==1;
	}
	
	
}
