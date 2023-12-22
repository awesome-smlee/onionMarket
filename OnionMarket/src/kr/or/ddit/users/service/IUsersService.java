package kr.or.ddit.users.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.UsersVO;

public interface IUsersService {

   public List<UsersVO> getAllUsers();
}