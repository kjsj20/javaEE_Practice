package com.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.domain.Board;
import com.mybatis.config.MybatisConfigManager;

public class BoardDAO {
	MybatisConfigManager manager = MybatisConfigManager.getInstance();
	
	public List selectAll() {
		List list = null;
		SqlSession sqlSession = manager.getSqlSession();
		list = sqlSession.selectList("selectAll");
		manager.getClose(sqlSession);
		return list;
	}
	
	public Board select(int board_id) {
		Board board = null;
		SqlSession sqlSession = manager.getSqlSession();
		board = sqlSession.selectOne("select", board_id);
		manager.getClose(sqlSession);
		return board;
	} 
	
	public int insert(Board board) {
		int result = 0;
		return result;
	}
	
	public int delete(int board_id) {
		int result = 0;
		return result;
	}
	
	public int update(Board board) {
		int result = 0;
		return result;
	}
}
