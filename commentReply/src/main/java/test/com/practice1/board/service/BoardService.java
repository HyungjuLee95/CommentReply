package test.com.practice1.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import test.com.practice1.board.model.BoardDAO;
import test.com.practice1.board.model.BoardVO;


@Repository
@Slf4j
public class BoardService implements BoardDAO {
	@Autowired
	BoardDAO dao;
	
	public List<BoardVO> selectAll(BoardVO vo) {
		log.info("...{} ", vo);
		return dao.selectAll(vo);
	}
	
	public BoardVO selectOne(BoardVO vo) {
		log.info("...{} ", vo);
		return dao.selectOne(vo);
	}
	

	public int insert(BoardVO vo) {
		log.info("...{} ", vo);
		return dao.insert(vo);
	}

	public int delete(BoardVO vo) {
		log.info("...{} ", vo);
		return dao.delete(vo);
	}

	public int update(BoardVO vo) {
		log.info("...{} ", vo);
		return dao.update(vo);
	}

}
