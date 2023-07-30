package test.com.practice1.comments.model;

import java.util.List;

public interface CommentsDAO {

	public List<commentsVO> selectAll(commentsVO vo);
	public int insert(commentsVO vo);
	public int delete(commentsVO vo);
	public int update(commentsVO vo);
	
}
