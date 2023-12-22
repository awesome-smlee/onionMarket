package kr.or.ddit.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.ProdMyAllVO;

public class ProdMyDaoImpl implements IProdMyDao {

   private static ProdMyDaoImpl dao;
   private ProdMyDaoImpl() {}
   
   public static ProdMyDaoImpl getInstance() {
      if(dao==null) dao = new ProdMyDaoImpl();
      
      return dao;
   }
   
   //판매중인 물품
   @Override
   public List<ProdMyAllVO> sellListMy(String userId) {
      SqlSession session = MybatisUtil.getSqlSession(); 
      
      List<ProdMyAllVO> sellList = null;
      
      try {
         sellList = session.selectList("prodmy.sellListMy", userId);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(session!=null) session.close();
      }
      return sellList;
   }
   
   //거래완료인 물품
   @Override
   public List<ProdMyAllVO> sellEndMy(String userId) {
      SqlSession session = MybatisUtil.getSqlSession(); 
      
      List<ProdMyAllVO> sellEndList = null;
      
      try {
         sellEndList = session.selectList("prodmy.sellEndMy", userId);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(session!=null) session.close();
      }
      return sellEndList;
   }

   //내가 구매한 물품
   @Override
   public List<ProdMyAllVO> buyListMy(String userId) {
   SqlSession session = MybatisUtil.getSqlSession(); 
      
      List<ProdMyAllVO> buyListMy = null;
      
      try {
         buyListMy = session.selectList("prodmy.buyListMy", userId);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(session!=null) session.close();
      }
      return buyListMy;
   }

   //후기작성 - 첨부파일
   @Override
   public int reviewUpload1(ProdMyAllVO prodMyAllVo) {
      SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
      
      int cnt = 0;  // 반환값이 저장될 변수 선언
      
      try {
         cnt = session.insert("prodmy.reviewUpload1", prodMyAllVo);
         if(cnt > 0) session.commit();
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(session!=null) session.close();
      }
      
      return cnt;
   }
   
   //후기작성 
   @Override
   public int reviewUpload2(ProdMyAllVO prodMyAllVo) {
      SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
      
      int cnt = 0;  // 반환값이 저장될 변수 선언
      
      try {
         cnt = session.insert("prodmy.reviewUpload2", prodMyAllVo);
         if(cnt > 0) session.commit();
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(session!=null) session.close();
      }
      
      return cnt;
   }

   //후기보기
   @Override
   public List<ProdMyAllVO> review(ProdMyAllVO prodMyAllVo) {
      SqlSession session = MybatisUtil.getSqlSession(); 
      
      List<ProdMyAllVO> review = null;
      
      try {
         review = session.selectList("prodmy.review");
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(session!=null) session.close();
      }
      return review;
   }
   
   //위시리스트
   @Override
   public List<ProdMyAllVO> wishlistMy(String userId) {
      SqlSession session = MybatisUtil.getSqlSession(); 
      
      List<ProdMyAllVO> wishList = null;
      
      try {
         wishList = session.selectList("prodmy.wishlistMy", userId);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(session!=null) session.close();
      }
      return wishList;
   }
   
   //내가 작성한 커뮤니티
   @Override
   public List<ProdMyAllVO> CommunityMy(String userId) {
      SqlSession session = MybatisUtil.getSqlSession(); 
      
      List<ProdMyAllVO> comList = null;
      
      try {
         comList = session.selectList("prodmy.CommunityMy", userId);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(session!=null) session.close();
      }
      return comList;
   }

   @Override
   public int Location(String dong) {
	   SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
	      
	      int cnt = 0;  // 반환값이 저장될 변수 선언
	      
	      try {
	         cnt = session.selectOne("prodmy.Location", dong);
	         if(cnt > 0) session.commit();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         if(session!=null) session.close();
	      }
	      
	      return cnt;
	   }
	   
}

   
   

