package dao;

import dto.spbdPostDTO;

public interface spbdDAO {
	public spbdPostDTO read(int post_id) throws Exception;
}
