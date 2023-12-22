package kr.or.ddit.my.service;

import java.util.List;

import kr.or.ddit.my.dao.IProdMyDao;
import kr.or.ddit.my.dao.ProdMyDaoImpl;
import kr.or.ddit.vo.ProdMyAllVO;

public class ProdMyServiceImpl implements IProdMyService {

   private static ProdMyServiceImpl service;
   private IProdMyDao dao;
   
   private ProdMyServiceImpl() {
      dao = ProdMyDaoImpl.getInstance();
   }
   public static ProdMyServiceImpl getInstance() {
      if(service==null) service = new ProdMyServiceImpl();
      return service;
   }
   
   @Override
   public List<ProdMyAllVO> sellListMy(String userId) {
      // TODO Auto-generated method stub
      return dao.sellListMy(userId);
   }
   
   @Override
   public List<ProdMyAllVO> sellEndMy(String userId) {
      // TODO Auto-generated method stub
      return dao.sellEndMy(userId);
   }
   
   @Override
   public List<ProdMyAllVO> buyListMy(String userId) {
      // TODO Auto-generated method stub
      return dao.buyListMy(userId);
   }
   @Override
   public int reviewUpload1(ProdMyAllVO prodMyAllVo) {
      // TODO Auto-generated method stub
      return dao.reviewUpload1(prodMyAllVo);
   }
   @Override
   public int reviewUpload2(ProdMyAllVO prodMyAllVo) {
      // TODO Auto-generated method stub
      return dao.reviewUpload2(prodMyAllVo);
   }
   @Override
   public List<ProdMyAllVO> review(ProdMyAllVO prodMyAllVo) {
      // TODO Auto-generated method stub
      return dao.review(prodMyAllVo);
   }
   @Override
   public List<ProdMyAllVO> wishlistMy(String userId) {
      // TODO Auto-generated method stub
      return dao.wishlistMy(userId);
   }
   @Override
   public List<ProdMyAllVO> CommunityMy(String userId) {
      // TODO Auto-generated method stub
      return dao.CommunityMy(userId);
   }
   @Override
   public int Location(String dong) {
	// TODO Auto-generated method stub
	return dao.Location(dong);
}
   

}