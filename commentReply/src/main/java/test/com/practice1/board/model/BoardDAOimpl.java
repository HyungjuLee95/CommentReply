package test.com.practice1.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class BoardDAOimpl implements BoardDAO{
	
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<BoardVO> selectAll(BoardVO vo) {
		log.info("...{} ", vo);
		return sqlsession.selectList("B_SELECT_ALL", vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		log.info("...{} ", vo);
		return sqlsession.selectOne("B_SELECT_ONE",vo);
	}
	@Override
	public int insert(BoardVO vo) {
		log.info("...{} ", vo);
		return sqlsession.insert("B_INSERT",vo);
	}

	@Override
	public int delete(BoardVO vo) {
		log.info("...{} ", vo);
		return sqlsession.delete("B_DELETE", vo);
	}

	@Override
	public int update(BoardVO vo) {
		log.info("...{} ", vo);
		return 0;
	}


}
