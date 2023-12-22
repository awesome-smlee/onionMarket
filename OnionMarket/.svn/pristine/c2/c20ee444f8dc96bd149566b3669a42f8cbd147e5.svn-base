package kr.or.ddit.my.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.UsersVO;

public interface IUsersMyDao {
	
	//전체 회원
	public List<UsersVO> getAllUsers();
	
	//회원가입
	public int insertUsers(UsersVO usersVo);
	
	//로그인
	 public UsersVO getLoginUsers(Map<String, Object> map);
	
	//프로필수정
	 public int updateUsers(UsersVO usersVo);
	
	//내동네설정
	 public int locationMy(ComJoinVO comjoinvo);
	
	//탈퇴,탈퇴사유
	 public int deleteUsers(UsersVO usersVo);
	
	//아이디중복검사
	 public int getUsersCount(String userId);
	
	//프로필 내꺼 조회
	 public UsersVO getUsers(String userId);
	
	//아이디찾기
	 public List<UsersVO> findIdUsers(UsersVO usersVo);
	
	//비밀번호찾기(수정)
	 public int updateUserpw(UsersVO usersVo);
	 
	//비번찾기할때 존재하는회원인지
	 public int realUsers(UsersVO usersVo);
	
	//회원상세조회
	 public List<UsersVO> getOneUsers(String userId);

}
