package kr.or.ddit.adm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.PoliceVO;

public class PoliceDaoImpl implements IPoliceDao {

	private static PoliceDaoImpl dao;
	
	private  PoliceDaoImpl() {}
	
	public static PoliceDaoImpl getInstance() {
		if(dao==null) dao = new PoliceDaoImpl();
		return dao;
	}
	
	@Override
	public List<PoliceVO> getAllPolice() {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<PoliceVO> policeList = null;
		
		try {
			policeList = session.selectList("police.getAllPolice");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return policeList;
	}

}
