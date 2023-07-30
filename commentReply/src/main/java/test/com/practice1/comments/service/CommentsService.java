package test.com.practice1.comments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import test.com.practice1.comments.model.CommentsDAO;
import test.com.practice1.comments.model.commentsVO;

@Service
@Slf4j
public class CommentsService {
	
	@Autowired
	CommentsDAO dao;
	
	public List<commentsVO> selectAll(commentsVO vo) {
		log.info(" ...{}", vo);
		return dao.selectAll(vo);
	}

	public int insert(commentsVO vo) {
		log.info(" ...{}", vo);
		return dao.insert(vo);
	}

	public int delete(commentsVO vo) {
		log.info(" ...{}", vo);
		return dao.delete(vo);
	}

	public int update(commentsVO vo) {
		log.info(" ...{}", vo);
		return dao.update(vo);
	}

}
