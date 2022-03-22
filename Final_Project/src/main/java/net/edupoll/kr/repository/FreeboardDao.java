package net.edupoll.kr.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FreeboardDao {

	@Autowired
	SqlSession sqlSession;
	
	public String InsertOne() {
		
		return "";
	}
	
}
