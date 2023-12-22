package kr.or.ddit.adm.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.UsersVO;

public interface IUsersService {

   public List<UsersVO> getAllUsers();
   
   //리스트 출력 
   public List<UsersVO> selectByPage(Map<String, Object>   map);
      
   //전체글갯수 
   public int getTotalCount(Map<String, Object>   map);
   
   //페이지 정보 - 계산 - 
   public PageVO getPageInfo(int page , String stype, String sword);
}