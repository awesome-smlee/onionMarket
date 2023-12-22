package kr.or.ddit.comrep.service;

import java.util.List;

import kr.or.ddit.comrep.dao.ComRepDaoImpl;
import kr.or.ddit.comrep.dao.IComRepDao;
import kr.or.ddit.vo.ComRepVO;

public class ComRepServiceImpl implements IComRepService {
	
	private IComRepDao dao;
	private static ComRepServiceImpl service;
	private ComRepServiceImpl() {
		dao = ComRepDaoImpl.getInstance();
	}
	public static ComRepServiceImpl getInstance() {
		if(service == null) service = new ComRepServiceImpl();
		return service;
	}
	
	@Override
	public List<ComRepVO> getReply(int comId) {
		return dao.getReply(comId);
	}
	@Override
	public int getRepCount(int comId) {
		return dao.getRepCount(comId);
	}
	@Override
	public int comRepInsert(ComRepVO comRepVo) {
		return dao.comRepInsert(comRepVo);
	}
	@Override
	public int comRepDelete(int repId) {
		return dao.comRepDelete(repId);
	}
	
}
