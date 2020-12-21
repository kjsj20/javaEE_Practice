package com.cmmt.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cmmt.domain.Cmmt;
import com.mybatis.config.MybatisConfigManager;

public class CmmtDAO {
	MybatisConfigManager manager = MybatisConfigManager.getInstance();
	
	public List selectAll(int board_id) {
		List list = null;
		SqlSession sqlSession = manager.getSqlSession();
		list = sqlSession.selectList("Cmmt.selectAll", board_id);
		manager.getClose(sqlSession);
		return list;
	}
	
	public int insert(Cmmt cmmt) {
		int result = 0;
		SqlSession sqlSession = manager.getSqlSession();
		result = sqlSession.insert("Cmmt.insert", cmmt);
		sqlSession.commit();
		manager.getClose(sqlSession);
		return result;
	}
}
