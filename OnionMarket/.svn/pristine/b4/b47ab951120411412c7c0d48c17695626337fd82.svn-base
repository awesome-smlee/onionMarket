package kr.or.ddit.adm.service;

import java.util.List;

import kr.or.ddit.adm.dao.IPoliceDao;
import kr.or.ddit.adm.dao.PoliceDaoImpl;
import kr.or.ddit.vo.PoliceVO;

public class PoliceServiceImpl implements IPoliceService {

	private static PoliceServiceImpl service;
	
	private IPoliceDao dao;
	
	private PoliceServiceImpl() {
		dao = PoliceDaoImpl.getInstance();
	}
	
	public static PoliceServiceImpl getInstance() {
		if(service==null) service = new PoliceServiceImpl();
		return service;
	}
	
	@Override
	public List<PoliceVO> getAllPolice() {
		return dao.getAllPolice();
	}

}
