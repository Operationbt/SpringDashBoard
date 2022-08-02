package dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.spbdPostDTO;

@Repository
public class spbdDAOImpl implements spbdDAO{
	
	@Autowired
	private SqlSession session;
	private static String namespace = "board-Mapper"; //Mybatis Mapper xml 이름
	

	@Override
	public spbdPostDTO read(int post_id) throws Exception {
		return session.selectOne(namespace + ".read", post_id); //board-Mapper.read
	}

}
