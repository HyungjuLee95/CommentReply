package test.com.practice1.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import test.com.practice1.board.model.BoardVO;
import test.com.practice1.board.service.BoardService;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping(value={"/selectAll.do"}, method = RequestMethod.GET)
	public String selectAll(BoardVO vo, Model model) {
		List<BoardVO> vos = service.selectAll(vo);
		model.addAttribute("vos",vos);
		
		return "boardSelectall";
		
	}
	
	
	@RequestMapping(value={"/selectOne.do"}, method = RequestMethod.GET)
	public String selectOne(BoardVO vo, Model model) {
		BoardVO vo2=service.selectOne(vo);
		model.addAttribute("vo2",vo2);
		
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
