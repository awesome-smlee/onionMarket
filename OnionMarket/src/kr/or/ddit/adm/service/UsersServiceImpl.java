package kr.or.ddit.adm.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.adm.dao.IUsersDao;
import kr.or.ddit.adm.dao.UsersDaoImpl;
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
   public List<UsersVO> getAllUsers(){
      return dao.getAllUsers();
   }

   @Override
   public List<UsersVO> selectByPage(Map<String, Object> map) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public int getTotalCount(Map<String, Object> map) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public PageVO getPageInfo(int page, String stype, String sword) {
      // TODO Auto-generated method stub
      return null;
   }
}