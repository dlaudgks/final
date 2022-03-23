package net.edupoll.kr.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.FreeBoardVo;

@Repository
public class FreeboardDao {

	@Autowired
	SqlSession sqlSession;
	
	public int insertOne(FreeBoardVo vo) {
		
		return sqlSession.insert("freeboard.insertOne",vo);
	}
	
	public List<FreeBoardVo> selectAll(){
		
		return sqlSession.selectList("freeboard.selectAll");
	}
	
	public FreeBoardVo selectOne(int no) {
		
		return sqlSession.selectOne("freeboard.selectOne", no );
	}
	
	public List<FreeBoardVo> selectListByNo(int no) {
		return sqlSession.selectList("freeboard.selectOne", no);
	}
	
}
