package kr.or.ddit.que.ado;

 import java.util.List;
 
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.QueVO;

public class QueDaoImpl implements IQueDao {

	// 1번
	private static QueDaoImpl dao;

	// 2번 - 생성자
	private QueDaoImpl() {
	}

	// 3번
	public static QueDaoImpl getInstance() {
		if (dao == null)
			dao = new QueDaoImpl();

		return dao;
	}

	@Override
	public List<QueVO> getAllQue() {
		SqlSession session = MybatisUtil.getSqlSession();
		List<QueVO> queList = null; // 반환값이 저장될 변수

		try {
			queList = session.selectList("que.queAllQue");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return queList;
	}

	public int getListCount(int queId) {
		SqlSession session = MybatisUtil.getSqlSession();
		int count = 0;
		try {
			count = session.selectOne("que.getListCount", queId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.commit();
			session.close();
		}
		return count;
	}
	
	@Override
	public int queIns(QueVO qv) {
SqlSession session = MybatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			
			cnt = session.insert("que.qeuIns", qv);
			
			if (cnt > 0) session.commit();
		
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int queDel(String queNo) {
SqlSession session = MybatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			
			cnt = session.delete("que.queDel", queNo);
			
			if (cnt > 0) session.commit();
		
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int qeuAns(QueVO qv) {
SqlSession session = MybatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			
			cnt = session.insert("que.qeuAnswer", qv);
			
			if (cnt > 0) session.commit();
		
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int admQueDel(String upip) {
		SqlSession session = MybatisUtil.getSqlSession();

		int cnt = 0;
		try {
			
			cnt = session.delete("que.admQueDel", upip);
			
			if (cnt > 0) session.commit();
		
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
	
}