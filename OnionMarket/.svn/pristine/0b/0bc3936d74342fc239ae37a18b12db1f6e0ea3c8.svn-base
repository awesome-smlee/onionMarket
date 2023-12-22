package kr.or.ddit.que.service;

import java.util.List;

import kr.or.ddit.que.ado.IQueDao;
import kr.or.ddit.que.ado.QueDaoImpl;
import kr.or.ddit.vo.QueVO;

public class QueServiceImpl implements IQueService {
	// 1번
	private static QueServiceImpl service;

	private IQueDao dao; // DAO객체 변수 선언

	// 생성자 ==> 2번
	private QueServiceImpl() {
		dao = QueDaoImpl.getInstance(); // DAO객체 생성
	}

	// 3번
	public static QueServiceImpl getInstance() {
		if (service == null)
			service = new QueServiceImpl();

		return service;
	}

	@Override
	public List<QueVO> getAllQue() {
		return dao.getAllQue();
	}

	@Override
	public int queIns(QueVO qv) {
		return dao.queIns(qv);
	}

	@Override
	public int queDel(String queNo) {
 		return dao.queDel(queNo);
	}

	@Override
	public int getListCount(int queId) {
 		return dao.getListCount(queId);
	}

	@Override
	public int qeuAns(QueVO qv) {
 		return dao.qeuAns(qv);
	}
 
	@Override
	public int admQueDel(String upip) {
 		return dao.queDel(upip);
	}
	
}
