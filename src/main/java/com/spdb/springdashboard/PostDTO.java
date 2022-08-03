package com.spdb.springdashboard;

import java.sql.Date;

/*
 *   `post_id` int unsigned NOT NULL,
  `post_writer` varchar(20) DEFAULT NULL,
  `post_title` varchar(50) DEFAULT NULL,
  `post_content` text,
  `post_date` datetime DEFAULT NULL,
 */
public class PostDTO {
	private int post_id;
	private String post_writer;
	private String post_titile;
	private String post_content;
	private Date post_date;
	
	public PostDTO() {
		this(0, null, null, null, null);
	}
	public PostDTO(int post_id, String post_writer, String post_titile, String post_content, Date post_date) {
		this.post_id = post_id;
		this.post_writer = post_writer;
		this.post_titile = post_titile;
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
	public String getPost_titile() {
		return post_titile;
	}
	public void setPost_titile(String post_titile) {
		this.post_titile = post_titile;
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
		return "postDTO [post_id=" + post_id + ", post_writer=" + post_writer + ", post_titile=" + post_titile
				+ ", post_content=" + post_content + ", post_date=" + post_date + "]";
	}
	
	
}
