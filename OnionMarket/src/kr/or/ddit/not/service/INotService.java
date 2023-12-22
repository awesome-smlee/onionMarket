package kr.or.ddit.not.service;

import java.util.List;

import kr.or.ddit.vo.NotVO;

public interface INotService {

	public List<NotVO> getAllNot(); // 공지사항 리스트

	public int getListCount(int notiId); // 공지사항 카운트
	
	public NotVO getNotNum(String notNum); // 공지 이미지

	public List<NotVO> searchNot(String option, String keyword);

	public int updateNot(int noti_id) ;
 
}
