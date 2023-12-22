package kr.or.ddit.com.service;

import java.util.List;

import kr.or.ddit.vo.ComJoinVO;


public interface IComService {
	public List<ComJoinVO> getAllCom();						 // 커뮤니티 목록
	public List<ComJoinVO> getCateNm(); 					 // 왼쪽 메뉴의 카테고리명
	public int comInsert(ComJoinVO comVo);					 // 게시글 등록
	public List<ComJoinVO> getByCate(String cateNm);		 // 카테고리명 클릭시 카테고리별 조회
	public List<ComJoinVO> getByGu(String gu);				 // 구명 클릭시 구별 조회
	public List<ComJoinVO> getSearchCom(String keyword);     // 키워드 검색
	public ComJoinVO getComDetail(int com_id);			   	 // 게시글 상세 조회
	public int getComId(ComJoinVO comVo);					 // COMMUNITY_FILE insert시 필요
	public int incrementVwCnt(int comId);					 // 조회수 증가
	public ComJoinVO getUpdateData(int comId);				 // 수정시 불러올 제목과 내용
	public int comUpdate(ComJoinVO comVo);					 // 게시글 수정
	public int comDelete(int comId);						 // 게시글 삭제
	public String getInsId(int comId);						 // 세션 처리 위한 id (수정/삭제 버튼)
}
