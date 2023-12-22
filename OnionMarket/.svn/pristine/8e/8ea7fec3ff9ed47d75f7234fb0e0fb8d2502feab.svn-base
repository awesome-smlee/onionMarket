package kr.or.ddit.police.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.PoliceVO;

public class PoliceDaoImpl implements IPoliceDao {
	
	private static PoliceDaoImpl dao;
	private PoliceDaoImpl() {}
	public static PoliceDaoImpl getInstance() {
		if(dao == null) dao = new PoliceDaoImpl();
		return dao;
	}

	@Override
	public List<PoliceVO> getAllPol() {
		List<PoliceVO> polList = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			polList = session.selectList("pol.getAllPol");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return polList;
	}

	@Override
	public int polInsert(PoliceVO polVo) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			count = session.insert("pol.polInsert", polVo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return count;
	}

}
