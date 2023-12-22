package kr.or.ddit.main.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.ProAndCateVO;

public class MainDaoImpl implements IMainDao {

	private static MainDaoImpl dao;
	private MainDaoImpl() {	}
	public static MainDaoImpl getInstance() {
		if(dao == null) dao = new MainDaoImpl();
		return dao;
	}
	
	@Override
	public List<ProAndCateVO> getProList(ProAndCateVO proVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<ProAndCateVO> list = new ArrayList();
		
		try {
			list = session.selectList("main.getProList", proVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}

	@Override
	public List<ProAndCateVO> getProListPop() {
		SqlSession session = MybatisUtil.getSqlSession();
		List<ProAndCateVO> list = new ArrayList();
		
		try {
			list = session.selectList("main.getProListPop");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	@Override
	public List<ProAndCateVO> getProListNew() {
		SqlSession session = MybatisUtil.getSqlSession();
		List<ProAndCateVO> list = new ArrayList();
		
		try {
			list = session.selectList("main.getProListNew");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	@Override
	public List<ComJoinVO> getComList() {
		SqlSession session = MybatisUtil.getSqlSession();
		List<ComJoinVO> list = null;
		
		try {
			list = session.selectList("main.getComList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	@Override
	public List<FileInfoVO> getProFileList(FileInfoVO fileVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<FileInfoVO> list = new ArrayList<>();
		
		try {
			list = session.selectList("main.getProFileList", fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}

}
