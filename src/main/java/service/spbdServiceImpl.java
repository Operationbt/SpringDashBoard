package service;

import javax.inject.Inject;

import dao.spbdDAO;
import dao.spbdDAOImpl;
import dto.spbdPostDTO;

public class spbdServiceImpl implements spbdService{
	
	@Inject
	private spbdDAO dao = new spbdDAOImpl();

	@Override
	public spbdPostDTO read(int post_id) throws Exception {
		return dao.read(post_id);
	}

}
