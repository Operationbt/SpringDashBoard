package com.spdb.springdashboard;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("postDAO")
public class PostDAO {

	@Resource(name="sqlSessoinTemplate")
	private SqlSessionTemplate session;
	
	public PostDTO read(int post_id) {
		PostDTO post = session.selectOne("boardMapper.read", post_id);
		return post;
	}
	
	public List<PostDTO> readAll() {
		List<PostDTO> postList = session.selectList("boardMapper.readAll");
		return postList;
	}
}
