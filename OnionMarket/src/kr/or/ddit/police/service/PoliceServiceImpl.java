package kr.or.ddit.police.service;

import java.util.List;

import kr.or.ddit.police.dao.IPoliceDao;
import kr.or.ddit.police.dao.PoliceDaoImpl;
import kr.or.ddit.vo.PoliceVO;

public class PoliceServiceImpl implements IPoliceService {
	
	private IPoliceDao dao;
	private static PoliceServiceImpl service;
	private PoliceServiceImpl() {
		dao = PoliceDaoImpl.getInstance();
	}
	public static PoliceServiceImpl getInstance() {
		if(service == null) service = new PoliceServiceImpl();
		return service;
	}

	@Override
	public List<PoliceVO> getAllPol() {
		return dao.getAllPol();
	}

	@Override
	public int polInsert(PoliceVO polVo) {
		return dao.polInsert(polVo);
	}

}
