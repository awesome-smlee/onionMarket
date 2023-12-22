package kr.or.ddit.pro.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.ProAndCateVO;
import kr.or.ddit.vo.ProCateVO;
import kr.or.ddit.vo.WishVO;

public interface IProService {

	/**
	 * DB의 전체 물품 정보를 가져와서 List에 담아 반환하는 메서드
	 * @return ProAndCateVO객체가 저장된 List객체
	 */
	public Map getProPage(Map param);
	
	
	/**
	 * 물품 카테고리 목록 조회
	 * @return 물품 카테고리 리스트 
	 */
	public List<ProCateVO> getProCateList();
	
	
	/**
	 * 한개의 물품 정보를 가져와서 List에 담아 반환하는 메서드
	 * @return
	 */
	public ProAndCateVO getProDetail(ProAndCateVO proVo);
	
	/**
	 * ProAndCateVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param proVo DB에 insert할 자료가 저장된 ProAndCateVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertPro(ProAndCateVO proVo, HttpServletRequest req) throws IOException, ServletException;
	public int updatePro(ProAndCateVO proVo, HttpServletRequest req) throws IOException, ServletException;
	
	/**
	 * 물품 거래상태를 DB에 update하는 메서드
	 * 
	 * @param ProAndCateVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateProStatus(ProAndCateVO proVo);
	
	/**
	 * 좋아요상태를 DB에 insert하는 메서드
	 * 
	 * @param WishVO
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertLike(WishVO wsVo);
	
	/**
	 * 좋아요상태를 DB에 delete하는 메서드
	 * 
	 * @param WishVO
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteLike(WishVO wsVo);
	
	public List<FileInfoVO> getProFileList(FileInfoVO fileVo);
	
	public int deletePro(ProAndCateVO proVo, HttpServletRequest req);
	
	public int updateViewCnt(ProAndCateVO proVo);
}
