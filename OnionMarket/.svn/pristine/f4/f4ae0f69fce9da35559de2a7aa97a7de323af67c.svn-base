package kr.or.ddit.comnews.service;

import java.util.List;

import kr.or.ddit.comnews.dao.ComNewsDaoImpl;
import kr.or.ddit.comnews.dao.IComNewsDao;
import kr.or.ddit.vo.ComNewsVO;

public class ComNewsServiceImpl implements IComNewsService {
	
	private IComNewsDao dao;
	private static ComNewsServiceImpl service;
	private ComNewsServiceImpl() {
		dao = ComNewsDaoImpl.getInstance();
	}
	public static ComNewsServiceImpl getInstance() {
		if(service == null) service = new ComNewsServiceImpl();
		return service;
	}
	
	@Override
	public List<ComNewsVO> getNewsList() {
		return dao.getNewsList();
	}
	@Override
	public int comNewsInsert(ComNewsVO comNewsVo) {
		return dao.comNewsInsert(comNewsVo);
	}
	@Override
	public int reset() {
		return dao.reset();
	}

}
