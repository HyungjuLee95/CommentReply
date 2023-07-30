package test.com.practice1.board.model;

import java.util.List;

public interface BoardDAO {
	public  List<BoardVO> selectAll(BoardVO vo);
	public BoardVO selectOne(BoardVO vo);
	public int insert(BoardVO vo);
	public int delete(BoardVO vo);
	public int update(BoardVO vo);
	
	

}
