package kr.or.ddit.main.dao;

import java.util.List;

import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.ProAndCateVO;

public interface IMainDao {

	/**
	 * 우리 동네 물품 조회
	 * @return ProAndCateVO가 담긴 List 
	 */
	public List<ProAndCateVO> getProList(ProAndCateVO proVo);
	
	/**
	 * 실시간 인기 물품 조회
	 * @return ProAndCateVO가 담긴 List 
	 */
	public List<ProAndCateVO> getProListPop();
	
	/**
	 * 방금 등록된 물품 조회
	 * @return ProAndCateVO가 담긴 List 
	 */
	public List<ProAndCateVO> getProListNew();
	
	/**
	 * 커뮤니티 리스트 조회
	 * @return ComJoinVO가 담긴 List 
	 */
	public List<ComJoinVO> getComList();
	
	public List<FileInfoVO> getProFileList(FileInfoVO fileVo);
	
}
