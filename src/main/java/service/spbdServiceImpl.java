package service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.spbdDAO;
import dao.spbdDAOImpl;
import dto.spbdPostDTO;

@Service
public class spbdServiceImpl implements spbdService{
	
	@Autowired
	private spbdDAO dao;

	@Override
	public spbdPostDTO read(int post_id) throws Exception {
		return dao.read(post_id);
	}

}
