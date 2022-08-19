package com.spdb.springdashboard;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("postOracleDAO")
public class PostOracleDAO {
	//===Oracle DB===
	@Autowired
	@Resource(name="sqlSessoinTemplate_oracle")
	private SqlSessionTemplate session;
	//Creat
	public void write(PostOracleDTO post) {
		session.insert("boardMapper_oracle.write", post);
	}
	//Read
	public PostOracleDTO read(int post_id) {
		PostOracleDTO post = session.selectOne("boardMapper_oracle.read", post_id);
		return post;
	}
	public List<PostOracleDTO> readAll() {
		List<PostOracleDTO> postList = session.selectList("boardMapper_oracle.readAll");
		return postList;
	}
	//Update
	public void update(PostOracleDTO newPost) {
		session.update("boardMapper_oracle.update", newPost);
	}
	
	//Delete
	public void delete(int post_id) {
		session.delete("boardMapper_oracle.delete", post_id);
	}
}
