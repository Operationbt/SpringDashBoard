package com.spdb.springdashboard;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModifyController {
	@Resource(name = "postDAO")
	PostDAO dao;
	private int id;
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String showPage(@RequestParam("id")int post_id, Model model) {
		System.out.println("http://localhost:8085/springdashboard/modify 들어옴" + post_id);
		id = post_id;
		model.addAttribute("postDTO", dao.read(post_id));
		return "/modify";
	}
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(HttpServletRequest request) {
		System.out.println("http://localhost:8085/springdashboard/modify 수정버튼 누름");
		PostDTO newPost = dao.read(id);
		System.out.println("title : " + request.getParameter("title"));
		System.out.println("content : " + request.getParameter("content"));
		newPost.setPost_title(request.getParameter("title"));
		newPost.setPost_content(request.getParameter("content"));
		System.out.println("바꿀 내용" + newPost);
		dao.update(newPost);
		return "redirect:/"; // 수정이 완료된 후 기본페이지로 리턴
	}
}
