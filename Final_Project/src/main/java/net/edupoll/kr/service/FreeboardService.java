package net.edupoll.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.FreeBoardVo;
import net.edupoll.kr.repository.FreeboardDao;

@Service
public class FreeboardService {

	@Autowired
	FreeboardDao freeboardDao;
	
	public boolean addNewOne(FreeBoardVo vo) {
		int r = freeboardDao.insertOne(vo);
		
		return r == 1;
	}
	
	public List<FreeBoardVo> getAll(){
		List<FreeBoardVo> list = freeboardDao.selectAll();
		
		return list;
	}
	
	public FreeBoardVo getOneByNo(int no) {
		FreeBoardVo vo = freeboardDao.selectOne(no);
		
		return vo;
	}

	
	
	
}
