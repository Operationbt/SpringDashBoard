package service;

import dto.spbdPostDTO;

public interface spbdService {
	public spbdPostDTO read(int post_id) throws Exception;
}
