package com.spdb.springdashboard;

import java.sql.Date;

/*
 *   `post_id` int unsigned NOT NULL,
  `post_writer` varchar(20) DEFAULT NULL,
  `post_title` varchar(50) DEFAULT NULL,
  `post_content` text,
  `post_date` datetime DEFAULT NULL,
 */
public class PostOracleDTO {
	private int post_id;
	private String post_writer;
	private String post_title;
	private String post_content;
	private Date post_date;
	
	public PostOracleDTO() {
		this(0, null, null, null, null);
	}
	public PostOracleDTO(int post_id, String post_writer, String post_titile, String post_content, Date post_date) {
		this.post_id = post_id;
		this.post_writer = post_writer;
		this.post_title = post_titile;
		this.post_content = post_content;
		this.post_date = post_date;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getPost_writer() {
		return post_writer;
	}
	public void setPost_writer(String post_writer) {
		this.post_writer = post_writer;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	@Override
	public String toString() {
		return "postOracleDTO [post_id=" + post_id + ", post_writer=" + post_writer + ", post_title=" + post_title
				+ ", post_content=" + post_content + ", post_date=" + post_date + "]";
	}
	
	
}
