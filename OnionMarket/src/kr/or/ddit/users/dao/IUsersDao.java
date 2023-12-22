package kr.or.ddit.users.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.UsersVO;

public interface IUsersDao {
	
	public List<UsersVO> getAllUsers();

}
