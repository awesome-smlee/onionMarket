package kr.or.ddit.users.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.UsersVO;

public class UsersDaoImpl implements IUsersDao {

	private static UsersDaoImpl dao;
	
	private UsersDaoImpl() {}
	
	public static UsersDaoImpl getInstance() {
		if(dao==null) dao = new UsersDaoImpl();
		return dao;
	}
	
	@Override
	public List<UsersVO> getAllUsers(){
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<UsersVO> usersList = null;
		
		try {
			usersList = session.selectList("users.getAllUsers");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return usersList;
		
	}
	
	
}
