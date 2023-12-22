package kr.or.ddit.com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.ComJoinVO;

public class ComDaoImpl implements IComDao {
	
	private static ComDaoImpl dao;
	private ComDaoImpl() {}
	public static ComDaoImpl getInstance() {
		if(dao == null) dao = new ComDaoImpl();
		return dao;
	}

	@Override
	public List<ComJoinVO> getAllCom() {
		List<ComJoinVO> comList = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			comList = session.selectList("com.getAllCom");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return comList;
	}
	
	@Override
	public List<ComJoinVO> getCateNm() {
		List<ComJoinVO> cateList = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cateList = session.selectList("com.getCateNm");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cateList;
	}
	@Override
	public int comInsert(ComJoinVO comVo) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			count = session.insert("com.comInsert", comVo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return count;
	}
	@Override
	public List<ComJoinVO> getByCate(String cateNm) {
		List<ComJoinVO> comListCate = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			comListCate = session.selectList("com.getByCate", cateNm);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return comListCate;
	}
	
	@Override
	public List<ComJoinVO> getSearchCom(String keyword) {
		List<ComJoinVO> comListSearch = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			comListSearch = session.selectList("com.getSearchCom", keyword);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return comListSearch;
	}
	@Override
	public List<ComJoinVO> getByGu(String gu) {
		List<ComJoinVO> comListGu = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			comListGu = session.selectList("com.getByGu", gu);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return comListGu;
	}
	@Override
	public ComJoinVO getComDetail(int com_id) {
		ComJoinVO comDetail = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			comDetail = session.selectOne("com.getComDetail", com_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return comDetail;
	}
	@Override
	public int getComId(ComJoinVO comVo) {
		int comId = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			comId = session.selectOne("com.getComId", comVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return comId;
	}
	@Override
	public int incrementVwCnt(int comId) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			count = session.update("com.incrementVwCnt", comId);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return count;
	}
	@Override
	public ComJoinVO getUpdateData(int comId) {
		ComJoinVO comVo = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			comVo = session.selectOne("com.getUpdateData", comId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return comVo;
	}
	@Override
	public int comUpdate(ComJoinVO comVo) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			count = session.update("com.comUpdate", comVo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return count;
	}
	@Override
	public int comDelete(int comId) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			count = session.delete("com.comDelete", comId);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return count;
	}
	@Override
	public String getInsId(int comId) {
		String id = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			id = session.selectOne("com.getInsId", comId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return id;
	}

}
