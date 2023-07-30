package test.com.practice1.comments.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;


@Repository
@Slf4j
public class ReplyDAOimpl implements ReplyDAO {
	
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<commentsVO> selectAll(commentsVO vo) {
		log.info("...{}", vo);
		return sqlsession.selectList("R_SELECT_ALL", vo);
	}

	@Override
	public int insert(commentsVO vo) {
		log.info("...{}", vo);
		return sqlsession.insert("R_INSERT", vo);
	}

	@Override
	public int delete(commentsVO vo) {
		log.info("...{}", vo);
		return sqlsession.delete("R_DELETE", vo);
	}

}
