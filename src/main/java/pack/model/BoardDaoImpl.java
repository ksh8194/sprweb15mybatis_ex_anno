package pack.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDaoInter{
	
	
	@Autowired	
	public void setFactory(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	@Override
	public boolean insert(BoardBean bean) { //추가용
		int re = getSqlSession().insert("insertData",bean);
		
		if(re>0) 
		return true;
		else 
			return false;
		
		
		
	}
	
	@Override
	public int currentNum() { //추가용
		// TODO Auto-generated method stub
		if(getSqlSession().selectOne("currentNum")==null) return 0;
		return getSqlSession().selectOne("currentNum");
	}
	
	@Override
	public ArrayList<BoardDto> getList() {
		// TODO Auto-generated method stub
		return (ArrayList)getSqlSession().selectList("selectList");
	}
	
	@Override
	public int totalCnt() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCnt");
	}
	
	
	
}
