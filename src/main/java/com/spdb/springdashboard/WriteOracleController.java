package com.spdb.springdashboard;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WriteOracleController {
	@Resource(name = "postDAO")
	private PostDAO dao;
	
	@RequestMapping(value = "/writeOracle", method = RequestMethod.GET)
	public String showWritePage() {
		System.out.println("http://localhost:8085/springdashboard/writeOracle 들어옴");
		return "writeOracle";
	}
	@RequestMapping(value = "/writeOracle", method = RequestMethod.POST) // POST방식으로 내용 전송
	public String writePost(HttpServletRequest request) throws Exception { // 인자값으로 REDIRECT 사용 	 
		
		System.out.println("title : " + request.getParameter("title"));
		System.out.println("writer : " + request.getParameter("writer"));
		System.out.println("content : " + request.getParameter("content"));
		
		PostDTO post = new PostDTO();
		post.setPost_title(request.getParameter("title"));
		post.setPost_writer(request.getParameter("writer"));
		post.setPost_content(request.getParameter("content"));
		dao.writeOracle(post); // 글작성 서비스 호출	
		
	    return "redirect:/oracle"; // 작성이 완료된 후 오라클페이지로 리턴
	}
}
