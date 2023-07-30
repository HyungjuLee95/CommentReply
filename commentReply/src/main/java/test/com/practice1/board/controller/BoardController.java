package test.com.practice1.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import test.com.practice1.board.model.BoardVO;
import test.com.practice1.board.service.BoardService;
import test.com.practice1.comments.model.commentsVO;
import test.com.practice1.comments.service.CommentsService;
import test.com.practice1.comments.service.ReplyService;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@Autowired
	CommentsService com_service;
	
	@Autowired
	ReplyService reply_service;
	
	@RequestMapping(value={"/selectAll.do"}, method = RequestMethod.GET)
	public String selectAll(BoardVO vo, Model model) {
		List<BoardVO> vos = service.selectAll(vo);
		log.info("vos...{}", vos);
		model.addAttribute("vos",vos);
		
		return "boardSelectall";
		
	}
	
	
	@RequestMapping(value={"/selectOne.do"}, method = RequestMethod.GET)
	public String selectOne(BoardVO vo, Model model,@RequestParam("b_num") int C_R_POSTED_NUM,  commentsVO comVO) {
		BoardVO vo2=service.selectOne(vo);
		model.addAttribute("vo2",vo2);
		
		comVO.setC_r_posted_num(vo.getB_num());
		List<commentsVO> com_vos=com_service.selectAll(comVO);
		log.info("com_vo...{}", com_vos);
		model.addAttribute("com_vos",com_vos);
		
		List<commentsVO> reply_vos = reply_service.selectAll(comVO);
		log.info("reply_vos..{}", reply_vos);
		model.addAttribute("reply_vos",reply_vos);

		
		return "boardSelectOne";
		
	}
	
	@RequestMapping(value="/insert.do", method =RequestMethod.GET)
	public String insert(BoardVO vo) {
		return "insert";
	}
	
	@RequestMapping(value="/insertOK.do", method =RequestMethod.GET)
	public String insertOK(BoardVO vo) {
		int result = service.insert(vo);
		
		if(result==1) {return "redirect:selectAll.do";}
		else{return "insert";}
	}
	@RequestMapping(value="/delete.do", method =RequestMethod.GET)
	public String delete(BoardVO vo) {
		int result = service.delete(vo);
		
		if(result==1) {return "redirect:selectAll.do";}
		else{return "redirect:selectOne.do";}
	}

}
