package kr.or.ddit.users.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.users.dao.IUsersDao;
import kr.or.ddit.users.dao.UsersDaoImpl;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.UsersVO;

public class UsersServiceImpl implements IUsersService {

	private static UsersServiceImpl service;
	
	private IUsersDao dao;
	
	private UsersServiceImpl() {
		dao = UsersDaoImpl.getInstance();
	}
	
	public static UsersServiceImpl getInstance() {
		if(service==null) service = new UsersServiceImpl();
		return service;
	}

	@Override
	public List<UsersVO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
	
	