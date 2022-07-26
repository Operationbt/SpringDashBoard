package com.spdb.springdashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private DataSource dataSource;
	
	//@Autowired
	//private spbdService service; //DB사용하는거
	
	//@Inject
	//private SqlSessionFactory sqlFactory;
	
	@Resource(name = "postDAO")
	private PostDAO dao;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myName", " 백지훈");
		
		//db연동 테스트
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection) dataSource.getConnection();
			System.out.println("DB 연결 완료");
			model.addAttribute("dbConn", "DB 연결 완료");
			
		} catch (Exception e) {
			System.out.println("DB 연결 오류");
			model.addAttribute("dbConn", "DB 연결 오류");
			e.printStackTrace();
		}
		/*
		try {
			SqlSession session = sqlFactory.openSession();
			System.out.println("성공 : " + session);
		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		}
		*/
		PostDTO post = dao.read(1000);
		//System.out.println("읽기 테스트" + post);
		
		System.out.println(dao.readAll());
		model.addAttribute("list", dao.readAll());
		
		/*
		System.out.println("쓰기 테스트");
		post = new PostDTO();
		post.setPost_writer("tester");
		post.setPost_title("test title");
		post.setPost_content("test contect");
		dao.write(post);
		System.out.println("쓴거 확인");
		System.out.println(dao.readAll());
		model.addAttribute("list", dao.readAll());
		*/
		
		/*
		System.out.println("삭제 테스트");
		dao.delete(1005);
		System.out.println("삭제 확인");
		System.out.println(dao.readAll());
		model.addAttribute("list", dao.readAll());
		*/
		
		/*
		System.out.println("수정 테스트");
		PostDTO newPost = dao.read(1011);
		newPost.setPost_title("제목 바꾸기");
		newPost.setPost_content("내용 바꾸기");
		dao.update(newPost);
		System.out.println("수정 확인");
		System.out.println(dao.readAll());
		model.addAttribute("list", dao.readAll());
		*/
		
		//db 읽기 테스트
		/*
		try {
			System.out.println(service.read(1000));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return "home";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myName", " 백지훈");
		
		//db연동 테스트
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection) dataSource.getConnection();
			System.out.println("DB 연결 완료");
			model.addAttribute("dbConn", "DB 연결 완료");
			
		} catch (Exception e) {
			System.out.println("DB 연결 오류");
			model.addAttribute("dbConn", "DB 연결 오류");
			e.printStackTrace();
		}
		
		model.addAttribute("list", dao.readAll());
		
		return "home";
	}
	
}
