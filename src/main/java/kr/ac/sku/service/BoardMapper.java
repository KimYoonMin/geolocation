package kr.ac.sku.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.sku.model.BoardDTO;

@Service
public class BoardMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> listBoard(){
		return sqlSession.selectList("listBoard");
	}
	
}
