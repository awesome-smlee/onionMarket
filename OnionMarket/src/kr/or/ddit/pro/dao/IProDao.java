package kr.or.ddit.pro.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.LocVO;
import kr.or.ddit.vo.ProAndCateVO;
import kr.or.ddit.vo.ProCateVO;
import kr.or.ddit.vo.WishVO;

public interface IProDao {

	/**
	 * DB의 전체 물품 정보를 가져와서 List에 담아 반환하는 메서드
	 * @return ProAndCateVO객체가 저장된 List객체
	 */
	public List<ProAndCateVO> getProList(Map param);

	/**
	 * 물품을 검색하여 해당 물품의 정보를 가져와서 int로 반환하는 메서드
	 * @return 행갯수
	 */
	public int getProCnt(Map param);
	
	/**
	 * 물품 카테고리 목록 조회
	 * @return 물품 카테고리 리스트
	 */
	public List<ProCateVO> getProCateList();
	
	/**
	 * 한개의 물품 정보를 가져와서 vo에 담아 반환하는 메서드
	 * @return ProAndCateVO객체
	 */
	public ProAndCateVO getProDetail(ProAndCateVO proVo);
	
	/**
	 * ProAndCateVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param proVo DB에 insert할 자료가 저장된 ProAndCateVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertPro(ProAndCateVO proVo);
	public int updatePro(ProAndCateVO proVo);
	
	/**
	 * 거래상태를 DB에 update하는 메서드
	 * 
	 * @param prodId DB에 update할 게시글 id
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateProStatus(ProAndCateVO proVo);
	
	/**
	 * 좋아요상태를 DB에 insert하는 메서드
	 * 
	 * @param prodId DB에 insert 할 게시글 id
	 * @param insId DB insert 할 작성자 id
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertLike(WishVO wsVo);
	
	/**
	 * 좋아요상태를 DB에 delete하는 메서드
	 * 
	 * @param prodId DB에 insert 할 게시글 id
	 * @param insId DB insert 할 작성자 id
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteLike(WishVO wsVo);
	
	public LocVO getLocation(ProAndCateVO proVo);
	
	public int insertLocation(ProAndCateVO proVo);
	
	public int insertFile(FileInfoVO fileVo);
	
	public int insertProFile(FileInfoVO fileVo);
	
	public List<FileInfoVO> getProFileList(FileInfoVO fileVo);
	
	public int deleteFile(FileInfoVO fileVo);
	
	public int deletePro(ProAndCateVO proVo);
	
	public int updateViewCnt(ProAndCateVO proVo);
	
}
