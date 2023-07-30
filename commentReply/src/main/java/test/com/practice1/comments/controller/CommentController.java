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
import test.com.practice1.comments.service.CommentsService;

@Controller
@Slf4j
public class CommentController {
	@Autowired
	CommentsService service;
	
		@ResponseBody
		@RequestMapping(value="/json_comment_selectAll.do", method = RequestMethod.GET)
		public List<commentsVO> json_comment_selectAll(@RequestParam("b_num") int C_R_POSTED_NUM,  commentsVO vo){
			log.info("C_R_POSTED_NUM...{}", C_R_POSTED_NUM);
			vo.setC_r_posted_num(C_R_POSTED_NUM);
			log.info("vovovovo...{}", vo);
			List<commentsVO> vos = service.selectAll(vo);
			log.info("vos...{}", vos);
			return vos;
	}
		
	@RequestMapping(value="/com_insertOK.do", method = RequestMethod.GET)
	public String com_insertOK(commentsVO vo) {
		log.info("insert vo ..... {}", vo);
		int result= service.insert(vo);
		return "redirect:selectOne.do?b_num="+vo.getC_r_posted_num();
		
	}

}
