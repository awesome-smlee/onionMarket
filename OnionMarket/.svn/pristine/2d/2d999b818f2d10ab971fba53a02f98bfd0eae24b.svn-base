package kr.or.ddit.com.service;

import java.util.List;

import kr.or.ddit.com.dao.ComDaoImpl;
import kr.or.ddit.com.dao.IComDao;
import kr.or.ddit.vo.ComJoinVO;

public class ComServiceImpl implements IComService {
	
	private IComDao dao;
	private static ComServiceImpl service;
	private ComServiceImpl() {
		dao = ComDaoImpl.getInstance();
	}
	public static ComServiceImpl getInstance() {
		if(service == null) service = new ComServiceImpl();
		return service;
	}
	@Override
	public List<ComJoinVO> getAllCom() {
		return dao.getAllCom();
	}
	@Override
	public List<ComJoinVO> getCateNm() {
		return dao.getCateNm();
	}
	@Override
	public int comInsert(ComJoinVO comVo) {
		return dao.comInsert(comVo);
	}
	@Override
	public List<ComJoinVO> getByCate(String cateNm) {
		return dao.getByCate(cateNm);
	}
	@Override
	public List<ComJoinVO> getSearchCom(String keyword) {
		return dao.getSearchCom(keyword);
	}
	@Override
	public List<ComJoinVO> getByGu(String gu) {
		return dao.getByGu(gu);
	}
	@Override
	public ComJoinVO getComDetail(int com_id) {
		return dao.getComDetail(com_id);
	}
	@Override
	public int getComId(ComJoinVO comVo) {
		return dao.getComId(comVo);
	}
	@Override
	public int incrementVwCnt(int comId) {
		return dao.incrementVwCnt(comId);
	}
	@Override
	public ComJoinVO getUpdateData(int comId) {
		return dao.getUpdateData(comId);
	}
	@Override
	public int comUpdate(ComJoinVO comVo) {
		return dao.comUpdate(comVo);
	}
	@Override
	public int comDelete(int comId) {
		return dao.comDelete(comId);
	}
	@Override
	public String getInsId(int comId) {
		return dao.getInsId(comId);
	}

}
