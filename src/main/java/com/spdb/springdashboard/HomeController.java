package com.spdb.springdashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.spbdDAO;
import dao.spbdDAOImpl;
import dto.spbdPostDTO;
import service.spbdService;
import service.spbdServiceImpl;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private DataSource dataSource;
	
	@Inject
	private spbdService service; //DB사용하는거
	
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
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection) dataSource.getConnection();
			System.out.println("DB 연결 완료");
			model.addAttribute("dbConn", "DB 연결 완료");
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
			model.addAttribute("dbConn", "JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
			model.addAttribute("dbConn", "DB 연결 오류");
		}
		
		if(service == null)
			System.out.println("null");
		
		//db 읽기 테스트
		try {
			System.out.println(service.read(1000));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
	
}
