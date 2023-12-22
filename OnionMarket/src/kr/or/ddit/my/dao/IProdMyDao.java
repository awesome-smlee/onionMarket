package kr.or.ddit.my.dao;

import java.util.List;

import kr.or.ddit.vo.ProdMyAllVO;

public interface IProdMyDao {
	
	//판매중인 물품
	public List<ProdMyAllVO> sellListMy(String userId);
	
	//거래완료인 물품
	public List<ProdMyAllVO> sellEndMy(String userId);
	
	//내가 구매한 물품
	public List<ProdMyAllVO> buyListMy(String userId);
	
	//후기작성
	public int reviewUpload1(ProdMyAllVO prodMyAllVo);
	
	public int reviewUpload2(ProdMyAllVO prodMyAllVo);
	
	//후기보기
	public List<ProdMyAllVO> review(ProdMyAllVO prodMyAllVo);
	
	//위시리스트
	public List<ProdMyAllVO> wishlistMy(String userId);
	
	//내가 작성한 커뮤니티
	public List<ProdMyAllVO> CommunityMy(String userId);
	
	//동이름 받아서 숫자로 변환
	public int Location(String dong);
	
}
