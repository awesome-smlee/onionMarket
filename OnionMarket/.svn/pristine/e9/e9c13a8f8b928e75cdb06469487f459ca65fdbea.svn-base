package kr.or.ddit.comrep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.ComRepVO;

public class ComRepDaoImpl implements IComRepDao {
	
	private static ComRepDaoImpl dao;
	private ComRepDaoImpl() {}
	public static ComRepDaoImpl getInstance() {
		if(dao == null) dao = new ComRepDaoImpl();
		return dao;
	}
	@Override
	public List<ComRepVO> getReply(int comId) {
		List<ComRepVO> repList = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			repList = session.selectList("comRep.getRep", comId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return repList;
	}
	@Override
	public int getRepCount(int comId) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			count = session.selectOne("comRep.getRepCount", comId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}

		return count;
	}
	@Override
	public int comRepInsert(ComRepVO comRepVo) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			count = session.insert("comRep.comRepInsert", comRepVo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return count;
	}
	@Override
	public int comRepDelete(int repId) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			count = session.delete("comRep.comRepDelete", repId);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return count;
	}

}
