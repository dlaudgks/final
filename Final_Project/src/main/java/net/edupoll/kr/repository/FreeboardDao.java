package net.edupoll.kr.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.FreeBoardVo;

@Repository
public class FreeboardDao {

	@Autowired
	SqlSession sqlSession;
	
	public int InsertOne(FreeBoardVo vo) {
		
		return sqlSession.insert("");
	}
	
}
