package kr.or.ddit.example.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.FileInfoVO;

public class FileDaoImpl implements IFileDao {

	private static FileDaoImpl dao;
	private FileDaoImpl() {	}
	public static FileDaoImpl getInstance() {
		if(dao == null) dao = new FileDaoImpl();
		return dao;
	}
	@Override
	public List<FileInfoVO> getFileList(Map param) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<FileInfoVO> list = null;
		
		try {
			list = session.selectList("file.getFileList", param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	@Override
	public int insertFile(FileInfoVO vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.insert("file.insertFile", vo); 
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}
	
	
	
	
//	@Override
//	public List<ProAndCateVO> getProList(Map param) {
//		SqlSession session = MybatisUtil.getSqlSession();
//		List<ProAndCateVO> list = null;
//		
//		try {
//			list = session.selectList("pro.getProList", param);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(session!=null) session.close();
//		}
//		
//		return list;
//	}
//	
//	@Override
//	public int getProCnt(Map param) {
//		SqlSession session = MybatisUtil.getSqlSession();
//		int cnt = 0;
//		
//		try {
//			cnt = session.selectOne("pro.getProCnt", param);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(session!=null) session.close();
//		}
//		
//		return cnt;
//	}
//	
//	@Override
//	public List<ProCateVO> getProCateList() {
//		
//		SqlSession session = MybatisUtil.getSqlSession();
//		
//		List<ProCateVO> list = null;
//		
//		try {
//			list = session.selectList("pro.getProCateList");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(session!=null) session.close();
//		}
//		
//		return list;
//	}
//	
//	@Override
//	public ProAndCateVO getProDetail(String prodId) {
//		
//		SqlSession session = MybatisUtil.getSqlSession();
//		ProAndCateVO proVo = null;
//		
//		try {
//			proVo = session.selectOne("pro.getProDetail", prodId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(session!=null) session.close();
//		}
//		return proVo;
//	}
//	
//	
//	@Override
//	public int insertPro(ProAndCateVO proVo) {
//		
//		SqlSession session = MybatisUtil.getSqlSession();
//		int cnt = 0;
//		
//		try {
//			cnt = session.insert("pro.insertPro", proVo);
//			if(cnt > 0) session.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(session!=null) session.close();
//		}
//		
//		return cnt;
//	}
//	
//	@Override
//	public int updateProStatus(ProAndCateVO proVo) {
//		
//		SqlSession session = MybatisUtil.getSqlSession();
//		int cnt = 0;
//		
//		try {
//			cnt = session.update("pro.updateProStatus", proVo); 
//			if(cnt > 0) session.commit();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(session!=null) session.close();
//		}
//		
//		return cnt;
//	}
//	
//	
//	@Override
//	public LocationVO getLocation(ProAndCateVO proVo) {
//		
//		SqlSession session = MybatisUtil.getSqlSession();
//		LocationVO locVo = null;
//		
//		try {
//			locVo = session.selectOne("pro.getLocation", proVo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(session!=null) session.close();
//		}
//		return locVo;
//	}
//	
//	
//	@Override
//	public int insertLocation(ProAndCateVO proVo) {
//		
//		SqlSession session = MybatisUtil.getSqlSession();
//		int cnt = 0;
//		
//		try {
//			cnt = session.insert("pro.insertLocation", proVo); 
//			if(cnt > 0) session.commit();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(session!=null) session.close();
//		}
//		
//		return cnt;
//	}

}
