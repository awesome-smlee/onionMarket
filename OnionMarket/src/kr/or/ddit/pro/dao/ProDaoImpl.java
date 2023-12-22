package kr.or.ddit.pro.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.LocVO;
import kr.or.ddit.vo.ProAndCateVO;
import kr.or.ddit.vo.ProCateVO;
import kr.or.ddit.vo.WishVO;

public class ProDaoImpl implements IProDao {

	private static ProDaoImpl dao;
	private ProDaoImpl() {	}
	public static ProDaoImpl getInstance() {
		if(dao == null) dao = new ProDaoImpl();
		return dao;
	}
	
	@Override
	public List<ProAndCateVO> getProList(Map param) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<ProAndCateVO> list = new ArrayList<>();
		
		try {
			list = session.selectList("pro.getProList", param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	@Override
	public int getProCnt(Map param) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.selectOne("pro.getProCnt", param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}
	
	@Override
	public List<ProCateVO> getProCateList() {
		
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<ProCateVO> list = null;
		
		try {
			list = session.selectList("pro.getProCateList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	@Override
	public ProAndCateVO getProDetail(ProAndCateVO proVo) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		ProAndCateVO vo = null;
		
		try {
			vo = session.selectOne("pro.getProDetail", proVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return vo;
	}
	
	
	@Override
	public int insertPro(ProAndCateVO proVo) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.insert("pro.insertPro", proVo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}
	
	@Override
	public int updatePro(ProAndCateVO proVo) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.update("pro.updatePro", proVo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}
	
	@Override
	public int updateProStatus(ProAndCateVO proVo) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.update("pro.updateProStatus", proVo); 
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}
	
	@Override
	public int insertLike(WishVO wsVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.insert("pro.insertLike", wsVo); 
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}
	
	@Override
	public int deleteLike(WishVO wsVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.delete("pro.deleteLike", wsVo); 
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}
	
	@Override
	public LocVO getLocation(ProAndCateVO proVo) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		LocVO locVo = null;
		
		try {
			locVo = session.selectOne("pro.getLocation", proVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return locVo;
	}
	
	
	@Override
	public int insertLocation(ProAndCateVO proVo) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.insert("pro.insertLocation", proVo); 
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}
	@Override
	public int insertFile(FileInfoVO fileVo) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.insert("pro.insertFile", fileVo); 
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}
	@Override
	public int insertProFile(FileInfoVO fileVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.insert("pro.insertProFile", fileVo); 
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}
	@Override
	public List<FileInfoVO> getProFileList(FileInfoVO fileVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<FileInfoVO> list = new ArrayList<>();
		
		try {
			list = session.selectList("pro.getProFileList", fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	
	@Override
	public int deleteFile(FileInfoVO fileVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.delete("pro.deleteFile", fileVo); 
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}
	
	@Override
	public int deletePro(ProAndCateVO proVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.delete("pro.deletePro", proVo); 
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}
	
	@Override
	public int updateViewCnt(ProAndCateVO proVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.delete("pro.updateViewCnt", proVo); 
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

}
