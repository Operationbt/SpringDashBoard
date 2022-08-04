package com.spdb.springdashboard;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {
	@Resource(name = "postDAO")
	PostDAO dao;
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePost(@RequestParam("id")int post_id) { 
		System.out.println("http://localhost:8085/springdashboard/delete 들어옴");
		dao.delete(post_id);
	    return "redirect:/"; // 삭제 완료된 후 기본페이지로 리턴
	}
}
