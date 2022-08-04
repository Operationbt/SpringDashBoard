package com.spdb.springdashboard;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReadController {
	@Resource(name = "postDAO")
	private PostDAO dao;
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String showPage(@RequestParam("post_id")int post_id, Model model) {
		PostDTO post = dao.read(post_id);
		System.out.println("읽기 페이지 내용" + post);
		
		model.addAttribute("postDTO", post);
		return "/read";
	}
}
