package com.spdb.springdashboard;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("postDAO")
public class PostDAO {
	//===MySQL DB===
	@Autowired
	@Resource(name="sqlSessoinTemplate")
	private SqlSessionTemplate session;
	//Creat
	public void write(PostDTO post) {
		session.insert("boardMapper.write", post);
	}
	//Read
	public PostDTO read(int post_id) {
		PostDTO post = session.selectOne("boardMapper.read", post_id);
		return post;
	}
	public List<PostDTO> readAll() {
		List<PostDTO> postList = session.selectList("boardMapper.readAll");
		return postList;
	}
	//Update
	public void update(PostDTO newPost) {
		session.update("boardMapper.update", newPost);
	}
	
	//Delete
	public void delete(int post_id) {
		session.delete("boardMapper.delete", post_id);
	}
	
	//===Oracle DB===
	@Autowired
	@Resource(name="sqlSessoinTemplate_oracle")
	private SqlSessionTemplate session_oracle;
	//Creat
	public void writeOracle(PostDTO post) {
		session_oracle.insert("boardMapper_oracle.write", post);
	}
	//Read
	public PostDTO readOracle(int post_id) {
		PostDTO post = session_oracle.selectOne("boardMapper_oracle.read", post_id);
		return post;
	}
	public List<PostDTO> readAllOracle() {
		List<PostDTO> postList = session_oracle.selectList("boardMapper_oracle.readAll");
		return postList;
	}
	//Update
	public void updateOracle(PostDTO newPost) {
		session_oracle.update("boardMapper_oracle.update", newPost);
	}
	
	//Delete
	public void deleteOracle(int post_id) {
		session_oracle.delete("boardMapper_oracle.delete", post_id);
	}
}
