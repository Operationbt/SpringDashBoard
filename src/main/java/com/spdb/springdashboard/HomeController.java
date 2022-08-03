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
		System.out.println("읽기 테스트" + post);
		
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
	
}
