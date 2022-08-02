package dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dto.spbdPostDTO;

@Repository
public class spbdDAOImpl implements spbdDAO{
	
	@Inject
	private SqlSession session;
	private static String namespace = "board-Mapper";
	

	@Override
	public spbdPostDTO read(int post_id) throws Exception {
		return session.selectOne(namespace + ".read", post_id);
	}

}
