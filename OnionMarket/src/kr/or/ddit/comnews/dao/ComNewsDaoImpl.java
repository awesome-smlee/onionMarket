package kr.or.ddit.comnews.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.ComNewsVO;

public class ComNewsDaoImpl implements IComNewsDao {
	
	private static ComNewsDaoImpl dao;
	private ComNewsDaoImpl() {}
	public static ComNewsDaoImpl getInstance() {
		if(dao == null) dao = new ComNewsDaoImpl();
		return dao;
	}

	@Override
	public List<ComNewsVO> getNewsList() {
		List<ComNewsVO> newsList = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			newsList = session.selectList("comNews.getNewsList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return newsList;
	}

	@Override
	public int comNewsInsert(ComNewsVO comNewsVo) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			count = session.insert("comNews.comNewsInsert", comNewsVo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return count;
	}
	@Override
	public int reset() {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			count = session.delete("comNews.reset");
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return count;
	}

}
