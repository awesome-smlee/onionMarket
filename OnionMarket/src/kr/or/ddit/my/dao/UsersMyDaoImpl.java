package kr.or.ddit.my.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.UsersVO;

public class UsersMyDaoImpl implements IUsersMyDao {
	
	private static UsersMyDaoImpl dao;
	private UsersMyDaoImpl() {}
	
	public static UsersMyDaoImpl getInstance() {
		if(dao==null) dao = new UsersMyDaoImpl();
		
		return dao;
	}
	
	//전체회원
	@Override
	public List<UsersVO> getAllUsers() {
		SqlSession session = MybatisUtil.getSqlSession(); 
		
		List<UsersVO> userList = null;
		
		try {
			userList = session.selectList("users.getAllUsers");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return userList;
	}

	//회원가입
	@Override
	public int insertUsers(UsersVO usersVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("users.insertUsers", usersVo);
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) 
				
				session.close();
		}
		
		return cnt;
	}

	//로그인
	@Override
	public UsersVO getLoginUsers(Map<String, Object> map) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		UsersVO vo = null;
		
		try {
			vo  = session.selectOne("users.getLoginUsers", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return vo;
	}
	
	//회원수정
	@Override
	public int updateUsers(UsersVO usersVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("users.updateUsers", usersVo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
	
		return cnt;
	}
	
	//내동네수정
	@Override
	public int locationMy(ComJoinVO comjoinvo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("users.locationMy", comjoinvo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
	
		return cnt;
	}
	
	//회원탈퇴(수정)
	@Override
	public int deleteUsers(UsersVO usersVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("users.deleteUsers", usersVo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
	
		return cnt;
	}

	//아이디중복검사
	@Override
	public int getUsersCount(String userId) {
		SqlSession session = MybatisUtil.getSqlSession();
		int count = 0;
		try {
			count = session.selectOne("users.getUsersCount", userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		} 
		return count;
	}
	

	//프로필 내꺼 조회
	@Override
	public UsersVO getUsers(String userId) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		UsersVO myList = null;
			
		try {
			myList = session.selectOne("users.getUsers", userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return myList;
	}

	//아이디찾기
	@Override
	public List<UsersVO> findIdUsers(UsersVO usersVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<UsersVO> myId = null;
		
		try {
			myId = session.selectList("users.findIdUsers", usersVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return myId;
	}
	
	
	//비번찾기(수정)
	@Override
	public int updateUserpw(UsersVO usersVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int count = 0;
		
		try {
			count = session.update("users.updateUserpw", usersVo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) 
				
				
				session.close();
		} 
		return count;
	}
	
	//비번찾기할때 존재하는회원인지
	@Override
	public int realUsers(UsersVO usersVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int count = 0;
		
		try {
			count = session.selectOne("users.realUsers", usersVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		} 
		return count;
	}

	@Override
	public List<UsersVO> getOneUsers(String userId) {
		SqlSession session = MybatisUtil.getSqlSession(); 
		
		List<UsersVO> userList = null;
		
		try {
			userList = session.selectList("users.getOneUsers" , userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return userList;
	}
}




	
	
	