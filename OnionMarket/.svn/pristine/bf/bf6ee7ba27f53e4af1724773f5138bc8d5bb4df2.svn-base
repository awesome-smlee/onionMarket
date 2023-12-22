package kr.or.ddit.my.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.my.dao.IUsersMyDao;
import kr.or.ddit.my.dao.UsersMyDaoImpl;
import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.ProdMyAllVO;
import kr.or.ddit.vo.UsersVO;

public class UsersMyServiceImpl implements IUsersMyService {
	
	private static UsersMyServiceImpl service;
	private IUsersMyDao dao;
	
	private UsersMyServiceImpl() {
		dao = UsersMyDaoImpl.getInstance();
	}
	public static UsersMyServiceImpl getInstance() {
		if(service==null) service = new UsersMyServiceImpl();
		return service;
	}
	
	@Override
	public List<UsersVO> getAllUsers() {
		return dao.getAllUsers();
	}
	@Override
	public int insertUsers(UsersVO usersVo) {
		return dao.insertUsers(usersVo);
	}
	@Override
	public UsersVO getLoginUsers(Map<String, Object> map) {
		return dao.getLoginUsers(map);
	}
	@Override
	public int updateUsers(UsersVO usersVo) {
		return dao.updateUsers(usersVo);
	}
	@Override
	public int locationMy(ComJoinVO comjoinvo) {
		return dao.locationMy(comjoinvo);
	}
	@Override
	public int deleteUsers(UsersVO usersVo) {
		return dao.deleteUsers(usersVo);
	}
	@Override
	public int getUsersCount(String userId) {
		return dao.getUsersCount(userId);
	}
	@Override
	public UsersVO getUsers(String userId) {
		return dao.getUsers(userId);
	}
	@Override
	public List<UsersVO> findIdUsers(UsersVO usersVo) {
		return dao.findIdUsers(usersVo);
	}
	@Override
	public int updateUserpw(UsersVO usersVo) {
		return dao.updateUserpw(usersVo);
		
	}
	@Override
	public int realUsers(UsersVO usersVo) {
		return dao.realUsers(usersVo);
	}
	@Override
	public List<UsersVO> getOneUsers(String userId) {
		return dao.getOneUsers(userId);
	}
	
	

}
