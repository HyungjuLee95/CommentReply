package test.com.practice1.comments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import test.com.practice1.comments.model.commentsVO;
import test.com.practice1.comments.service.ReplyService;

@Controller
@Slf4j
public class ReplyController {
	
	@Autowired
	ReplyService service;
	
	@RequestMapping(value="/reply_insertOK.do", method = RequestMethod.GET)
	public String com_insertOK(commentsVO vo) {
		log.info("insert vo ..... {}", vo);
		int result= service.insert(vo);
		return "redirect:selectOne.do?b_num="+vo.getC_r_posted_num();
		
	}
	
	
	@RequestMapping(value="/reply_deleteOK.do", method = RequestMethod.GET)
	public String reply_deleteOK(commentsVO vo) {
		log.info("reply_deleteOK vo ..... {}", vo);
		int result= service.delete(vo);
		return "redirect:selectOne.do?b_num="+vo.getC_r_posted_num();
		
	}


}
